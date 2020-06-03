/*
 * this is a maze game. the game will randomly generate a maze for the player to beat.
 * the player will use either the w/a/s/d keys or the arrows to move.
 * when the player finishes the maze a joptionpane will pop up congratulating them 
 * when the player presses ok a new maze will be generated
 */
package maze;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.*;

/**
 *
 * @author 2000222557
 */
public class Maze extends JFrame {

    static int row = 35;//number of rows in the maze
    static int col = 35;//number of columns in the maze
    static int psize = 15;//the size of the tiles
    
    static tile t[][] = new tile[col][row];//this is what the maze is made out of.
    player p = new player(0,0);//the player
    Random rand = new Random();
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new main_menu();//this launches the start screen
    }
    
    
    
    public Maze(){   
       
        
        cratemaze();//this creates the maze
   

        //the window diameter
        this.setResizable(false);
        this.setSize((col*psize)+63, (row*psize)+100);
        this.setTitle("maze");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            

        
        //add a key listener to determine the direction the player wants to move
        this.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e){

                int dir = e.getKeyCode();//gets the direction the player wants to move

                revalidate();
                repaint();

                //determines what direction the player wants to move
                switch(dir)
                    {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        if(!t[p.getPx()][p.getPy()].twall){
                            p.move(0,-1,psize);//move up
                            }
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        if(!t[p.getPx()][p.getPy()].lwall){
                            p.move(-1,0,psize);//move left
                            }
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                         if(!t[p.getPx()][p.getPy()].bwall){
                            p.move(0,1,psize);//move down
                              
                            }
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        if(!t[p.getPx()][p.getPy()].rwall){
                            p.move(1,0,psize);//move right
                            }
                        break;

                }
                //this check to see if the payer made it to the end of the maze
                if (t[p.getPx()][p.getPy()].exit){
                    JOptionPane.showMessageDialog(null, "Congratulations \nclick ok to generate another maze", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new Maze();
                    }
                       
            }

            public void keyReleased(KeyEvent e){

                }

            public void keyTyped(KeyEvent e){

                }

            });



        this.setLocationRelativeTo(null);


        //adds the player
        p.setVisible(true);
        this.add(p);

        //display the maze
        for(int y = 0; y<col; y++){
            for(int x=0; x<row; x++){
                     
            int top = 0,bottom = 0,left= 0,right = 0;
            
            t[y][x].setSize(psize,psize);//sets the size of the tile   
            t[y][x].setLocation((y*psize)+23, (x*psize)+25);//sets the location of the tile
                    
            //makes the exit tile red
            if(t[y][x].exit == true){
                t[y][x].setBackground(Color.RED);
                }
            else{
                t[y][x].setBackground(Color.WHITE);
                }
                            
            //tells if the top wall is there
            if (t[y][x].twall)
               top = 1;

                //tells if the bottom wall is there                
            if (t[y][x].bwall)
                bottom = 1;

                //tells if the left wall is there
            if (t[y][x].lwall)
                left =1;

                //tells if the right wall is there 
            if (t[y][x].rwall)
                right =1;
                
                
            //makes the walls
            t[y][x].setBorder(new MatteBorder(top, left, bottom, right, Color.BLACK));
                
                
            p.setSize(Maze.psize, Maze.psize);//sets the size of the player
            p.setLocation((0*psize)+23, (0*psize)+25);//sets the location of the player
            p.setBackground(Color.GREEN);//sets the player to green        
                
            t[y][x].setVisible(true);//makes the tile visible
            this.add(t[y][x]);//adds the tile to the jframe
            }
        }   
        
        
       
        //create a label
        JLabel Label = new JLabel("use the w/a/s/d or the arrow keys to move");
        Label.setBounds(25, 545, 300, 60);
        Label.setFont(new Font("Serif", Font.PLAIN,16 ));
        this.setVisible(true);
        this.add(Label);
        
        }
     /**
      * this populates the 2d array with tiles
      */
    public void cratemaze(){
         for(int y = 0; y<col; y++){
            for(int x=0; x<row; x++){ 
              t[y][x]=new tile(y,x);//create a new tile
            }
         }
         makemaze();
     }
     /**
      * this generates the maze out of the tiles
      */
    public void makemaze(){

        List<tile> tiles = new ArrayList<>();

        //list of directions
        List<Integer> DirectionList = Arrays.asList(1,2,3,4);
        
       
     

        int index;//the index of an object in the arraylsit

        tile current,next = null;//the current tile and the next tile


        current= t[0][0];//sets the start point of the maze

        tiles.add(current);//add the first tile to the arraylist
        current.visited = true;//marks the tile as visited


        //loops until tiles is empty
        while(!tiles.isEmpty()) {

            index = rand.nextInt(tiles.size());//gets a random index


            current = tiles.get(index);//sets the current to the index

            Collections.shuffle(DirectionList);//shuffles the DirectionList

            //loops through all the directions until a wall is removed
            for (int dir: DirectionList) {

                //up
                if (dir== 1){
                    //checks if current is in the array
                    if (current.x>0) {
                        next = t[current.y][current.x - 1];
                    }
                }
                //down
                if (dir== 2){
                    //checks if current is in the array
                    if (current.x<row-1) {
                        next = t[current.y][current.x + 1];
                    }
                }
                //left
                if (dir== 3) {
                    //checks if current is in the array
                    if (current.y < col - 1) {
                        next = t[current.y + 1][current.x];
                    }
                }
                //right
                if (dir== 4) {
                    //checks if current is in the array
                    if (current.y > 0) {
                        next = t[current.y - 1][current.x];
                    }
                }

                //check if next does not equal null or next has not been visited
                if (next !=null &&!next.visited){
                    removewall(current,next);
                    tiles.add(next);
                    next.visited = true;
                    index = -1;
                    break;
                }
            }
            //if all the directions have been visited it removes it from the list
            if (index !=-1){
                tiles.remove(index);
            }
            
        }
        
        t[col-1][row-1].exit= true;//this sets the exit of the maze
        
    }
     /**
      * this removes the wall of the maze
      * @param current this is the current tile
      * @param next this this the next tile that the algorithm will move to 
      */
    public void removewall(tile current,tile next){
        //removes the top wall
        if(current.y == next.y && current.x == next.x+1){
            current.twall = false;
            next.bwall = false;
        }
        //removes the bottom wall
        if(current.y == next.y && current.x == next.x-1){
            current.bwall = false;
            next.twall = false;
        }
        //removes the left wall
        if(current.y == next.y+1 && current.x == next.x){
            current.lwall = false;
            next.rwall = false;
        }
        //removes the right wall
        if(current.y == next.y-1 && current.x == next.x){
            current.rwall = false;
            next.lwall = false;  
     }
     }
     
}
