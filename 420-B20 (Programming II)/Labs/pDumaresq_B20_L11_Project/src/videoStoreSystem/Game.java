package videoStoreSystem;

public class Game extends Product
{
	// class variables and methods
	private static int countGames = 0;
	private static final String categoryName[] = { "Unknown", "RPG", "Action",
			"Education" };
	private static final String formatName[] = { "Unknown", "DVD", "CD" };
	private static final String platformName[] = { "Unknown", "Sony PlayStation",
			"Microsoft xBox", "Nintendo GameCube", "Nintendo Wii" };

	public static int getCountGames()
	{
		return countGames;
	} // getCountGames()

	// instance variables
	private int platformCode;

	// constructors
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

	// Accessors and Mutators
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
		while (k < categoryName.length && categoryCode == 0)
		{
			if (catName.equalsIgnoreCase(categoryName[k]))
				categoryCode = k;
			k++;
		} // while (k < categoryName.length)
	} // setCategory(String)

	public void setFormatCode(String formatDesc)
	{
		int k = 0;
		formatCode = 1;
		while (k < formatName.length && formatCode == 0)
		{
			if (formatDesc.equalsIgnoreCase(formatName[k]))
				formatCode = k;
			k++;
		} // while (k < categoryName.length)
	} // setFormatCode(String)

	public void setPlatformCode(String platform)
	{
		int k = 0;
		platformCode = 0;
		while (k < platformName.length && platformCode == 0)
		{
			if (platform.equalsIgnoreCase(platformName[k]))
				formatCode = k;
			k++;
		} // while (k < categoryName.length)
	} // setPlatformCode(String)

	public String getPlatform()
	{
		if (platformCode >= 0 && platformCode < platformName.length)
			return platformName[platformCode];
		else
			return "Unknown";
	} // getPlatform()

	public String getCategory()
	{
		if (categoryCode >= 0 && categoryCode < categoryName.length)
			return categoryName[categoryCode];
		else
			return "Unknown";
	} // getCategory()

	// Overridden methods
	@Override
	public String getFormat()
	{
		if (formatCode >= 0 && formatCode < formatName.length)
			return formatName[formatCode];
		else
			return "DVD";
		
	} // getFormat()

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
