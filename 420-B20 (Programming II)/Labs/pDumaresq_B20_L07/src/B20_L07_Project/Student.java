package B20_L07_Project;

/**
 * Title:       Student Class - 420-B20 Lab 5
 * Description: Represents a student in a course.
 * Copyright:   Winter, 2002
 * Company:
 * @author Anne Hamilton
 * @version 1.0
 */

public class Student
{
  private String studentName;
  private char studentGrade;

  public Student()
  {
    studentName = "unknown";
    studentGrade = 'U';
  } // Student()

  public Student(String name, char avg)
  {
    studentName = name;
    studentGrade = avg;
  } // student(String, double)

  public void setStudentName(String name)
  {
    studentName = name;
  } // setStudentName(String)

  public void setStudentGrade(char grade)
  {
    studentGrade = grade;
  } // setStudentGrade(char)

  public char getStudentGrade()
  {
    return studentGrade;
  } // getStudentGrade()

  public String getStudentName()
  {
    return studentName;
  } // getStudentName()

} // Student class
