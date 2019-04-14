package b20_L06_Project;

/**
 * Title:        420-B20 Lab 6
 * Description: Represents the courses in a school.
 * @author Anne Hamilton
 * @version 1.0
 */

import java.io.*;
import java.text.NumberFormat;

public class School
{
  public static void main(String[] args) 
  {
    Course B20 = new Course("Programming II");
    NumberFormat fixed = NumberFormat.getNumberInstance();
    fixed.setMaximumFractionDigits(2);
    fixed.setMinimumFractionDigits(2);

    B20.readMarks();
    B20.calculateAverage();
    System.out.println("The class average for " + B20.getName() + " is "
        + fixed.format(B20.getAverage()));
    B20.displayTopMarks();
    B20.displayDistribution();
  }
}