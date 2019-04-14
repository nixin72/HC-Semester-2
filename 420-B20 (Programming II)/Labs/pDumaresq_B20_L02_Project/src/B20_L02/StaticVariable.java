package B20_L02;

/**
 * Title:        420-B20 Labs - Winter, 2016
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author Anne Hamilton
 * @version 1.0
 */
public class StaticVariable
{
  private int num = 0;
  private String name;
  private static int staticNum = 0;
  
  public StaticVariable()
  {
    num++;
    name = "Undefined";
    staticNum++;
  } // StaticVariable()

  public StaticVariable(String n)
  {
    num++;
    name = n;
    staticNum++;
  } // StaticVariable(String)

  public void incrementNumbers()
  {
    num++;
    staticNum++;
  } // incrementNumbers()

  public static void setStaticNum(int newStatic) {
	  
  }
  
  public int getStaticNum() {
	  return staticNum;
  }
  
  public void setNum(int num)
  {
    this.num = num;
  }

  public int getNum()
  {
    return num;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }
} // StaticVariable class
