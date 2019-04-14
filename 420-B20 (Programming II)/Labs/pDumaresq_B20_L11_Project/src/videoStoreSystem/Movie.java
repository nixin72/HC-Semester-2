package videoStoreSystem;

import CSClasses.StringMethods;

public class Movie extends Product
{
	// class variables and methods
	private static int countMovies = 0;
	private static final String categoryName[] = { "Unknown", "Family", "Action",
			"Comedy", "Western", "Drama", "Horror", "Sci-Fi" };
	private static final String formatName[] = { "Unknown", "DVD", "DVD-HD",
			"Blu-Ray" };

	public static int getCountMovies()
	{
		return countMovies;
	} // getCountMovies()

	// instance variables
	private String director;
	private int rating;

	// constructors
	public Movie()
	{
		setProductNumber();
		director = "Unknown";
		++countMovies;
	} // Movie()

	public Movie(String t)
	{
		super(t);
		setProductNumber();
		director = "Unknown";
		++countMovies;
	} // Movie(String)

	public Movie(String t, int year, String c, String f)
	{
		super(t, year, c, f);
		setProductNumber();
		director = "Unknown";
		++countMovies;
	} // Movie(String, int, String, String)

	public Movie(String t, int year, String c, String f, String dir, String r)
	{
		super(t, year, c, f);
		setDirector(dir);
		setRating(r);
		++countMovies;
	} // Movie(String, int, String, String, String)

	public Movie(String num, String t, int year, int c, int f, String dir, int r)
	{
		super(num, t, year, c, f);
		setDirector(dir);
		rating = r;
	} // Movie(String, String, int, int, int, String)

	public Movie(String num, String t, int year, int c, int f, String custNum,
			String d, String dir, int r)
	{
		super(num, t, year, c, f, custNum, d);
		rating = r;
		setDirector(dir);
	} // Movie (String, String, int, int, int, String, String, String)

	// Accessors and mutators
	private void setProductNumber()
	{
		productNumber = "M" + productNumber;
	} // setProductNumber()

	public String getDirector()
	{
		return director;
	} // getDirector()

	public void setDirector(String d)
	{
		d = StringMethods.toTitleCase(d.trim());
		if (d.indexOf(',') >= 0 || d.indexOf(' ') == -1)
			this.director = d;
		else
		{
			String firstname = d.substring(0, d.lastIndexOf(" "));
			String lastname = d.substring(d.lastIndexOf(' ') + 1);
			this.director = lastname + ", " + firstname;
		} // if (d.indexOf(',') >= 0)
	} // setDirector(String)

	public void setCategoryCode(String catName)
	{
		int k = 0;
		categoryCode = 0;
		while (k < categoryName.length && categoryCode == 0)
		{
			if (catName.equalsIgnoreCase(categoryName[k]))
				categoryCode = k;
			k++;
		}
	} // setCategoryCode(String)

	public void setFormatCode(String formatDesc)
	{
		int k = 0;
		formatCode = 0;
		while (k < formatName.length && formatCode == 0)
		{
			if (formatDesc.equalsIgnoreCase(formatName[k]))
				formatCode = k;
			k++;
		} // while (k < formatName.length)
	} // setFormatCode(String)

	public void setRating(String ratingDesc)
	{

	} // setRating(String)

	public String getRating()
	{
		return null;
	} // getRating()

	// Overridden methods
	@Override
	public String getFormat()
	{
		if (formatCode >= 0 && formatCode < formatName.length)
			return formatName[formatCode];
		else
			return "Unknown";
	} // getFormat()

	@Override
	public String getCategory()
	{
		if (categoryCode >= 0 && categoryCode < categoryName.length)
			return categoryName[categoryCode];
		else
			return "Unknown";

	} // getCategory()	

	@Override
	public String addToRecord()
	{
		return director + "~" + rating;
	} // addToRecord()

	@Override
	public String getMedia()
	{
		return "Movie";
	} // getMedia()

} // Movie Class
