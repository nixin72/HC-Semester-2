package B20_L07_Project;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Course
{
  private String courseName;
  private Student student [];
  private int numStudents;

  public Course()
  {
    courseName = "Unknown";
    student = new Student[50];
    numStudents = 0;
    readStudents();
  } // Course()

  public Course(String coursetitle)
  {
    courseName = coursetitle;
    student = new Student[50];
    numStudents = 0;
    readStudents();
  } // Course()

  private void readStudents()
  {
    numStudents = 0;
    try
    {
      Scanner input = new Scanner(new File("grades.txt"));
      while (input.hasNext())
      {
      	student[numStudents] = new Student();
        String inline = input.nextLine();
        StringTokenizer tokens = new StringTokenizer(inline, "~");
        student[numStudents].setStudentName(tokens.nextToken());
        student[numStudents].setStudentGrade(
                                          tokens.nextToken().charAt(0));

        ++numStudents;
      } // while
    } // try
    catch (FileNotFoundException e)
    {
      System.out.println("ERROR: grades.txt was not found.");
    } // catch (FileNotFoundException)
    catch (IOException e)
    {
      System.out.println("ERROR: " + e.getMessage());
    } // catch (IOException)
  } // readGrades()

  public void displayGradeList()
  {
    displayHeadings();
    for (int j = 0; j < numStudents; ++j)
      displayDetailLine(student[j]);
  } // displayGradeList()

  private void displayHeadings()
  {
  	String title = "Grade List for " + courseName;
  	int lineSize = 40;
  	int endOfTitle = (lineSize/2) + (title.length()/2);
    System.out.printf("%"+endOfTitle+"s\n",title);
    StringBuffer underline = new StringBuffer();
    for (int i = 0;i < title.length(); ++i)
    	underline.append('-');
    System.out.printf("%"+endOfTitle+"s\n",underline.toString());    
    System.out.printf("%-30s%10s\n","Name","Average");
    underline = new StringBuffer();
    for (int i = 0;i < lineSize; ++i)
    	underline.append('-');
    System.out.printf("%"+lineSize+"s\n", underline.toString());
  } // displayHeadings()

  private void displayDetailLine(Student student)
  {
    System.out.printf("%-30s%10s\n", student.getStudentName(), student.getStudentGrade());
    //display the student name and grade
    
  } // displayDetailLine()

} // Course class
