package HireUpMain;

public class Job {
    private String companyName;
    private String jobPosition;
    private String skill;
    private int experience;
    private double salary;
    private String location;
    private String time;
    private String websiteLink;
    private String additionalInfo;


    public Job(String companyName, String jobPosition, String skill, int experience, double salary,
               String location, String time, String websiteLink, String additionalInfo) {
        this.companyName = companyName;
        this.jobPosition = jobPosition;
        this.skill = skill;
        this.experience = experience;
        this.salary = salary;
        this.location = location;
        this.time = time;
        this.websiteLink = websiteLink;
        this.additionalInfo = additionalInfo;
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getSkill() {
        return skill;
    }

    public int getExperience() {
        return experience;
    }

    public double getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }


    @Override
    public String toString() {
        return "Job Details: " +
                "Company: " + companyName +
                "Position: " + jobPosition +
                "Required Skill: " + skill +
                "Experience: " + experience + " years" +
                "Salary: $" + salary +
                "Location: " + location +
                "Type: " + time +
                "Website: " + websiteLink +
                "Additional Info: " + additionalInfo ;
    }
}
