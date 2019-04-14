package videoStoreSystem;

public class InheritanceTest {

	public static void main(String[] args) {
		Product.open();

		System.out.println("Instantiating Product class");
		Product product = new Product();

		System.out.println("Instantiating Movie class");
		Movie movie = new Movie("Star Wars: The Force Awakens", 2015, "family", "DVD");
		System.out.println("The title for movie is " + movie.getTitle());
		System.out.println("The category code is " + movie.getCategoryCode());

		System.out.println("Instantiating Game class");
		Game game = new Game("Rock Band 2", 2015, "Education", "DVD");
		System.out.println("The name of the game is " + game.getTitle());
		System.out.println("The category code is " + game.getCategoryCode());

		Product.close();
	}

}
