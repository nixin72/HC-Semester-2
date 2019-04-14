package B20_L02;

/**
 * Title:        420-B20 Labs - Winter, 2016
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author Philip Dumaresq
 * @version 1.0
 */
public class TestStatic
{
  public static void main(String[] args)
  {
    StaticVariable s1 = new StaticVariable("s1");
    showHeadings();
    showNumbers(s1);
    StaticVariable s2 = new StaticVariable("s2");
    showNumbers(s2);
    StaticVariable s3 = new StaticVariable("s3");
    showNumbers(s3);

    System.out.println("\nIncrementing numbers in s1 now");
    showHeadings();
    s1.incrementNumbers();
    showNumbers(s1);
    showNumbers(s2);
    showNumbers(s3);

    System.out.println("\nIncrementing numbers in s2 now");
    showHeadings();
    s2.incrementNumbers();
    showNumbers(s1);
    showNumbers(s2);
    showNumbers(s3);
    
    System.out.println("\nSetting staticNum in s1 now");
    showHeadings();
    s1.setStaticNum(15);
    showNumbers(s1);
    showNumbers(s2);
    showNumbers(s3);

    System.out.println("\nSetting staticNum for StaticVariable now");
    showHeadings();
    StaticVariable.setStaticNum(125);
    showNumbers(s1);
    showNumbers(s2);
    showNumbers(s3);
  } // main()

	public static void showHeadings()
	{
//		System.out.printf("%-15s%10s\n", "Object name", "num");
		System.out.printf("%-15s%10s%10s\n", "Object name", "staticNum", "num");
	} // showHeadings()

	public static void showNumbers(StaticVariable sv)
	{
//		System.out.printf("%-15s%10d\n", sv.getName(),sv.getNum());
		System.out.printf("%-15s%10d%10d\n", sv.getName(), sv.getStaticNum(),
				sv.getNum());
	} // showNumbers(StaticVariable)

} // TestStatic class