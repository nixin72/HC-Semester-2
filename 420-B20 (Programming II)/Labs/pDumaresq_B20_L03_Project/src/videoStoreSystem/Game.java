package videoStoreSystem;

public class Game extends Product {
	/* Instance Variables */
	private int platformCode;
	private int formatCode;

	/* Constructor Methods */
	public Game() {
		platformCode = 0;
		System.out.println("In Game constructor");
		setProductNumber();
		System.out.println("The product number is: " + productNumber);
	}

	public Game(String t) {
		super(t);
		platformCode = 0;
		setProductNumber();
		System.out.println("The product number is: " + productNumber);
	}

	public Game(String t, int year, String c, String f) {
		super(t, year, c, f);
		platformCode = 0;
		setProductNumber();
		System.out.println("The product number is: " + productNumber);
	}

	public Game(String t, int year, String c, String f, int p) {
		super(t, year, c, f);
		platformCode = p;
		setProductNumber();
		System.out.println("The product number is: " + productNumber);
	}

	/* Accessors And Mutators */
	public void setPlatformCode() {
	}

	public int getPlatformCode() {
		return platformCode;
	}

	private void setProductNumber() {
		productNumber = "G" + productNumber;
	}

	public void setCategoryCode(String categoryName) {
		System.out.println("In the Game setCategoryCode(String)" + " method");
		if (categoryName.equalsIgnoreCase("RPG"))
			categoryCode = 1;
		else if (categoryName.equalsIgnoreCase("Action"))
			categoryCode = 2;
		else if (categoryName.equalsIgnoreCase("Education"))
			categoryCode = 3;
		else
			categoryCode = 0;
	} // setCategory()

	public void setFormatCode(String p) {
		if (p.equals("DVD"))
			formatCode = 1;
		else if (p.equals("CD"))
			formatCode = 2;
		else
			formatCode = 0;
	}

	public void setPlatformCode(String platform) {
		if (platform.equalsIgnoreCase("Sony PlayStation"))
			platformCode = 1;
		else if (platform.equalsIgnoreCase("Microsoft xBox"))
			platformCode = 2;
		else if (platform.equalsIgnoreCase("Nintendo Wii U"))
			platformCode = 3;
		else if (platform.equalsIgnoreCase("Nintendo Wii"))
			platformCode = 4;
		else
			platformCode = 0;
	}
}
