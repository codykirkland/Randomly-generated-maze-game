/*
 * this is the player in the maze
 */
package maze;


import javax.swing.JPanel;

/**
 *
 * @author 2000222557
 */
public class player extends JPanel{
    int px,py;//this is how it is determine where the player is in the maze
    
    public player(int y,int x){
        this.px = x;//this makes px into x
        this.py = y;//this makes py into y

    }
   
    /**
     * this is all of the getters and setters
     * @return 
     */
    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }
    
    /**
    * moves the player
    */
    public void move(int x, int y, int size){
        	       
        try{
             
            //moves the player in the direction that was entered
            this.setLocation(this.getX()+(x*size), this.getY()+(y*size));
            px+=x;
            py+=y;
           
        }
        catch(ArrayIndexOutOfBoundsException e){}
    }
    
}
