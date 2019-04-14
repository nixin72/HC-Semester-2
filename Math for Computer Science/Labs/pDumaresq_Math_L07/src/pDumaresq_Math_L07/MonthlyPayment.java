package pDumaresq_Math_L07;

import java.util.Scanner;

public class MonthlyPayment {
	public static void main(String[] args) {
		double t, r, p, k;
		double n = 12;
		Scanner prompt = new Scanner(System.in);
		
		System.out.print("Duration in years: ");
			t = prompt.nextDouble();
		System.out.print("Annual Interest Rate: ");
			r = (prompt.nextDouble() / 100);
		System.out.print("Initial value: ");
			p = prompt.nextDouble();
		
		k = (p * (r / n)) / (1 - Math.pow((1 + (r / n)) , ((n * -1) * t)));
			System.out.println("The monthly payment is: " + k);
	}
}