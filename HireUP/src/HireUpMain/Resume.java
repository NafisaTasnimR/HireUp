package HireUpMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Resume {
    private PersonalInformation PersonalInformation;
    private EducationalInformation EducationalInformation;
    private AdditionalInformation AdditionalInformation;

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

    public boolean generateResume() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\HireUp\\HireUp\\HireUP\\Applicant_info.txt", true))) {
            writer.write(PersonalInformation.toFileString()+","+EducationalInformation.toFileString()+","+AdditionalInformation.toFileString());


            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
