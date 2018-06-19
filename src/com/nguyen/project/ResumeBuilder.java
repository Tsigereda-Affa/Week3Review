package com.nguyen.project;

public class ResumeBuilder {

    static Resume myResume;
    static Education anEducation;
    static Experience anExperience;
    static Skill aSkill;

    private static String display = "";

    public static void main(String[] args) {
        populateClasses();
        populateUserInfo();
        populateEducations();
        populateExperiences();
        populateSkills();
        System.out.println(displayResume());
    }

    public static void populateClasses() {
        myResume = new Resume("Diem", "Nguyen", "dnguyen@email.com", "000-000-0000");
        anEducation = new Education("UMD", "BS", "Information Systems", "College Park", "MD");
        anExperience = new Experience("Teaching Assistant", "Montgomery College", 2, "Aided lead instructors in the Java Bootcamps");
        aSkill = new Skill("Java","Proficient");

        myResume.addEducation(anEducation);
        myResume.addExperience(anExperience);
        myResume.addSkill(aSkill);

        //System.out.println("Created a default profile...");

    }

    public static void populateUserInfo() {
        display+=myResume.getFirstName()+" "+myResume.getLastName()+"\n"+
                myResume.getPhoneNo()+"\t\t"+ myResume.getEmail()+"\n\n";
    }

    public static void populateEducations() {
        display+="EDUCATION \n";
        for (Education thisEducation : myResume.getEducations()) {
            display+=thisEducation.getUniversityName()+"\t\t"+thisEducation.getCity()+", "+thisEducation.getState()+"\n"
                    +thisEducation.getDegreeType()+" "+thisEducation.getDegreeName()+"\n\n";
        }
    }

    public static void populateExperiences() {
        display+="EXPERIENCES \n";
        for (Experience thisExperience : myResume.getExperiences()) {
            display+=thisExperience.getJobTitle()+"\t\t"+thisExperience.getCompanyName()+" "+thisExperience.getWorkDuration()+" years"+"\n"
                    +thisExperience.getDescription()+"\n\n";
        }
    }

    public static void populateSkills() {
        display+="SKILLS \n";
        for (Skill thisSkill : myResume.getSkills()) {
            display+=thisSkill.getSkillName()+"\t\t"+thisSkill.getProficiency()+"\n\n";
        }
    }

    public static String displayResume() {
        return display;
    }

}
