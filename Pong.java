import java.awt.*;
import java.awt.geom.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.util.Random;
import java.util.Timer;

public class Pong extends Canvas
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Point delta;
	Ellipse2D.Double ball;
    Rectangle paddle1;
    Rectangle paddle2;
    int p1Score;
    int p2Score;
	
	public static void main( String[] args )
	{
		JFrame win = new JFrame("Pong");
		win.setSize(1010,735);
		win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		win.add( new Pong() );
		win.setVisible(true);
	}

	public Pong()
	{
		enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
		requestFocus();
		
		ball = new Ellipse2D.Double(500,350,20,20);
		delta = new Point(-5,5);
        paddle1 = new Rectangle(50,250,20,200);
        paddle2 = new Rectangle(850, 250, 20, 200);
        
		
		Timer t = new Timer(true);
		t.schedule( new java.util.TimerTask()
		{
			public void run()
			{
				doStuff();
				repaint();
			}
		}, 15, 15);

	}

	public void paint( Graphics g )
	{
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.black);
		g2.fill(ball);
		
		g2.setColor(Color.blue);
        g2.fill(paddle1);
        
        g2.setColor(Color.red);
        g2.fill(paddle2);
        
        g2.setColor(Color.black);
        g2.setFont(new Font("Ariel", 1, 30));
        g2.drawString("Player1 Score: " +Integer.toString(p1Score), 15, 50);

        g2.setColor(Color.black);
        g2.setFont(new Font("Ariel", 1, 30));
        g2.drawString("Player2 Score: " + Integer.toString(p2Score), 500, 50);

       /*  g2.setColor(Color.blue);
        Font font = new Font("Verdana", Font.BOLD, 15);
        g.setFont(font);
        g2.drawString("Score for player1: " + paddle1Score, 15, 30);
        g2.drawString("Score for player2: " + paddle2Score, 800, 30); */
    }
	

	public void processKeyEvent(KeyEvent e)
	{
		if ( e.getID() == KeyEvent.KEY_PRESSED )
		{
			if ( e.getKeyCode() == KeyEvent.VK_W )
			{
				paddle1.y -= 30; 
			}
			if ( e.getKeyCode() == KeyEvent.VK_S )
			{
				paddle1.y += 30;
            }
            if ( e.getKeyCode() == KeyEvent.VK_UP )
			{
				paddle2.y -= 30; 
			}
			if ( e.getKeyCode() == KeyEvent.VK_DOWN )
			{
				paddle2.y += 30;
			}
		}
	}
	
	public void doStuff()
	{
		ball.x += delta.x;
		ball.y += delta.y;

		// and bounce if we hit a wall
		if ( ball.y < 0 || ball.y+20 > 700 )
			delta.y = -delta.y;
		if ( ball.x < 0 )
			delta.x = -delta.x;
			
		// check if the ball is hitting the paddle
		if ( ball.intersects(paddle1) )
            delta.x = -delta.x;
        if (ball.intersects(paddle2))
            delta.x = -delta.x;
			
		// check for scoring
		if ( ball.x > 1000 )
		{
			ball.x = 500;
			ball.y = 350;
            delta = new Point(-5,5);
            p1Score ++;
		}
		if (ball.x <= 0) {
            ball.x = 500;
            ball.y = 350;
            delta = new Point(5, -5);
            p2Score++;
        }

    }
		
	public boolean isFocusable() { return true;	}
}