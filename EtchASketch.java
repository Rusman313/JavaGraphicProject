import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class EtchASketch extends Canvas
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	int x, y;
	Color cur;
	
	public static void main( String[] args )
	{
		JFrame win = new JFrame("Use the arrow keys!");
		win.setSize(1024,768);
		win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		win.add( new EtchASketch() );
		win.setVisible(true);
	}

	public EtchASketch()
	{
		enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
		requestFocus();
		x = 500;
		y = 400;
		cur = Color.black;
	}

	public void paint( Graphics g )
	{
		g.setColor(cur);
		g.fillOval(x, y, 20, 20);
	}

	public void update( Graphics g )
	{
		paint(g);
	}

	public void processKeyEvent(KeyEvent e)
	{
		// this method automatically gets called with they press a key
		if ( e.getID() == KeyEvent.KEY_PRESSED )
		{
			if ( e.getKeyCode() == KeyEvent.VK_LEFT )
				x -= 5;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				x += 5;
			if (e.getKeyCode() == KeyEvent.VK_UP)
				y -= 5;
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
				y += 5;

			// and we manually call paint() again to redraw
			repaint();
		}
	}
	
	public boolean isFocusable()
	{
		return true;
	}
}