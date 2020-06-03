/*
 * this is the start screen of the game
 */
package maze;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author 2000222557
 */
public class main_menu extends JFrame {
    int bw = 110; //the width of the menu button
    int bh = 30;//the height of the menu button
    int my = 550; //the y axis of the buttons 
    
    
    public main_menu() {
            
             //the window variables
             this.setResizable(false);
             this.setSize(588, 625);
             this.setLayout(null);
             this.setTitle("the generated maze game");
             this.setLocationRelativeTo(null);
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
            JButton play = new JButton("play");//this button will play the game
            JButton exit = new JButton("exit");//this button will exit the game
            JLabel label = new JLabel("<html><pre>THE \nGENERATED \nMAZE GAME<pre><html>");//the title of the screen
    

             //play button variables
             play.setSize(bw,bh);
             play.setLocation(5, my);
             this.add(play);
             play.addActionListener(new ActionListener(){

                             public void actionPerformed(ActionEvent e) {
                                     
                                 new Maze();//this will launch the maze
                                 dispose();//this will get rid of start screen window
                             }

             });	

             
             
             //exit button variables
             exit.setSize(bw,bh);
             exit.setLocation(457,my);
             this.add(exit);
             exit.addActionListener(new ActionListener(){

                             public void actionPerformed(ActionEvent e) {
                         System.exit(0);
                             }
             });
               
             //display label
           label.setBounds(39, 25, 412, 412);
           label.setFont(new Font("courier", Font.BOLD,75 ));
           this.add(label);
           this.setVisible(true);
        }
    
}
