package HireUpMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Resume {
    private PersonalInformation PersonalInformation;
    private EducationalInformation EducationalInformation;
    private AdditionalInformation AdditionalInformation;

    public Resume() {}

    public Resume(PersonalInformation personalInformation, EducationalInformation educationalInformation, AdditionalInformation additionalInformation) {
        PersonalInformation = personalInformation;
        EducationalInformation = educationalInformation;
        AdditionalInformation = additionalInformation;
    }

    public PersonalInformation getPersonalInformation() {
        return PersonalInformation;
    }
    public EducationalInformation getEducationalInformation() {
        return EducationalInformation;
    }
    public AdditionalInformation getAdditionalInformation() {
        return AdditionalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        PersonalInformation = personalInformation;
    }
    public void setEducationalInformation(EducationalInformation educationalInformation) {
        EducationalInformation = educationalInformation;
    }
    public void setAdditionalInformation(AdditionalInformation additionalInformation) {
        AdditionalInformation = additionalInformation;
    }

    public boolean generateResume(String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Applicant_info.txt", true))) {
            writer.write(PersonalInformation.toFileString()+","+"Email:"+email+
                    EducationalInformation.toFileString()+","+
                    AdditionalInformation.toFileString());
            writer.newLine();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void showResume() {
        

    }

    }
