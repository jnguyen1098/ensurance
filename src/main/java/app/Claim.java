package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Claim {
	
	protected String firstName;
	protected String lastName;
	protected String SIN;
	protected String driversLicenseNumber;
	protected String DOB;
	
	
	// Constructor
	public Claim(
			String firstName, 
			String lastName, 
			String SIN, 
			String driversLicenseNumber, 
			String DOB
			) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.SIN = SIN;
		this.driversLicenseNumber = driversLicenseNumber;
		this.DOB = DOB;
	}
	
	public Claim(String filename) throws IOException {
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(filename));
		while ((line = br.readLine()) != null) {
			String[] fileLine = line.split(",");
			this.firstName = fileLine[0];
			this.lastName = fileLine[1];
			this.SIN = fileLine[2];
			this.driversLicenseNumber = fileLine[3];
			this.DOB = fileLine[4];
		}
		// System.out.println(this.toString());
		// System.out.println(this.toHash());
		br.close();
	}
	
	// Overrides
	public String toString() {
		String toReturn = "[";
		toReturn += "First Name: " + firstName + ", ";
		toReturn += "Last Name: " + lastName + ", ";
		toReturn += "SIN: " + SIN + ", ";
		toReturn += "Driver's License Number: " + driversLicenseNumber + ", ";
		toReturn += "DOB: " + DOB + "]";
		return toReturn;
	}
	
	public String toHash() {
		String preProcess = this.toString();
		String toReturn = StringUtil.encode(preProcess);
		return toReturn;
	}
	
	public boolean equals(Object o) {
//		if (o == this) return true;
//		if (!(o instanceof Claim)) return false;
//		Claim c = (Claim) o;
//		return Objects.equals(c.customerName, this.customerName) &&
//			   Objects.equals(c.data, this.data);
		return false;
	}
}
