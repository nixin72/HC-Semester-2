package CSClasses;

/**
 * Title:       Heading Class
 * Description: Displays standard report heading with date and page number on
 *              first line and title centred on next lines. Double spaces 
 *              after heading output.
 * Pre-conditions: A title and page width are supplied
 * Post-conditions: A report heading formatted is output in the following 
 *              layout:
 * mmm dd, yyyy                                                        Page #
 *                           title line 1
 *                           title line 2
 *                            ...
*/

import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.util.StringTokenizer;

public class Heading
{
	private String title;
	private String reportDate;
	private int pageNumber;
	private int lineSize;

	/**
	 * Initializes the title, width, page number and date
	 * @param t The Title of the report. Separate title lines are separated by ~
	 *
	 */
	public Heading(String t)
	{
		title = t;
		lineSize = 80;
		setDate();
		pageNumber = 1;
	} // Heading()

	/**
	 * Initializes the title, width, page number and date
	 * @param t The Title of the report. Separate title lines are separated by ~
	 * @param w The column width of the report
	 *
	 */
	public Heading(String t, int w)
	{
		title = t;
		lineSize = w;
		setDate();
		pageNumber = 1;
	} // Heading()

	// set methods go here

	public void setTitle(String t)
	{
		title = t;
	}

	public void setLineSize(int lineWidth)
	{
		lineSize = lineWidth;
	}

	/** Formats and returns a centred title.  A blank line follows the heading
	 * @return a centred report title
	 */
	public String getCentredTitle()
	{
		StringBuffer head = new StringBuffer();

		// Title lines are separated by ~
		StringTokenizer headingLine = new StringTokenizer(title, "~");

		// Add title lines to header. Centre each line of the title
		while (headingLine.hasMoreTokens())
		{
			String titleToken = headingLine.nextToken();
			int endOfTitle = (lineSize / 2) + (titleToken.length() / 2);
			head.append(String.format("%" + endOfTitle + "s\n", titleToken));
		}
		// Double space after headings
		head.append("\n");

		return head.toString();
	} // getCentredTitle()

	/** Formats and returns a centred and underlined title.  A blank line follows the heading
	 * @return a centred and underlined report title
	 */
	public String getCentredTitleUnderlined()
	{
		StringBuffer head = new StringBuffer();
		StringBuffer underline;

		// Title lines are separated by ~
		StringTokenizer headingLine = new StringTokenizer(title, "~");

		// Add title lines to header. Centre each line of the title
		while (headingLine.hasMoreTokens())
		{
			String titleToken = headingLine.nextToken();
			int endOfTitle = (lineSize / 2) + (titleToken.length() / 2);
			head.append(String.format("%" + endOfTitle + "s\n", titleToken));
			underline = new StringBuffer();
			for (int i = 0; i < titleToken.length(); ++i)
				underline.append("-");
			head.append(String.format("%" + endOfTitle + "s\n", underline));
		}
		// Double space after headings
		head.append("\n");

		return head.toString();
	} // getCentredTitleUnderlined()

	/** Formats and returns a multi-line header. The first line contains the 
	 * date and page number. Subsequent lines contain the report title. A blank
	 * line follows the heading
	 * @return a multi-line formatted report heading
	 */
	public String getHeading()
	{
		StringBuffer head = new StringBuffer();

		// First line of heading contains date and page number
		int endOfPageNum = lineSize - reportDate.length();
		head.append(String.format("%s%" + endOfPageNum + "s\n", reportDate, "Page "
				+ pageNumber));

		head.append(getCentredTitle());
		// Increment for next page
		++pageNumber;

		return head.toString();
	} // getHeading()

	/** Formats and returns a multi-line header. The first line contains the 
	 * date and page number. Subsequent lines contain the report title underlined. 
	 * A blank line follows the heading
	 * @return a multi-line formatted report heading
	 */
	public String getHeadingUnderlined()
	{
		StringBuffer head = new StringBuffer();
	
		// First line of heading contains date and page number
		int endOfPageNum = lineSize - reportDate.length();
		head.append(String.format("%s%" + endOfPageNum + "s\n", reportDate, "Page "
				+ pageNumber));

		// Add title lines to header. Centre and underline each line of the title
		head.append(getCentredTitleUnderlined());
		// Increment for next page
		++pageNumber;

		return head.toString();
	} // getHeadingUnderlined()

	/**
	 * Retrieves the System date and formats it as mon dd, yyyy. The formatted
	 * date is stored in the reportDate instance variable
	 */
	private void setDate()
	{
		// get today's date
		GregorianCalendar today = new GregorianCalendar();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		reportDate = dateFormat.format(today.getTime());
	} // setDate()
} // Heading class
