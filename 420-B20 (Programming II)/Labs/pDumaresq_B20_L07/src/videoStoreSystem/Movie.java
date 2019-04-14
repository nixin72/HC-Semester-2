package videoStoreSystem;

import CSClasses.StringMethods;

public class Movie extends Product
{
	private static int countMovies = 0;
  
	private static final String categoryName[] = { "Unknown", "Family", 
    "Action", "Comedy", "Western", "Drama", "Horror", "Sci-Fi" };
  
  private static final String formatName[] = { "DVD", "DVD-HD", "Blu-Ray" };
	
	public static int getCountMovies()
	{
		return countMovies;
	} // getCountMovies()

	private String director;

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

	public Movie(String t, int year, String c, String f, String dir)
	{
		super(t, year, c, f);
		setDirector(dir);
		++countMovies;
	} // Movie(String, int, String, String, String)

	public Movie(String num, String t, int year, int c, int f, String dir)
	{
		super(num, t, year, c, f);
		setDirector(dir);
	} // Movie(String, String, int, int, int, String)

	public Movie(String num, String t, int year, int c, int f, String custNum,
			String d, String dir)
	{
		super(num, t, year, c, f, custNum, d);
		setDirector(dir);
	} // Movie (String, String, int, int, int, String, String, String)

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
		
		while (k < categoryName.length) 
		{
			if (catName == categoryName[k]) 
			{
				categoryCode = k;
			}
			
			k++;
		}
		
	} // setCategoryCode(String)

	public void setFormatCode(String formatDesc)
	{
		int k = 0;
		formatCode = 0;
		
		while (k < formatName.length) 
		{
			if (formatDesc.equals(formatName[k])) 
			{
				formatCode = k;
			}
			
			k++;
		}
	} // setFormatCode(String)

	@Override
	public String getFormat()
	{
		if (formatCode > 0 && formatCode < formatName.length) 
		{
			return formatName[formatCode];
		}
		else
			return "Unknown";
	} // getFormat()

	@Override
	public String getCategory()
	{
		if (categoryCode > 0 && categoryCode < categoryName.length) 
		{
			return categoryName[categoryCode];
		}
		else
			return "Unknown";
		
	} // getCategory()	

	@Override
	public String addToRecord()
	{
		return director;
	} // addToRecord()

	@Override
	public String getMedia()
	{
		return "Movie";
	} // getMedia()

} // Movie Class
