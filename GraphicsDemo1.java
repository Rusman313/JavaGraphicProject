/* Assignments turned in without these things will receive half credit or less. Answer any questions in comments at the top of GraphicsDemo1.java.

How big is the window that appears? How many pixels wide? How many pixels tall?
#(800,600);
In the call to the function g.drawRect(), there are four numbers. What do they mean? Try changing them to figure it out.
#g.drawRect(50,20,100,500);  how far over from the left ,how far down from the top,width,height// draw a rectangle
What about the call to fillOval()? What do the four numbers mean here?
# g.fillOval(160,20,100,200); how far over from the left, how far down from the top, width, height// draw a filled-in oval
What are the two numbers in the call to drawString()?
#The drawString() method, shown below, takes as parameters an instance of the String class containing the text to be drawn, and two integer values specifying the coordinates where the text should start.
What happens when two objects overlap? Which one is drawn on top? the later object is drawn on top
Add a red, filled-in square somewhere in the lower-right of the canvas. */

import java.awt.*;
import javax.swing.JFrame;

public class GraphicsDemo1 extends Canvas
{
    public void paint( Graphics g )
    {
        g.setColor(Color.green);
        g.drawRect(50,20,100,200);  // draw a rectangle
        g.fillOval(160,20,100,200); // draw a filled-in oval
        g.setColor(Color.blue);
        g.fillRect(200,20,200,20); // a filled-in rectangle
        g.drawOval(200,430,200,100);
        g.setColor(Color.red);
        g.fillRect(600, 400, 100, 100);// created new filled in red square in bottom right of window whoop whoop
        
    
        
        g.setColor(Color.black);
        g.drawString("Graphics are pretty neat.", 500, 100);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        g.drawString("The first letter of this string is at (" + x + "," + y + ")", x, y);
    }

    public static void main( String[] args )
    {
        // You can change the title or size here if you want.
        JFrame win = new JFrame("GraphicsDemo1");
        win.setSize(800,600);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsDemo1 canvas = new GraphicsDemo1();
        win.add( canvas );
        win.setVisible(true);
    }
}