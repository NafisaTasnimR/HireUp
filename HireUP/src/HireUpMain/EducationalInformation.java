package HireUpMain;

public class EducationalInformation extends PersonalInformation{
    private String name;
    private String schoolName;
    private int sscPassingYear;
    private double sscOLevelResult;
    private String collegeName;
    private int hscPassingYear;
    private double hscALevelResult;
    private String universityName;
    private String department;
    private String undergraduateDegree;
    private double undergradCGPA;
    private String postgraduateDegree;
    private double postgradCGPA;

    public EducationalInformation(String name, String schoolName, int sscPassingYear, double sscOLevelResult, String collegeName, int hscPassingYear, double hscALevelResult, String universityName, String department, String undergraduateDegree, double undergradCGPA, String postgraduateDegree, double postgradCGPA) {
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
    public int getSscPassingYear(){
        return sscPassingYear;
    }
    public double getSscOLevelResult(){
        return sscOLevelResult;
    }
    public String getCollegeName(){
        return collegeName;
    }
    public int getHscPassingYear(){
        return hscPassingYear;
    }
    public double getHscALevelResult(){
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
    public double getUndergradCGPA(){
        return undergradCGPA;
    }
    public String getPostgraduateDegree(){
        return postgraduateDegree;
    }
    public double getPostgradCGPA(){
        return postgradCGPA;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }
    public void setSscPassingYear(int sscPassingYear){
        this.sscPassingYear = sscPassingYear;
    }
    public void setSscOLevelResult(int sscOLevelResult){
        this.sscOLevelResult = sscOLevelResult;
    }
    public void setCollegeName(String collegeName){
        this.collegeName = collegeName;
    }
    public void setHscPassingYear(int hscPassingYear){
        this.hscPassingYear = hscPassingYear;
    }
    public void setHscALevelResult(int hscALevelResult){
        this.hscALevelResult = hscALevelResult;
    }
    public void setUniversityName(String universityName){
        this.universityName = universityName;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setUndergraduateDegree(String undergraduateDegree){
        this.undergraduateDegree = undergraduateDegree;
    }
    public void setUndergradCGPA(int undergradCGPA){
        this.undergradCGPA = undergradCGPA;
    }
    public void setPostgraduateDegree(String postgraduateDegree){
        this.postgraduateDegree = postgraduateDegree;
    }
    public void setPostgradCGPA(int postgradCGPA){
        this.postgradCGPA = postgradCGPA;
    }

    public String toFileString() {
        return  "SchoolName: " + getSchoolName() + "\n"
                + "SSCPassingYear: " + getSscPassingYear() + "\n"
                + "SSCOLevelResult: " + getSscOLevelResult() + "\n"
                + "CollegeName: " + getCollegeName() + "\n"
                + "HSCPassingYear: " + getHscPassingYear() + "\n"
                + "HSCALevelResult: " + getHscALevelResult() + "\n"
                + "UniversityName: " + getUniversityName() + "\n"
                + "Department: " + getDepartment() + "\n"
                + "UndergraduateDegree: " + getUndergraduateDegree() + "\n"
                + "UndergradCGPA: " + getUndergradCGPA() + "\n"
                + "PostgraduateDegree: " + getPostgraduateDegree() + "\n"
                + "PostgradCGPA: " + getPostgradCGPA() + "\n";


    }
}
