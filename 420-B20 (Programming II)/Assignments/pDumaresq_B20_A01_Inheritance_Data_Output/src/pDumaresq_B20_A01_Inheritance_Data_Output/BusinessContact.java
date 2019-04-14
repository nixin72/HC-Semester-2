package pDumaresq_B20_A01_Inheritance_Data_Output;

public class BusinessContact extends Contact {
	private String workPhone;
	private String jobTitle;
	private String companyName;

//	Constructor methods
	public BusinessContact(String first, String last, String dayOB, String monthOB, String yearOB, String streetName,
			String city, String province, String postal, String email, String cell, String work, String job, String comp) {
		super(first, last, dayOB, monthOB, yearOB, streetName,city, province, postal, email, cell);
		
		fileName = "businessContact.txt";
		work = "unknown";
		job = "unknown";
		comp = "unknown";
	}

	public BusinessContact(String dayOB, String monthOB, String yearOB, String streetName, String city,
			String province, String postal, String cell, String work, String job) {
		super(dayOB, monthOB, yearOB, streetName, city,	province, postal, cell);
		fileName = "businessContact.txt";
		work = "unknown";
		job = "unknown";
	}
	
	public BusinessContact(String first, String last, String email, String comp) {
		super(first, last, email);
		fileName = "businessContact.txt";
		comp = companyName;
	}
	
	// Mutator methods
	public void setWorkPhone(String work) {
		workPhone = work;
	}

	public void setJobTitle(String job) {
		jobTitle = job;
	}

	public void setCompanyName(String comp) {
		companyName = comp;
	}

	// Accessor methods
	public String getWorkPhone() {
		return workPhone;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	// Constructor methods
	
	
	public String outputToFile() {
		//TODO
		return "Business";
	}
}
