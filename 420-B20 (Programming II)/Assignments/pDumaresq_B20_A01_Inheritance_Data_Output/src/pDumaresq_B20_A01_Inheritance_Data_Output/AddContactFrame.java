package pDumaresq_B20_A01_Inheritance_Data_Output;

import java.awt.event.*;
import java.awt.*;

import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings({ "rawtypes", "serial" })
public class AddContactFrame extends JFrame {

	PersonalContact personal = null;
	PersonalContact personal2 = null;
	BusinessContact business = null;
	BusinessContact business2 = null;
		
	private JPanel contentPane;
	private JTextField fldfirstName;
	private JTextField fldlastName;
	private JTextField fldStreetName;
	private JTextField fldCity;
	private JTextField fldProvince;
	private JTextField fldPostalCode;
	private JTextField fldEmail;
	private JTextField fldCellPhone;
	private JTextField fldHomePhone;
	private JTextField fldSkypeName;
	private JTextField fldWorkPhone;
	private JTextField fldCompany;
	private JTextField fldJobTitle;
	JComboBox cmbxRelationship = new JComboBox();
	JComboBox cmbxMonthOfBirth = new JComboBox();
	JComboBox cmbxDayOfBirth = new JComboBox();
	JComboBox cmbxYearOfBirth = new JComboBox();
	
	private String contactNumber;
	private static int nextcontactNumber;
	private char contactId;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddContactFrame frame = new AddContactFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public AddContactFrame() {
		
		setTitle("Add your contact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("*First Name:");
		lblFirstName.setBounds(45, 16, 95, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("*Last Name:");
		lblLastName.setBounds(455, 16, 95, 20);
		contentPane.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth: ");
		lblDateOfBirth.setBounds(55, 65, 132, 20);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblDayOfBirth = new JLabel("Day: ");
		lblDayOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDayOfBirth.setBounds(71, 101, 69, 20);
		contentPane.add(lblDayOfBirth);
		
		JLabel lblMonthOfBirth = new JLabel("Month:");
		lblMonthOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonthOfBirth.setBounds(71, 137, 69, 20);
		contentPane.add(lblMonthOfBirth);
		
		JLabel lblYearOfBirth = new JLabel("Year:");
		lblYearOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYearOfBirth.setBounds(71, 173, 69, 20);
		contentPane.add(lblYearOfBirth);
		
		fldfirstName = new JTextField();
		fldfirstName.setBounds(141, 13, 246, 26);
		contentPane.add(fldfirstName);
		fldfirstName.setColumns(10);
		
		fldlastName = new JTextField();
		fldlastName.setColumns(10);
		fldlastName.setBounds(545, 13, 274, 26);
		contentPane.add(fldlastName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(455, 65, 117, 20);
		contentPane.add(lblAddress);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreet.setBounds(447, 101, 117, 20);
		contentPane.add(lblStreet);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(447, 137, 117, 20);
		contentPane.add(lblCity);
		
		JLabel lblProvince = new JLabel("Province:");
		lblProvince.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvince.setBounds(447, 173, 117, 20);
		contentPane.add(lblProvince);
		
		JLabel lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostalCode.setBounds(447, 209, 117, 20);
		contentPane.add(lblPostalCode);
		
		fldStreetName = new JTextField();
		fldStreetName.setBounds(595, 95, 224, 26);
		contentPane.add(fldStreetName);
		fldStreetName.setColumns(10);
		
		fldCity = new JTextField();
		fldCity.setColumns(10);
		fldCity.setBounds(595, 134, 224, 26);
		contentPane.add(fldCity);
		
		fldProvince = new JTextField();
		fldProvince.setColumns(10);
		fldProvince.setBounds(595, 170, 224, 26);
		contentPane.add(fldProvince);
		
		fldPostalCode = new JTextField();
		fldPostalCode.setColumns(10);
		fldPostalCode.setBounds(595, 206, 224, 26);
		contentPane.add(fldPostalCode);
		
		JLabel lblContactInfo = new JLabel("Contact Info:");
		lblContactInfo.setBounds(15, 318, 110, 20);
		contentPane.add(lblContactInfo);
		
		JButton btnPersonal = new JButton("Personal Contact");
		btnPersonal.setBounds(155, 258, 206, 29);
		contentPane.add(btnPersonal);

//		ActionListner to disable businessContact fields
		btnPersonal.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent e) {
				disableBusiness();
				clearBusiness();
			}
			private void disableBusiness() {
			fldWorkPhone.setEditable(false);
			fldCompany.setEditable(false);
			fldJobTitle.setEditable(false);
			fldHomePhone.setEditable(true);
			fldSkypeName.setEditable(true);
			cmbxRelationship.setEnabled(true);
			}
			private void clearBusiness() {
			fldWorkPhone.setText("");
			fldCompany.setText("");
			fldJobTitle.setText("");
			}
		});
		
		JButton btnBusiness = new JButton("Business Contact");
		btnBusiness.setBounds(508, 258, 206, 29);
		contentPane.add(btnBusiness);

//		ActionListner to disable personalContact fields
		btnBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disablePersonal();
				clearPersonal();
			}
			private void disablePersonal() {
			fldHomePhone.setEditable(false);
			fldSkypeName.setEditable(false);
			cmbxRelationship.setEnabled(false);
			fldWorkPhone.setEditable(true);
			fldCompany.setEditable(true);
			fldJobTitle.setEditable(true);
			}
			private void clearPersonal() {
				fldHomePhone.setText("");
				fldSkypeName.setText("");
				cmbxRelationship.setSelectedIndex(0);
			}
		});
				
		
		JLabel lblEmail = new JLabel("*Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(71, 346, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblCellPhone = new JLabel("Cell Phone:");
		lblCellPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCellPhone.setBounds(433, 346, 117, 20);
		contentPane.add(lblCellPhone);
		
		fldEmail = new JTextField();
		fldEmail.setBounds(163, 343, 224, 26);
		contentPane.add(fldEmail);
		fldEmail.setColumns(10);
		
		fldCellPhone = new JTextField();
		fldCellPhone.setBounds(569, 343, 206, 26);
		contentPane.add(fldCellPhone);
		fldCellPhone.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone:");
		lblHomePhone.setBounds(45, 401, 97, 20);
		contentPane.add(lblHomePhone);
		
		fldHomePhone = new JTextField();
		fldHomePhone.setBounds(163, 398, 224, 26);
		contentPane.add(fldHomePhone);
		fldHomePhone.setColumns(10);
		
		//Day of birth Combo box setting the amount of months in the array
		
		cmbxMonthOfBirth.setModel(new DefaultComboBoxModel(new String[] {"month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"}));
		cmbxMonthOfBirth.setBounds(163, 134, 117, 26);
		contentPane.add(cmbxMonthOfBirth);
		
		//Month of birth Combo box setting the amount of days in the array
		
		if (cmbxMonthOfBirth.getSelectedIndex() == 0 || cmbxMonthOfBirth.getSelectedIndex() == 3 
				|| cmbxMonthOfBirth.getSelectedIndex() == 5 || cmbxMonthOfBirth.getSelectedIndex() == 7
				|| cmbxMonthOfBirth.getSelectedIndex() == 8 || cmbxMonthOfBirth.getSelectedIndex() == 10
				|| cmbxMonthOfBirth.getSelectedIndex() == 12) {
			cmbxDayOfBirth.setModel(new DefaultComboBoxModel(new String[] {"day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
			cmbxDayOfBirth.setBounds(163, 98, 117, 26);
			contentPane.add(cmbxDayOfBirth);
		}
		else if(cmbxMonthOfBirth.getSelectedIndex() == 1) {
		cmbxDayOfBirth.setModel(new DefaultComboBoxModel(new String[] {"day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
		cmbxDayOfBirth.setBounds(163, 98, 117, 26);
		contentPane.add(cmbxDayOfBirth);
		}
		else {
		cmbxDayOfBirth.setModel(new DefaultComboBoxModel(new String[] {"day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbxDayOfBirth.setBounds(163, 98, 117, 26);
		contentPane.add(cmbxDayOfBirth);
		}
		
		//Year of birth Combo box setting the array
		
		cmbxYearOfBirth.setModel(new DefaultComboBoxModel(new String[] {"year", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915"}));
		cmbxYearOfBirth.setBounds(163, 170, 117, 26);
		contentPane.add(cmbxYearOfBirth);
		
		JLabel lblSkypeName = new JLabel("Skype Name:");
		lblSkypeName.setBounds(45, 437, 95, 20);
		contentPane.add(lblSkypeName);
		
		fldSkypeName = new JTextField();
		fldSkypeName.setBounds(163, 437, 224, 26);
		contentPane.add(fldSkypeName);
		fldSkypeName.setColumns(10);
		
		JLabel lblRelationship = new JLabel("Relationship:");
		lblRelationship.setBounds(48, 479, 92, 20);
		contentPane.add(lblRelationship);
		
		
		cmbxRelationship.setModel(new DefaultComboBoxModel(new String[] {"Unknown", "Family", "Friend", "Acquaintance", "Neighbour", "Other"}));
		cmbxRelationship.setBounds(163, 476, 138, 26);
		contentPane.add(cmbxRelationship);
		//PersonalContact.setRelationship(cmbxRelationship.getText());
		
		JButton btnAddContact = new JButton("Add Contact");
		btnAddContact.setBounds(204, 539, 184, 29);
		contentPane.add(btnAddContact);
		
//		ActionListner to add contact information to file
		btnAddContact.addActionListener(new ActionListener() {
		    @SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
		    	boolean isValid = true;
		    	
//isValid has a default value of true. All my check methods return either true or false. 
		    	isValid = isValid && checkPostalCode();
				isValid = isValid && checkCellNumber();
				isValid = isValid && checkHomeNumber();
				isValid = isValid && checkWorkNumber();
				isValid = isValid && checkFirstName();
				isValid = isValid && checkLastName();
				isValid = isValid && checkEmail();
				isValid = isValid && checkContactType();
							
//In the end, if everything still equates to true, then the if statement runs 				
				
				//For my call to my constructors
				String first = fldfirstName.getText();
				String last = fldlastName.getText();
				String dayOB = cmbxDayOfBirth.getSelectedItem().toString();
				String monthOB = cmbxMonthOfBirth.getSelectedItem().toString();
				String yearOB = cmbxYearOfBirth.getSelectedItem().toString();
				String streetName = fldStreetName.getText();
				String city = fldCity.getText();
				String province = fldProvince.getText();
				String postal = fldPostalCode.getText();
				String email = fldEmail.getText();
				String cell = fldCellPhone.getText();
				String work = fldWorkPhone.getText();
				String job = fldJobTitle.getText();
				String comp = fldCompany.getText();
				String home = fldHomePhone.getText();
				String skype = fldSkypeName.getText();
				int rel = cmbxRelationship.getSelectedIndex();	
	    		
				
				if (isValid == true) {
					Contact newContact= null;
					
					if (fldWorkPhone.isEditable() == true) {//Working inside the businessContact information
						try {
				    		//Write to the businessContact file
							File contactNum = new File("contactNumber.txt");
			    			FileWriter writeContactNum = new FileWriter(contactNum, false);
			    			Scanner readNum = new Scanner(contactNum); 
			    			
			    			while (readNum.hasNext()) {
				    			contactNumber = readNum.next();
				    			nextcontactNumber = Integer.parseInt(contactNumber);
				    		}
				    			
				    		contactId = 'B';
				    		++nextcontactNumber;
				    		newContact.setContactNumber(1000 + nextcontactNumber);
				    		writeContactNum.write(String.valueOf(newContact.getContactNumber()));
			    			
				    		readNum.close();
			    			writeContactNum.close();
						}
				   		catch (FileNotFoundException a) {
							System.out.println("The file could not be found");
							System.exit(-1);
						}
						catch (IOException i) {
				    		i.printStackTrace();
				    		System.exit(-2);
				    	}
					}
					else {//Working inside the personalContact information
						try {
			    			//Write to the personalContact file
							
			    			File contactNum = new File("contactNumber.txt");
			    			FileWriter writeContactNum = new FileWriter(contactNum, false);
			    			Scanner readNum = new Scanner(contactNum); 
			    			
			    			while (readNum.hasNext()) {
				    			contactNumber = readNum.next();
				    			nextcontactNumber = Integer.parseInt(contactNumber);
				    		}
				    			
				    		contactId = 'P';
				    		++nextcontactNumber;
				    		newContact.setContactNumber(1000 + nextcontactNumber);
				    		writeContactNum.write(String.valueOf(newContact.getContactNumber()));
			    			
			    			writeContactNum.close();
			    			readNum.close();
			    			
			    		}
						catch (FileNotFoundException a) {
							System.out.println("The file could not be found");
							System.exit(-1);
						}
						catch (IOException i) {
			    			i.printStackTrace();
			    			System.exit(-2);
			    		}
					}
					
					
					
//if the business contact button has been selected 
					if (fldWorkPhone.isEditable() == true) { 
						//instantiating all of my business contacts
						business = new BusinessContact(first, last, dayOB, monthOB, yearOB, streetName, city, province, postal, email, cell, work, job, comp);
						business.setWorkPhone(fldWorkPhone.getText());
						business.setCompanyName(fldCompany.getText());
						business.setJobTitle(fldJobTitle.getText());
		    			
		    			newContact = business;
					}	
					
//else means personal has been selected
			    	else { 
			    		//instantiating all of my personal contacts
			    		personal = new PersonalContact(first, last, dayOB, monthOB, yearOB, streetName, city, province, postal, email, cell, home, skype, rel);
			    		personal.setHomePhone(fldHomePhone.getText());
			    		personal.setSkypeName(fldSkypeName.getText());
			    		personal.setRelationship(cmbxRelationship.getSelectedIndex());
			    		
			    		newContact = personal;
			    	}
					
//Set all of my general contact information					
			    	newContact.setFirstName(fldfirstName.getText());
			    	newContact.setLastName(fldlastName.getText());
			    	newContact.setNameOfStreet(fldStreetName.getText());
			    	newContact.setCityName(fldCity.getText());
			    	newContact.setProvinceName(fldProvince.getText());
			    	newContact.setPostalCode(fldPostalCode.getText());
			    	newContact.setE_mail(fldEmail.getText());
			    	newContact.setCellNumber(fldCellPhone.getText());
			    	newContact.setDayOfBirth(cmbxDayOfBirth.getSelectedItem().toString());
			    	newContact.setMonthOfBirth(cmbxDayOfBirth.getSelectedItem().toString());
			    	newContact.setYearOfBirth(cmbxDayOfBirth.getSelectedItem().toString());
			
//Write all of my general contact info to business file
			    	if (fldWorkPhone.isEditable() == true) {
			    								
			    		try {
			    			//Write to the businessContact file
			    			File business = new File("businessContact.txt");
			    			FileWriter writebusiness = new FileWriter(business, true);
			    			business2 = new BusinessContact(first, last, dayOB, monthOB, yearOB, streetName, city, province, postal, email, cell, work, job, comp);
			    			//Write to the contactNumber file
							contactId = 'B';
							writebusiness.write(contactId + String.valueOf(newContact.getContactNumber())+ "~");
			    			
			    			writebusiness.write(newContact.getFirstName() + "~");
			    			writebusiness.write(newContact.getLastName() + "~");
			    			writebusiness.write(newContact.getE_mail() + "~");
			    			writebusiness.write(newContact.getCellNumber() + "~");
			    			writebusiness.write(cmbxMonthOfBirth.getSelectedItem() + "~");
			    			writebusiness.write(cmbxDayOfBirth.getSelectedItem() + "~");
			    			writebusiness.write(cmbxYearOfBirth.getSelectedItem() + "~");
			    			writebusiness.write(newContact.getNameOfStreet() + "~");
			    			writebusiness.write(newContact.getCityName() + "~");
			    			writebusiness.write(newContact.getProvinceName() + "~");
			    			writebusiness.write(newContact.getPostalCode() + "~");
			    			writebusiness.write(newContact.getE_mail() + "~");
			    			writebusiness.write(newContact.getCellNumber() + "~");
			    			writebusiness.write(business2.getWorkPhone() + "~");
			    			writebusiness.write(business2.getCompanyName() + "~");
			    			writebusiness.write(business2.getJobTitle() + "~");
			    			
			    			writebusiness.write("\n");	
			    			
			    			writebusiness.close();
			    		} catch (IOException i) {
			    			i.printStackTrace();
			    		}
			    	}
			    	
//Write all of my general contact info to personal file
			    	else {
			    		try { 
			    			File personal = new File("personalContact.txt");
			    			FileWriter writePersonal = new FileWriter(personal, true);
			    			personal2 = new PersonalContact(first, last, dayOB, monthOB, yearOB, streetName, city, province, postal, email, cell, home, skype, rel);
			    			contactId = 'P';
	    						    						    					
	    					writePersonal.write(contactId + String.valueOf(newContact.getContactNumber())+ "~");
	    					writePersonal.write(newContact.getFirstName() + "~");
			    			writePersonal.write(newContact.getLastName() + "~");
			    			writePersonal.write(newContact.getNameOfStreet() + "~");
			    			writePersonal.write(newContact.getCityName() + "~");
			    			writePersonal.write(newContact.getProvinceName() + "~");
			    			writePersonal.write(newContact.getPostalCode() + "~");
			    			writePersonal.write(newContact.getE_mail() + "~");
			    			writePersonal.write(newContact.getCellNumber() + "~");
			    			writePersonal.write(cmbxMonthOfBirth.getSelectedIndex() + "~");
			    			writePersonal.write(cmbxDayOfBirth.getSelectedIndex() + "~");
			    			writePersonal.write(cmbxYearOfBirth.getSelectedIndex() + "~");
			    			writePersonal.write(personal2.getHomePhone() + "~");
			    			writePersonal.write(personal2.getSkypeName() + "~");
			    			writePersonal.write(personal2.getRelationship() + "~");
			    		
			    			writePersonal.write("\n");
			    			
			    			writePersonal.close();
			    			
			    		}//try
			    		catch (IOException i) {
			    			i.printStackTrace();
			    		}//catch
			    	
			    	}//else
			    	
			    }//if (isValid == true);
				
			}//action listener
				
				
//Checks to see if first name is present
		private boolean checkFirstName() {
			if (fldfirstName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You must enter a first name.");
				//return false;
				if (fldfirstName.getText() == "blah") {
					
				}
				else {
					return false;
				}
			}
			return true;
		}

//Checks to see if last name is present
		private boolean checkLastName() {
			if (fldlastName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You must enter a last name.");
				return false;
			}
			return true;
		}
		
//checks to see if email is present and formatted properly
		private boolean checkEmail() {
			StringTokenizer checkEmail1 = new StringTokenizer(fldEmail.getText(), "@");
			StringTokenizer checkEmail2 = new StringTokenizer(fldEmail.getText(), ".");
						
			if (fldEmail.getText().isEmpty()) { //Checks if the email field has been filled out
				JOptionPane.showMessageDialog(null, "You must enter an email address."); //if not, it tells you to fill it out
				return false;
			}
			else //If it is filled out, it checks if it's done correctly
			{
				checkEmail1.nextToken();
				checkEmail2.nextToken(); //checks for 2 different types of tokens
				if (checkEmail1.hasMoreTokens() && checkEmail2.hasMoreTokens()) //If it contains these 2 tokens, were good 
				{
					return true;
				}
				else
				{	//If not, it tells you to format the email address correctly.
					JOptionPane.showMessageDialog(null, "Please format your email properly \n ex. johnDoe@webSite.com"); 
					return false;
				}
			}
		}//Same basic code for the phone numbers as well.

//Checks to see if cell number is formatted correctly
		private boolean checkCellNumber() {
			StringTokenizer checkCell = new StringTokenizer(fldCellPhone.getText(), "-");
										
			if (fldCellPhone.getText().isEmpty())
			{
				return true;
			}
			else 
			{
				checkCell.nextToken(); 
				if (checkCell.hasMoreTokens())
				{
					if (fldCellPhone.getText().length() != 12 ) {
					JOptionPane.showMessageDialog(null, "Please format the cell phone number correctly. \n ex. 613-123-4567");
					return false;
					}
					//except the phone number also has to check if the number is the right length. 
				     //The if statement uses 12, not 10, because it has to check for dashes inside the phone number.
			 		else
						return true;
				}	 
				else 
				{
					JOptionPane.showMessageDialog(null, "Please break up the cell phone number with dashes. \n ex. 613-123-4567");
					return false;
				}
			}
		}
		
//Checks to see if home number is formatted correctly
		private boolean checkHomeNumber() {
			 StringTokenizer checkHome = new StringTokenizer(fldHomePhone.getText(), "-");
			
			if (fldHomePhone.getText().isEmpty() || fldHomePhone.isEditable() == false) 
			{
				return true;
			}
			else 
			{
				checkHome.nextToken();
				if (checkHome.hasMoreTokens()) 
				{
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please break up the home phone number with dashes \n ex. 613-123-4567");
					return false;
				}
				if (fldHomePhone.getText().length() != 12) {
					JOptionPane.showMessageDialog(null, "Please format the home phone number correctly. \n ex. 613-123-4567");
					return false;
				}
				return true;
			}
		}
		
//Checks to see if work number is formatted correctly
		private boolean checkWorkNumber() {
			StringTokenizer checkWork = new StringTokenizer(fldWorkPhone.getText(), "-");
					
			if (fldWorkPhone.getText().isEmpty() || fldWorkPhone.isEditable() == false) 
			{
				return true;
			}
			else
			{
				checkWork.nextToken();
				if (checkWork.hasMoreTokens()) 
				{
					if (fldWorkPhone.getText().length() != 12) {
					JOptionPane.showMessageDialog(null, "Please format the work phone number correctly. \n ex. 613-123-4567");
					return false;
					}
				}
				else   
				{
					JOptionPane.showMessageDialog(null, "Please break up the work phone number with dashes \n ex. 613-123-4567");
					return false;
				}
				return true;
			}
		}
		
//Checks to see if postal code is formatted correctly 		
		private boolean checkPostalCode() {
			StringTokenizer checkPostal = new StringTokenizer(fldPostalCode.getText());

			if (fldPostalCode.getText().isEmpty() || fldPostalCode.isEditable() == false) 
			{
				return true;
			}
			else 
			{
				checkPostal.nextToken();
				if (checkPostal.hasMoreTokens()) 
				{
					return true;
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please format the postal code correctly");
										
					if (fldPostalCode.getText().length() != 6) {
					JOptionPane.showMessageDialog(null, "Please format the postal code correctly");
					return false;
					}
					
					return true;
				}
				
			}
		}
		
//Checks for a selection of business or personal contact
		private boolean checkContactType() {
			if (fldWorkPhone.isEditable() == true && fldHomePhone.isEditable() == true) {
				JOptionPane.showMessageDialog(null, "You must select either business or personal contact");
				return false;
			}
			if (fldHomePhone.isEditable() == false) 
			{
				if (fldCompany.getText().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "You must enter a company name");
					return false;
				}
			}
			return true;
		}
		
		
		
		});//Action Listener for add contact button
		
		JButton btnClearAllFields = new JButton("Clear all fields");
		btnClearAllFields.setBounds(447, 539, 199, 29);
		
		
//		ActionListner to clear all fields
		btnClearAllFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllFields();
			}
			private void clearAllFields(){
				fldfirstName.setText("");
				fldlastName.setText("");
				fldStreetName.setText("");
				fldCity.setText("");
				fldProvince.setText("");
				fldPostalCode.setText("");
				fldEmail.setText("");
				fldCellPhone.setText("");
				fldHomePhone.setText("");
				fldSkypeName.setText("");
				fldWorkPhone.setText("");
				fldCompany.setText("");
				fldJobTitle.setText("");
				cmbxRelationship.setSelectedIndex(0);
				cmbxMonthOfBirth.setSelectedIndex(0);
				cmbxDayOfBirth.setSelectedIndex(0);
				cmbxYearOfBirth.setSelectedIndex(0);
				fldHomePhone.setEditable(true);
				fldSkypeName.setEditable(true);
				cmbxRelationship.setEnabled(true);
				fldWorkPhone.setEditable(true);
				fldCompany.setEditable(true);
				fldJobTitle.setEditable(true);
			}
		});//Action listener for clear fields button
		
		contentPane.add(btnClearAllFields);
		JLabel lblNote = new JLabel("Fields with an asterix (*) must be filled out ");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setBounds(204, 513, 442, 20);
		contentPane.add(lblNote);
		
		JLabel lblWorkPhone = new JLabel("Work Phone:");
		lblWorkPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWorkPhone.setBounds(458, 401, 92, 20);
		contentPane.add(lblWorkPhone);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompanyName.setBounds(418, 437, 132, 20);
		contentPane.add(lblCompanyName);
		
		JLabel lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJobTitle.setBounds(418, 479, 132, 20);
		contentPane.add(lblJobTitle);
		
		fldWorkPhone = new JTextField();
		fldWorkPhone.setColumns(10);
		fldWorkPhone.setBounds(569, 398, 206, 26);
		contentPane.add(fldWorkPhone);
		
		fldCompany = new JTextField();
		fldCompany.setColumns(10);
		fldCompany.setBounds(569, 434, 206, 26);
		contentPane.add(fldCompany);
		
		fldJobTitle = new JTextField();
		fldJobTitle.setColumns(10);
		fldJobTitle.setBounds(569, 476, 206, 26);
		contentPane.add(fldJobTitle);
		
	}
}
