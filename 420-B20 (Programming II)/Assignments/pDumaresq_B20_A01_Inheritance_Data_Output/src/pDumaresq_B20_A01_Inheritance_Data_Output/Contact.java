package pDumaresq_B20_A01_Inheritance_Data_Output;

public abstract class Contact  {

	protected static String fileName;
	protected String firstName;
	protected String lastName;
	protected String dayOfBirth;
	protected String monthOfBirth;
	protected String yearOfBirth;
	protected String nameOfStreet;
	protected String cityName;
	protected String provinceName;
	protected String postalCode;
	protected String e_mail;
	protected String cellNumber;
	
	
//	Contact number variables
	protected static int contactNumber;
	private static int nextContactNumber;
	
	

	// Constructor methods
	public Contact(String first, String last, String dayOB, String monthOB, String yearOB, String streetName,
			String city, String province, String postal, String email, String cell) {
		first = "unknown";
		last = "unknown";
		dayOB = "unknown";
		monthOB = "unknown";
		yearOB = "unknown";
		streetName = "unknown";
		city = "unknown";
		province = "unknown";
		postal = "unknown";
		email = "unknown";
		cell = "unknown";

	}
	
	public Contact(String dayOB, String monthOB, String yearOB, String streetName, String city,
			String province, String postal, String cell) {
		dayOB = "unknown";
		monthOB = "unknown";
		yearOB = "unknown";
		streetName = "unknown";
		city = "unknown";
		province = "unknown";
		postal = "unknown";
		cell = "unknown";
		
	}

	public Contact(String first, String last, String email) {
		first = firstName;
		last = lastName;
		email = e_mail;
	}

	

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	// Mutator methods
	public void setFirstName(String _firstName) {
		firstName = _firstName;
	}

	public void setLastName(String last) {
		lastName = last;
	}

	public void setDayOfBirth(String dayOB) {
		dayOfBirth = dayOB;
	}

	public void setMonthOfBirth(String monthOB) {
		monthOfBirth = monthOB;
	}

	public void setYearOfBirth(String yearOB) {
		yearOfBirth = yearOB;
	}

	public void setNameOfStreet(String streetName) {
		nameOfStreet = streetName;
	}
	
	public void setCityName(String city) {
		cityName = city;
	}
	
	public void setProvinceName(String province) {
		provinceName = province;
	}
	
	public void setPostalCode(String postal) {
		postalCode = postal;
	}

	public void setE_mail(String email) {
		e_mail = email;
	}

	public void setCellNumber(String cellNum) {
		cellNumber = cellNum;
	}

	// Accessor methods
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public String getMonthOfBirth() {
		return monthOfBirth;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public String getNameOfStreet() {
		return nameOfStreet;
	}
		
	public String getCityName() {
		return cityName;
	}
	
	public String getProvinceName( ) {
		return provinceName;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public String getE_mail() {
		return e_mail;
	}

	public String getCellNumber() {
		return cellNumber;
	}
	
//Accessors and mutators for contactNumber
	public static void setContactNumber(int contactNum) {
		contactNumber = contactNum;
	}
	public static int getContactNumber() {
		return contactNumber;
		
	}
	
//Abstract method containing the file writer?	
	public abstract String outputToFile();
	
	public static int contactNumber() {
		return contactNumber;
	}
	public static int nextContactNumber() {
		return nextContactNumber;
	}
	
	
}

