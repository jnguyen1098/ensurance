package app;

import java.util.Objects;

public class AutoClaim extends Claim {
	
	private String otherFirstName;
	private String otherLastName;
	
	private String ownerLicensePlate;
	private String otherLicensePlate;
	
	// Constructor
	public AutoClaim(String firstName, String lastName, String SIN, String driversLicenseNumber, String DOB, String otherFirstName, String otherLastName, String ownerLicensePlate, String otherLicensePlate) {
		super(firstName, lastName, SIN, driversLicenseNumber, DOB);
		this.otherFirstName = otherFirstName;
		this.otherLastName = otherLastName;
		this.ownerLicensePlate = ownerLicensePlate;
		this.otherLicensePlate = otherLicensePlate;
	}
	
	// Overrides
	public String toString() {
		String toReturn = "[";
		toReturn += "First Name: " + this.firstName + ", ";
		toReturn += "Last Name: " + this.lastName + ", ";
		toReturn += "SIN: " + this.SIN + ", ";
		toReturn += "Driver's License Number: " + this.driversLicenseNumber + ", ";
		toReturn += "DOB: " + this.DOB + ", ";
		toReturn += "Other Person First Name: " + this.otherFirstName + ", ";
		toReturn += "Other Person Last Name: " + this.otherLastName + ", ";
		toReturn += "Owner License Plate: " + this.ownerLicensePlate + ", ";
		toReturn += "Other License Plate: " + this.otherLicensePlate + "]";
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
