package videoStoreSystem;

public class Game extends Product
{
	private int platformCode;

	public Game()
	{
		super();
		productNumber = "G" + productNumber;
		platformCode = 0;
	} //  Game()

	public Game(String t)
	{
		super(t);
		productNumber = "G" + productNumber;
	} // Game(String) 

	public Game(String t, int year, String c, String f)
	{
		super(t, year, c, f);
		productNumber = "G" + productNumber;
	} // Game(String, int, String, String)

	public Game(String t, int year, String c, String f, String p)
	{
		super(t, year, c, f);
		platformCode = 0;
		productNumber = "G" + productNumber;
	} // Game(String, int, String, String, String)

	public void setPlatformCode(int platformCode)
	{
		this.platformCode = platformCode;
	} // setPlatformCode(int)

	public int getPlatformCode()
	{
		return platformCode;
	} // getPlatformCode()

	public void setPlatformCode(String platform)
	{
		if (platform.equalsIgnoreCase("Sony PlayStation"))
			platformCode = 1;
		else
			if (platform.equalsIgnoreCase("Microsoft xBox"))
				platformCode = 2;
			else
				if (platform.equalsIgnoreCase("Nintendo GameCube"))
					platformCode = 3;
				else
					if (platform.equalsIgnoreCase("Nintendo Wii"))
						platformCode = 4;
					else
						platformCode = 0;
	} // setPlatformCode(String)

	public void setCategoryCode(String categoryName)
	{
		if (categoryName.equalsIgnoreCase("RPG"))
			categoryCode = 1;
		else
			if (categoryName.equalsIgnoreCase("Action"))
				categoryCode = 2;
			else
				if (categoryName.equalsIgnoreCase("Education"))
					categoryCode = 3;
				else
					categoryCode = 0;
	} // setCategoryCode(String)

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
} // Game class
