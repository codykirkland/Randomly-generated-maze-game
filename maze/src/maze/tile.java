/*
 * this is the spaces in the maze
 */
package maze;
import javax.swing.JPanel;
/**
 *
 * @author 2000222557
 */
public class tile extends JPanel {
    
    int x,y;//this is the x and the y of the tile
    boolean twall= true;//the top wall
    boolean bwall= true;//the bottom wall
    boolean rwall= true;//the right wall
    boolean lwall= true;//the left wall
    boolean visited= false;//if the tile has been visited it becomes true
    boolean exit = false;//this marks the exit of the maze
    public tile(int y , int x){
        this.x = x;
        this.y = y;
        
    }
    
}
