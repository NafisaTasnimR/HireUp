package HireUpMain;

import static HireUpMain.Utility.formatData;

public class AdditionalInformation {
    private String experience;
    private String hobby;
    private String Skills;

    public AdditionalInformation(String experience, String hobby, String Skills) {

        this.experience = experience;
        this.hobby = hobby;
        this.Skills = Skills;
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
