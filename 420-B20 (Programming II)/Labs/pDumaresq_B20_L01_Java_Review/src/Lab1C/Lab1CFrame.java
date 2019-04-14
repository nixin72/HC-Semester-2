package Lab1C;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Title:         420-B20 Lab 1 - Winter, 2012
 * Description:   This frame areaDisplays a list of odd or even numbers between
 *                1 and a maximum value specified by the user.
 * Copyright:     Copyright (c) 2012
 * Company:
 * @author Anne Hamilton
 * @version 2.0
 */

public class Lab1CFrame
  extends JFrame
  implements ActionListener
{
  private List numbers;
  private JButton btnOdd;
  private JLabel fldPrompt;
  private JTextField fldInputNumber;
  private JTextArea areaDisplay;
  private int max;

  public Lab1CFrame()
  {
    numbers = new List();
    setTitle("Welcome Back Frame");
    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    JPanel inputPanel = new JPanel();
    JPanel areaDisplayPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    fldPrompt = new JLabel("Enter maximum number: ");
    inputPanel.add(fldPrompt);
    fldInputNumber = new JTextField(10);
    inputPanel.add(fldInputNumber);
    btnOdd = new JButton("Odd Numbers");
    buttonPanel.add(btnOdd);
    areaDisplay = new JTextArea(10, 30);
    areaDisplayPanel.add(areaDisplay);
    areaDisplay.setEditable(false);
    contentPane.add("Center", areaDisplayPanel);
    contentPane.add("North", inputPanel);
    contentPane.add("South", buttonPanel);
    setSize(400, 300);
  } // constructor

    public void actionPerformed(ActionEvent e)
    {
      String enter = fldInputNumber.getText();
      if (enter.length() != 0)
      {
        max = Integer.parseInt(enter);
        numbers.setMax(max);
        numbers.displayOdds(areaDisplay);
      } // else if(maxIsEntered)
      else
        areaDisplay.setText("Please enter a maximum number");
    } // actionPerformed(ActionEvent e)

  public static void main(String[] args)
  {
    Lab1CFrame frame = new Lab1CFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
} // Lab1CFrame
