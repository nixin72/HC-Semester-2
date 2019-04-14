package bouncingBall;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BouncingBallFrame extends JFrame implements MouseListener  
{
  private Ball[] ball = new Ball[100];
	int numBalls;
	public BouncingBallFrame()
	{
		addMouseListener(this);
		numBalls = 0;
		this.setTitle("Bounce-A-Ball");
		this.setSize(400, 300);
		this.getContentPane().setLayout(null);
		ball[numBalls] = new Ball(this);		
	} // BouncingBallFrame()

	public void paint(Graphics g)
	{
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
	
		for ( int q = 0 ; q < numBalls+1 ; q ++ ) {
			g.setColor(ball[q].getColor());
			g.fillOval(ball[q].getX(), ball[q].getY(), ball[q].SIZE, ball[q].SIZE);
		}
	} // paint(Graphics)

	public static void main(String args[])
	{
		{
			JFrame frame = new BouncingBallFrame();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = frame.getSize();
			if (frameSize.height > screenSize.height)
			{
				frameSize.height = screenSize.height;
			}
			if (frameSize.width > screenSize.width)
			{
				frameSize.width = screenSize.width;
			}
			frame.setLocation((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.height) / 2);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		if (numBalls < ball.length) {
			ball[numBalls+1] = new Ball(this);
			ball[numBalls].start();
			numBalls++;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
} // BouncingBallFrame

	