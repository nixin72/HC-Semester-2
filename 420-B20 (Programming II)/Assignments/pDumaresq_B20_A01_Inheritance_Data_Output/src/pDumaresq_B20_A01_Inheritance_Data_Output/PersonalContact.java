package pDumaresq_B20_A01_Inheritance_Data_Output;

public class PersonalContact extends Contact{
	private String homePhone;
	private String skypeName;
	private int relationship;
	
//	Constructor methods
	public PersonalContact(String first, String last, String dayOB, String monthOB, String yearOB, String streetName,
			String city, String province, String postal, String email, String cell, String home, String skype, int rel) {
		super(first, last, dayOB, monthOB, yearOB, streetName,city, province, postal, email, cell);
		
		fileName = "personalContact.txt";	
		home = "unknown";
		skype = "unknown";
		rel = 0;		
	}
	
	public PersonalContact(String dayOB, String monthOB, String yearOB, String streetName, String city,
			String province, String postal, String cell, String home, String skype) {
		super(dayOB, monthOB, yearOB, streetName, city,	province, postal, cell);
		fileName = "personalContact.txt";
		home = "unknown";
		skype = "unknown";
	}
	
	public PersonalContact(String first, String last, String email, int rel) {
		super(first, last, email);
		fileName = "personalContact.txt";
		rel = relationship;
	}

	//	Mutator methods
	public void setHomePhone(String home) {
		homePhone = home;
	}
	
	public void setSkypeName(String skype) {
		skypeName = skype;
	}
	
	public void setRelationship(int i) {
		relationship = i;
	}
	
//	Accessor methods
	public String getHomePhone() {
		return homePhone;
	}
	
	public String getSkypeName() {
		return skypeName;
	}
	
	public int getRelationship() {
		return relationship;
	}
	
	
	public String outputToFile() {
		//TODO
		return "Personal";
	}
}
