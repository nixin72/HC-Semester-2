package videoStoreSystem;

import CSClasses.MyStringMethods;

public class Movie extends Product
{
	private final String categoryName[] = { "Unknown", "Family", "Action",
			"Comedy", "Western", "Drama", "Horror", "Sci-Fi" };
	private final String formatName[] = { "Unknown", "DVD", "DVD-HD", "Blu-Ray" };

	private String director;
	private static int countMovies = 0;

	public Movie()
	{
		newMovie();
		director = "Unknown";
	}

	public Movie(String t)
	{
		super(t);
		newMovie();
		director = "Unknown";
	}

	public Movie(String t, int year, String c, String f)
	{
		super(t, year, c, f);
		newMovie();
		director = "Unknown";
	}

	public Movie(String t, int year, String c, String f, String d)
	{
		super(t, year, c, f);
		newMovie();
		setDirector(d);
	}

	private void newMovie()
	{
		productNumber = "M" + productNumber;
		++countMovies;
	}

	public Movie(String number, String t, int year, int c, int f)
	{
		super(number, t, year, c, f);
		director = "Unknown";
	}

	public Movie(String number, String t, int year, int c, int f, String d)
	{
		super(number, t, year, c, f);
		director = d;
	}

	public Movie(String number, String t, int year, int c, int f, String d,
			int custNum, String dueDate)

	{
		super(number, t, year, c, f, custNum, dueDate);
		director = d;
	}

	public void setDirector(String d)
	{
		if (d.contains(","))
			this.director = d;
		else
		{
			d = d.trim();
			String firstname = d.substring(0, d.lastIndexOf(' '));
			String lastname = d.substring(d.lastIndexOf(' ') + 1);
			this.director = lastname + ", " + firstname;
		}
		this.director = MyStringMethods.toTitleCase(this.director);
	}

	public String getDirector()
	{
		return director;
	}

	public void setCategoryCode(String catName)
	{
		boolean found = false;
		int i = 0;
		while (i < categoryName.length && !found)
		{
			if (catName.equalsIgnoreCase(categoryName[i]))
			{
				categoryCode = i;
				found = true;
			}
			++i;
		}
		if (!found)
			categoryCode = 0;
	} // setCategoryCode(String)

	public void setCategoryCode(int code)
	{
		categoryCode = code;
	} // setCategoryCode(int)

	public void setFormatCode(String name)
	{
		boolean found = false;
		int i = 1;
		while (i < formatName.length && !found)
		{
			if (name.equalsIgnoreCase(formatName[i]))
			{
				formatCode = i;
				found = true;
			}
			++i;
		}
		if (!found)
			formatCode = 1;
	}

	public String getFormat()
	{
		return formatName[formatCode];
	}

	public String getCategory()
	{
		return categoryName[categoryCode];
	}

	public String getMedia()
	{
		return "Movie";
	}

	public static int getCountMovies()
	{
		return countMovies;
	}

	public String addToRecord()
	{
		return director;
	}
}
