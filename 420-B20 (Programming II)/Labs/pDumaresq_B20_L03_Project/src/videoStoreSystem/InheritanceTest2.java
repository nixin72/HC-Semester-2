package videoStoreSystem;

import java.util.Scanner;

public class InheritanceTest2 {

	public static void main(String[] args) {
		Movie product = null;
		Game product2 = null;
		Scanner input = new Scanner(System.in);

		Product.open();

		System.out.print("Enter product type (M - Movie, G - Game) > ");
		char productType = Character.toUpperCase(input.nextLine().charAt(0));
		System.out.print("Enter title> ");
		String title = input.nextLine();
		System.out.print("Enter category> ");
		String category = input.nextLine();

		if (productType == 'M') {
			product = new Movie(title, 2015, category, "DVD");
			System.out.print("What is the director's name? ");
			String director = input.nextLine();

			((Movie) product).setDirector(director);

			System.out.println("The director of the movie is " + product.getDirector());
		} else if (productType == 'G') {
			product2 = new Game(title, 2014, category, "DVD");
			System.out.println("What is the console?");
			String platformCode = input.nextLine();

			((Game) product2).setPlatformCode(platformCode);

			System.out.println("The platform code of the game is " + product2.getPlatformCode());
		}

		Product.close();

	}

}
