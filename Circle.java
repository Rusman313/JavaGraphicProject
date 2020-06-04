import java.awt.*;
import javax.swing.JFrame;
//Make a graphics program that displays a green filled-in circle on the screen. The size does not matter, nor does the location.
public class Circle extends Canvas {
    public void paint( Graphics g )
    {
    g.setColor(Color.green);
    g.fillArc(50,400,100,100,225,360);
    }
    public static void main( String[] args )
    {
        JFrame win = new JFrame("test Circle");
        win.setSize(800,600);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Circle canvas = new Circle();
        win.add( canvas );
        win.setVisible(true);
    }
}