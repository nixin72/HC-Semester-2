package bouncingBall;

import java.awt.Color;

public class Ball extends Thread
{
  public static final int SIZE = 10;
  private BouncingBallFrame frame;
  private int xPosition;
  private int yPosition;
  private int bottom, top;
  private int direction;
  private Color color;
  private static final Color[] COLOR = {Color.blue, Color.red, Color.cyan, Color.green, Color.orange, Color.pink, Color.black, Color.magenta };
  
 
  public Ball(BouncingBallFrame f)
  {
    super();
    frame = f;
    bottom = frame.getHeight();
    top =  35;
    xPosition = (int)(Math.random()* frame.getWidth());
    yPosition = bottom-(SIZE*2);
    direction = -1;
    
    int random = (int) (Math.random() * (COLOR.length));
    color = COLOR[random];
  } // Ball(BouncingBallFrame)

  public Color getColor() {
  	return color;
  }
  
  public void move()
  {
    yPosition += direction;
    if (yPosition <= top || yPosition >= bottom)
      direction *= -1;
    
    frame.repaint();
    try
		{
			Thread.sleep(2);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  } // move()

  public int getX()
  {
    return xPosition;
  } // getX()

  public int getY()
  {
    return yPosition;
  } // getY()

  public void run() {
  	while (true) {
  		move();
  	}
  }
} // Ball
