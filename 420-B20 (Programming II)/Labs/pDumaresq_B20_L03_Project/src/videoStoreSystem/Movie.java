package videoStoreSystem;

public class Movie extends Product {

	/* Instance Variables */
	private String director;

	/* Constructor Methods */
	public Movie() {
		director = "unknown";
		System.out.println("In Movie constructor");
		setProductNumber();
	}

	public Movie(String t) {
		super(t);
		director = "Unknown";
		System.out.println("In Movie(String) constructor");
		setProductNumber();
	}

	public Movie(String t, int year, String c, String f) {
		super(t, year, c, f);
		director = "Unknown";
		setProductNumber();
	}

	public Movie(String t, int year, String c, String f, String d) {
		super(t, year, c, f);
		director = "d";
		setProductNumber();
	}

	/* Accessors and Mutators */
	public void setDirector() {
	}

	public String getDirector() {
		return director;
	}

	private void setProductNumber() {
		productNumber = "M" + productNumber;
	}

	public void setCategoryCode(String categoryName) {
		System.out.println("In the Movie setCategoryCode(String)" + " method");
		if (categoryName.equalsIgnoreCase("Family"))
			categoryCode = 1;
		else if (categoryName.equalsIgnoreCase("Action"))
			categoryCode = 2;
		else if (categoryName.equalsIgnoreCase("Comedy"))
			categoryCode = 3;
		else if (categoryName.equalsIgnoreCase("Western"))
			categoryCode = 4;
		else if (categoryName.equalsIgnoreCase("Drama"))
			categoryCode = 5;
		else if (categoryName.equalsIgnoreCase("Horror"))
			categoryCode = 6;
		else if (categoryName.equalsIgnoreCase("Sci-fi"))
			categoryCode = 7;
		else
			categoryCode = 0;
	} // setCategory()

}
