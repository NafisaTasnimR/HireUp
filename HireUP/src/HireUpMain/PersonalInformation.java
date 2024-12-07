package HireUpMain;

import static HireUpMain.Utility.formatData;

public class PersonalInformation {
   private String name;
   private String fatherName;
   private String motherName;
   private String dateOfBirth;
   private String nationality;
   private String religion;
   private String gender;
   private String phoneNumber;
   private String address;
   private String nationalID;

    public PersonalInformation(String name, String fatherName, String motherName,
                               String dateOfBirth, String nationality, String religion,
                               String gender, String phoneNumber, String address, String nationalID) {
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.religion = religion;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.nationalID = nationalID;
    }

    public PersonalInformation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }
    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalID() {
        return nationalID;
    }
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String toFileString() {
        return formatData(getName()) + "," + formatData(getFatherName()) + "," + formatData(getMotherName()) + ","
                + getDateOfBirth() + "," + formatData(getNationality()) + ","
                + formatData(getReligion()) + "," + formatData(getGender()) + ","
                + getPhoneNumber() + "," + getAddress() + "," + getNationalID();

    }


}
