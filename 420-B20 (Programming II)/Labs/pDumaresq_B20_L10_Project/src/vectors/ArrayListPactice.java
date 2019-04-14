package vectors;

import java.util.ArrayList;

public class ArrayListPactice
{
	ArrayList<Integer> myArray = new ArrayList<Integer>();
	
	public void generateNumbers() {
		int random;
		for (int i = 0 ; i < 11 ; i++) {
			random = (int) Math.floor(Math.random() * 10);
			myArray.add(random);
		}
	}
	
	public void printEvenNumbers() {
		for (int i = 0 ; i < myArray.size() ; i++) {
			if (myArray.get(i) < 0) {
				myArray.set(myArray.get(i), 0);
			}
			
			if ((myArray.get(i)%2) == 0) {
				System.out.println(myArray.get(i));
			}
			else if ((myArray.get(i)%2) != 0) {
				myArray.remove(myArray.get(i));
			}
		}
	}
	
	
	public static void main(String[] args)
	{
	
		ArrayListPactice startProgram = new ArrayListPactice();
		startProgram.generateNumbers();
		startProgram.printEvenNumbers();
	}

}
