package student.database.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDatabaseApplication {

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner kb = new Scanner(System.in);
        try{
            //ask how user how many students to be added
        System.out.print("How many students to you want to add? ");
        int numOfStudents = kb.nextInt();
        
        //creation of students
        Student[] students = new Student[numOfStudents];
        
        //creat n number of users
        for (int x = 0; x < numOfStudents; x++) {
            students[x] = new Student();
            students[x].Enroll();
            students[x].payTuition();
            System.out.println(students[x].toString());
            System.out.println("");
        }
        }catch(InputMismatchException e)
        {
            System.out.println(e.getMessage());
        }
        
    }

}
