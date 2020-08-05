package student.database.application;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
//    properties

    private String fName, lName, courses = "", studentID;
    private int studentYear, tuitionBalance = 0, costofCourse = 600, id = 1000;

    //constructor prompt for student name and year
    public Student() {
        Scanner kb = new Scanner(System.in);

        boolean isValid = false;
//        propmt user and validate input
        while (!isValid) {
            System.out.print("Enter First Name : ");
            this.fName = kb.nextLine();

            System.out.print("Enter Last Name : ");
            this.lName = kb.nextLine();

            if (isWord(fName) && isWord(lName)) {
                isValid = true;
            } else {
                System.out.println("Invalid Input. Try Aagain");
            }
        }

        System.out.print("Enter Student Year Level : ");
        this.studentYear = kb.nextInt();
        setStudentID();
        System.out.println("");
//        System.out.println("Student Created : " + fName + " "
//                + lName + " " + studentYear + " " + studentID);

    }

    //static??/ value not specif to obj but belongs to class not instance of obj
    
//validates for a word
    public static boolean isWord(String x) {
        return Pattern.matches("[a-zA-z]+", x);
    }

    //generate unique ID
    private void setStudentID() {
        //grade level + ID
        id++;
        this.studentID = studentYear + "" + id;
    }

    //Enroll in courses
    public void Enroll() {
//        gets into loop, user hits q
        do {
            System.out.print("Enter Course to enroll (Q to Quit) : ");
            Scanner kb = new Scanner(System.in);
            String course = kb.nextLine();

            if (course.equalsIgnoreCase("Q")) {
                break;
            } else {

                //                adds enrolled course to list 
                courses = courses + "\n " + course;
//                adds tuition for each course
                tuitionBalance += costofCourse;
            }
        } while (1 != 0);
        System.out.println("");
//        System.out.println("Enrolled in : "+courses);
//        System.out.println("Tution Balance : "+tuitionBalance);
    }

    //view balance 
    public void viewBalance() {
        System.out.println("Your Balance is R" + tuitionBalance);
        System.out.println("");
    }
//    pay tution

    public void payTuition() {
        viewBalance();
        System.out.print("How much do you wanna pay? R");
        Scanner kb = new Scanner(System.in);
        int x = kb.nextInt();
        tuitionBalance -= x;
        System.out.println("Thank You for paying R" + x);
        System.out.println("");
        viewBalance();
    }

    //show status
    public String toString() {
        return "Name : " + fName + " " + lName
                + "\nStudent ID : " + studentID
                + "\nCourses Enrolled : " + courses
                + "\nBalance : " + tuitionBalance;

    }

}
