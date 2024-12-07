package HireUpMain;

import static HireUpMain.Utility.formatData;

public class AdditionalInformation extends PersonalInformation{
    private String name;
    private String experience;
    private String hobby;
    private String Skills;

    public AdditionalInformation(String name,String experience, String hobby, String Skills) {
        super(name);
        this.experience = experience;
        this.hobby = hobby;
        this.Skills = Skills;
    }
    public String getName() {
        return name;
    }
    public String getExperience() {
        return experience;
    }
    public String getHobby() {
        return hobby;
    }
    public String getSkills() {
        return Skills;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public void setSkills(String Skills) {
        this.Skills = Skills;
    }

    public String toFileString() {
        return getExperience() + "," + formatData(getHobby()) + "," + formatData(getSkills()) ;
    }


}
