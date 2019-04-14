package videoStoreSystem;

public class Game extends Product
{
	private static int countGames = 0;
	private static final String categoryName[] = { "Unknown", "Family", 
    "Action", "Comedy", "Western", "Drama", "Horror", "Sci-Fi" };
	
	private static final String formatName[] = { "DVD", "DVD-HD", "Blu-Ray" };
	
	private static final String platformName[] = { "unknown", "Sony PlayStation", "Microsoft xBox",
																								"Nintendo GameCube", "Nintendo Wii" }; 

	
	public static int getCountGames()
	{
		return countGames;
	} // getCountGames()

	private int platformCode;

	public Game()
	{
		setProductNumber();
		platformCode = 0;
		++countGames;
	} // Game()

	public Game(String t)
	{
		super(t);
		setProductNumber();
		platformCode = 0;
		++countGames;
	} // Game(String)

	public Game(String t, int year, String c, String f)
	{
		super(t, year, c, f);
		setProductNumber();
		platformCode = 0;
		++countGames;
	} // Game(String, int, String, String)

	public Game(String t, int year, String c, String f, int p)
	{
		super(t, year, c, f);
		setProductNumber();
		platformCode = p;
		++countGames;
	} // Game(String, int, String, String, int)

	public Game(String num, String t, int year, int c, int f, int p)
	{
		super(num, t, year, c, f);
		platformCode = p;
	} // Game(String, String, int, int, int, int)

	public Game(String num, String t, int year, int c, int f, String custNum,
			String d, int p)
	{
		super(num, t, year, c, f, custNum, d);
		platformCode = p;
	} // Game(String, String, int, int, int, int)

	private void setProductNumber()
	{
		productNumber = "G" + productNumber;
	} // setProductNumber()

	public int getPlatformCode()
	{
		return platformCode;
	} // getPlatformCode()

	public void setPlatformCode(int platformCode)
	{
		this.platformCode = platformCode;
	} // setPlatformCode(int)

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
	} // setCategory(String)

	public void setFormatCode(String formatDesc)
	{
		int k = 0;
		formatCode = 0;
			
			while (k < formatName.length) 
			{
				if (formatDesc == formatName[k]) 
				{
					formatCode = k;
				}
				
				k++;
		}
	} // setFormatCode(String)

	public void setPlatformCode(String platform)
	{
		int k = 0;
		platformCode = 0;
		
		while (k < platformName.length) 
		{
			if (platform == platformName[k]) 
			{
				platformCode = k;
			}
			
			k++;
		}
	} // setPlatformCode(String)

	public String getPlatform()
	{
		if (platformCode > 0 && categoryCode < platformName.length) 
		{
			return platformName[platformCode];
		}
		else
			return "Unknown";
	} // getPlatform()

	@Override

	public String getFormat()
	{
		if (categoryCode > 0 && categoryCode < formatName.length) 
		{
			return formatName[formatCode];
		}
		else
			return "Unknown";
	} // getFormat()

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
		return String.valueOf(platformCode);
	} // addToRecord()

	@Override
	public String getMedia()
	{
		return "Game";
	} // getMedia()

} // Game class
