package Lab1C;

import javax.swing.JTextArea;

/**
 * Title:         420-B20 Labs - Winter, 2012
 * Description:   This class contains methods to display a list of odd or
 *                even integers up to a specified maximum.
 * Copyright:     Copyright (c) 2012
 * Company:
 * @author Anne Hamilton
 * @version 2.0
 */

public class List
{
  private int max;

  public List()
  {
  } // List()

  public List(int m)
  {
    max = m;
  } // List(int)

  public void setMax(int m)
  {
    max = m;
  } // setMax(int)

  public void displayOdds(JTextArea display)
  {
    display.setText("Odd Numbers from 1 to " + max + "\n");
    int odd = 1;
    while (odd <= max) {
    	display.append(odd + " ");
    	odd++;
    }
  } // displayOdds(TextArea)

} // List Class








