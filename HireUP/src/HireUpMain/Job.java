package HireUpMain;

public class
Job {
    private String companyName;
    private String jobPosition;
    private String skill;
    private String experience;
    private String salary;
    private String location;
    private String time;
    private String websiteLink;
    private String additional;

    public Job() {
    }

    public Job(String companyName, String jobPosition,
               String skill, String experience, String salary,
               String location, String time, String websiteLink,
               String additional) {

        this.companyName = companyName;
        this.jobPosition = jobPosition;
        this.skill = skill;
        this.experience = experience;
        this.salary = salary;
        this.location = location;
        this.time = time;
        this.websiteLink = websiteLink;
        this.additional = additional;
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
    public String getExperience() {
        return experience;
    }

    public String getSalary() {
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

    public String getAdditional() {
        return additional;
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
                "Additional Info: " + additional ;
    }

}
