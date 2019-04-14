package videoStoreSystem;

public class Movie extends Product
{
	private String director;

	public Movie()
	{
		super();
		productNumber = "M" + productNumber;
		director = "Unknown";
	} // Movie()

	public Movie(String t)
	{
		super(t);
		productNumber = "M" + productNumber;
	} // Movie(String)

	public Movie(String t, int year, String c, String f)
	{
		super(t, year, c, f);
		productNumber = "M" + productNumber;
	} // Movie(String, int, String, String)

	public Movie(String t, int year, String c, String f, String d)
	{
		super(t, year, c, f);
		productNumber = "M" + productNumber;
		setDirector(d);
	} // Movie(String, int, String, String, String)

	public void setDirector(String d)
	{
		director = d;
	} // setDirector()

	public String getDirector()
	{
		return director;
	} // getDirector()

	public void setCategoryCode(String categoryName)
	{
		if (categoryName.equalsIgnoreCase("Family"))
			categoryCode = 1;
		else
			if (categoryName.equalsIgnoreCase("Action"))
				categoryCode = 2;
			else
				if (categoryName.equalsIgnoreCase("Comedy"))
					categoryCode = 3;
				else
					if (categoryName.equalsIgnoreCase("Western"))
						categoryCode = 4;
					else
						if (categoryName.equalsIgnoreCase("Drama"))
							categoryCode = 5;
						else
							if (categoryName.equalsIgnoreCase("Horror"))
								categoryCode = 6;
							else
								if (categoryName.equalsIgnoreCase("Sci-fi"))
									categoryCode = 7;
								else
									categoryCode = 0;
	} //setCategoryCode(String)

	@Override
	public void setFormatCode(String formatName)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFormat()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCategory()
	{
		// TODO Auto-generated method stub
		return null;
	}
} // Movie class
