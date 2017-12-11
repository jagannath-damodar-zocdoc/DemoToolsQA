package com.toolsqa.dataobjects;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.opencsv.CSVReader;

public class RegistrationData {
	
	String username ;
	String emailId ;
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
		@DataProvider(name = "regData")	
		public Object[][] getRegistrationData() throws IOException{		
			/*
			   CSVReader csv = new CSVReader(new FileReader(
					RegistrationData.class.getResource("/registrationTestdata.csv").getPath() ) );			
			*/
			
			CSVReader csv = new CSVReader(new FileReader("C:\\Users\\JAGANNATH\\Desktop\\"
					+ "GIT Repository\\automateMercuryTours\\"
					+ "DemoToolsQA\\target\\classes\\registrationTestdata.csv"));			
												
			List<String[]> csvList = csv.readAll();
			csv.close();
			
			System.out.println(csvList);
			// Size of the Object array should be equal to no of lines in csv test data file.  
			Object[][] regDataObjectArray = new Object [csvList.size()][1];

			// arraylist to store registration data objects
			List<RegistrationData> regDataArrayList = new ArrayList<RegistrationData>() ;
			
			// create one registration object for each test data 
			// add the object to arraylist
			for (String[] strArray : csvList) {
				RegistrationData aRegData = new RegistrationData();
				aRegData.setUsername(strArray[0]);
				aRegData.setEmailId(strArray[1]);				
				regDataArrayList.add(aRegData);
			}
			
			// add registration test data array of object 
			for (int i =0 ; i < regDataObjectArray.length ; i++ ){
				for (int j =0 ; j < regDataObjectArray[i].length ; j++){
					regDataObjectArray[i][j] = regDataArrayList.get(i);					
					System.out.println("[i][j]= " + i + " " + j );
				}								
			}			
			return regDataObjectArray;					
		} // end of get registration data method
				
} // end of class
