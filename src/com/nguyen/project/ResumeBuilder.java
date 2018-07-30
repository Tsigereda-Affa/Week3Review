package com.nguyen.project;

import java.util.ArrayList;
import java.util.Scanner;

public class ResumeBuilder {

    private static Resume myResume;
    private static Education anEducation;
    private static Experience anExperience;
    private static Skill aSkill;

    private static Scanner sc = new Scanner(System.in);

    private static String input = "";
    private static String display = "";

    public static void main(String[] args) {
        //populateClasses();

        askPersonalInfo();
        populateUserInfo();

        askEducations();
        display+="EDUCATIONS \n";
        populateEducations();

        askExperiences();
        display+="EXPERIENCES \n";
        populateExperiences();

        askSkills();
        display+="SKILLS \n";
        populateSkills();

        println(displayResume());
    }

    public static void askPersonalInfo() {
        myResume = new Resume();
        print("Enter your first name: ");
        input = sc.next();
        myResume.setFirstName(input);

        print("Enter your last name: ");
        input = sc.next();
        myResume.setLastName(input);

        print("Enter your email address: ");
        input = sc.next();
        myResume.setEmail(input);

        print("Enter your phone number: ");
        input = sc.next();
        myResume.setPhoneNo(input);
        input = "";//clear input
    }

    public static void askEducations() {
        println("*****  Enter your educations...  *****");
        while (!(input.equalsIgnoreCase("n"))){
            anEducation = new Education();
            print("Enter your degree type: ");
            input = sc.next();
            anEducation.setDegreeType(input);

            //anEducation.setDegreeType(sc.nextLine());

            print("Enter your degree name: ");
            input = sc.next();
            anEducation.setDegreeName(input);

            print("Enter your university name: ");
            input = sc.next();
            anEducation.setUniversityName(input);

            print("Enter your university's city: ");
            input = sc.next();
            anEducation.setCity(input);

            print("Enter your university's state: ");
            input = sc.next();
            anEducation.setState(input);

            print("Do you want to enter another (y/n)? ");
            input = sc.next();

//            ArrayList<Education> currEducations = new ArrayList<>();
//            currEducations.add(anEducation);
//
//            myResume.setEducations(currEducations);

            myResume.addEducation(anEducation);
        }
        input = "";
    }

    public static void askExperiences() {
        println("*****  Enter your experiences...  *****");
        while (!(input.equalsIgnoreCase("n"))){
            anExperience = new Experience();
            print("Enter the company name: ");
            input = sc.next();
            anExperience.setCompanyName(input);

            print("Enter the job title: ");
            input = sc.next();
            anExperience.setJobTitle(input);

            print("Enter the description: ");
            input = sc.next();
            anExperience.setDescription(input);

            print("Enter the duration at this company (months): ");
            int durationInput = sc.nextInt();
            anExperience.setWorkDuration(durationInput);

            print("Do you want to enter another (y/n)? ");
            input = sc.next();
            myResume.addExperience(anExperience);
        }
        input = "";
    }

    public static void askSkills() {
        println("*****  Enter your skills...   *****");
        while (!(input.equalsIgnoreCase("n"))){
            aSkill = new Skill();
            print("Enter the skill name: ");
            input = sc.next();
            aSkill.setSkillName(input);

            print("Enter the level of proficiency: ");
            input = sc.next();
            aSkill.setProficiency(input);

            print("Do you want to enter another (y/n)? ");
            input = sc.next();
            myResume.addSkill(aSkill);
        }
        input = "";
    }

    public static void populateClasses() {
        myResume = new Resume("Diem", "Nguyen", "dnguyen@email.com", "000-000-0000");
        anEducation = new Education("UMD", "BS", "Information Systems", "College Park", "MD");
        anExperience = new Experience("Teaching Assistant", "Montgomery College", 2, "Aided lead instructors in the Java Bootcamps");
        aSkill = new Skill("Java","Proficient");

        myResume.addEducation(anEducation);
        myResume.addExperience(anExperience);
        myResume.addSkill(aSkill);

    }

    public static void populateUserInfo() {
        display+=myResume.getFirstName()+" "+myResume.getLastName()+"\n"+
                myResume.getPhoneNo()+"\t\t"+ myResume.getEmail()+"\n\n";
    }

    public static void populateEducations() {
        for (Education thisEducation : myResume.getEducations()) {
            display+=thisEducation.getUniversityName()+"\t\t"+thisEducation.getCity()+", "+thisEducation.getState()+"\n"
                    +thisEducation.getDegreeType()+" "+thisEducation.getDegreeName()+"\n\n";
        }
    }

    public static void populateExperiences() {
        for (Experience thisExperience : myResume.getExperiences()) {
            display+=thisExperience.getJobTitle()+"\t\t"+thisExperience.getCompanyName()+" "+thisExperience.getWorkDuration()+" years"+"\n"
                    +thisExperience.getDescription()+"\n\n";
        }
    }

    public static void populateSkills() {
        for (Skill thisSkill : myResume.getSkills()) {
            display+=thisSkill.getSkillName()+"\t\t"+thisSkill.getProficiency()+"\n";
        }
    }

    public static String displayResume() {
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        return display;
    }

    private static void println(String output){
        System.out.println(output);
    }
    private static void print(String output) {
        System.out.print(output);
    }

}
