package HireUpMain;

import static HireUpMain.Utility.formatData;

public class EducationalInformation extends PersonalInformation{
    private String name;
    private String schoolName;
    private String sscPassingYear;
    private String sscOLevelResult;
    private String collegeName;
    private String hscPassingYear;
    private String hscALevelResult;
    private String universityName;
    private String department;
    private String undergraduateDegree;
    private String undergradCGPA;
    private String postgraduateDegree;
    private String postgradCGPA;

    public EducationalInformation(String name, String schoolName, String sscPassingYear,
                                  String sscOLevelResult, String collegeName, String hscPassingYear,
                                  String hscALevelResult, String universityName, String department,
                                  String undergraduateDegree, String undergradCGPA,
                                  String postgraduateDegree, String postgradCGPA) {
        super(name);
        this.schoolName = schoolName;
        this.sscPassingYear = sscPassingYear;
        this.sscOLevelResult = sscOLevelResult;
        this.collegeName = collegeName;
        this.hscPassingYear = hscPassingYear;
        this.hscALevelResult = hscALevelResult;
        this.universityName = universityName;
        this.department = department;
        this.undergraduateDegree = undergraduateDegree;
        this.undergradCGPA = undergradCGPA;
        this.postgraduateDegree = postgraduateDegree;
        this.postgradCGPA = postgradCGPA;

    }

    public String getName(){
        return name;
    }
    public String getSchoolName(){
        return schoolName;
    }
    public String getSscPassingYear(){
        return sscPassingYear;
    }
    public String getSscOLevelResult(){
        return sscOLevelResult;
    }
    public String getCollegeName(){
        return collegeName;
    }
    public String getHscPassingYear(){
        return hscPassingYear;
    }
    public String getHscALevelResult(){
        return hscALevelResult;
    }
    public String getUniversityName(){
        return universityName;
    }
    public String getDepartment(){
        return department;
    }
    public String getUndergraduateDegree(){
        return undergraduateDegree;
    }
    public String getUndergradCGPA(){
        return undergradCGPA;
    }
    public String getPostgraduateDegree(){
        return postgraduateDegree;
    }
    public String getPostgradCGPA(){
        return postgradCGPA;
    }


    public String toFileString() {
        return  getSchoolName() + ","
                + getSscPassingYear() + ","
                + getSscOLevelResult() + ","
                + formatData(getCollegeName()) + ","
                + getHscPassingYear() + ","
                + getHscALevelResult() + ","
                + formatData(getUniversityName()) + ","
                + formatData(getDepartment()) + ","
                + getUndergraduateDegree() + ","
                + getUndergradCGPA() + ","
                + getPostgraduateDegree() + ","
                + getPostgradCGPA() ;
    }
}
