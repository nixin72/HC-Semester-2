package videoStoreSystem;

public class Game extends Product
{
	private final String categoryName[] = { "Unknown", "RPG", "Action",
			"Education" };
	private final String formatName[] = { "Unknown", "DVD", "CD" };
	private final String platformName[] = { "Unknown", "Sony PlayStation",
			"Microsoft xBox", "Nintendo GameCube", "Nintendo Wii" };
	private int platformCode;
	private static int countGames = 0;

	public Game()
	{
		newGame();
		platformCode = 0;
	}

	public Game(String t)
	{
		super(t);
		newGame();
		platformCode = 0;
	}

	public Game(String t, int year, String c, String f)
	{
		super(t, year, c, f);
		newGame();
		platformCode = 0;
	}

	public Game(String t, int year, String c, String f, String p)
	{
		super(t, year, c, f);
		newGame();
		setPlatformCode(p);
	}

	private void newGame()
	{
		productNumber = "G" + productNumber;
		++countGames;
	}

	public Game(String number, String t, int year, int c, int f)
	{
		super(number, t, year, c, f);
		platformCode = 0;
	}

	public Game(String number, String t, int year, int c, int f, int p)
	{
		super(number, t, year, c, f);
		platformCode = p;
	}

	public Game(String number, String t, int year, int c, int f, int p,
			int custNum, String dueDate)

	{
		super(number, t, year, c, f, custNum, dueDate);
		platformCode = p;
	}

	public void setPlatformCode(int platformCode)
	{
		this.platformCode = platformCode;
	}

	public void setPlatformCode(String platform)
	{
		boolean found = false;
		int i = 0;
		while (i < platformName.length && !found)
		{
			if (platform.equalsIgnoreCase(platformName[i]))
			{
				platformCode = i;
				found = true;
			}
			++i;
		}
		if (!found)
			platformCode = 0;
	}

	public String getPlatform()
	{
		return platformName[platformCode];
	}

	public int getPlatformCode()
	{
		return platformCode;
	}

	public void setCategoryCode(String catName)
	{
		boolean found = false;
		int i = 0;
		while (i < categoryName.length && !found)
		{
			if (categoryName[i].equalsIgnoreCase(catName))
			{
				categoryCode = i;
				found = true;
			}
			++i;
		}
		if (!found)
			categoryCode = 0;
	}

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

	} // setFormatCode(String)

	public String getFormat()
	{
		return formatName[formatCode];
	} // getFormat()

	public String getCategory()
	{
		return categoryName[categoryCode];
	} // getCategory()

	public String addToRecord()
	{
		return String.valueOf(platformCode);
	} // getEndOfRecord()

	public String getMedia()
	{
		return "Game";
	}

	public static int getCountGames()
	{
		return countGames;
	}
}
