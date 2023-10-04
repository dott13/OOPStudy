package views;

import com.sun.tools.javac.Main;
import utils.Faculty;
import utils.University;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static helpers.ConsoleHelper.clearConsole;

public class FacultyMenuView {
    private Scanner scanner;
    private Faculty faculty;
    private University university;
    private int options;

    FacultyMenuView(){
        this.scanner = new Scanner(System.in);
        this.faculty = new Faculty();
        this.university = new University();
        this.options = 31;
    }
    public void run() throws IOException, InterruptedException {
        System.out.println("1. Create new faculty");
        System.out.println("2. Print a list of faculties");
        System.out.println("3. Print all faculties belonging to a study field");
        System.out.println("4. Give a list with all the students of a faculty");
        System.out.println("\n 0. Go Back");
        this.options = scanner.nextInt();
        while (options != 0){
        switch (options){
            case 1: clearConsole();
                    addFaculty();
                System.out.println("Faculty added");
                run();
                    break;
            case 2: clearConsole();
                    university.getFaculties();
                System.out.println("These are all the faculties. (press 1 - to continue)");
                if(scanner.nextInt() == 1){
                    run();
                }break;
            case 0: clearConsole();
                System.out.println("TUM - Management System");
                System.out.println("Chose What you want to do");;
                System.out.println("1. Faculty Options");
                System.out.println("2. Student Options");
                System.out.println("0. Quit");
                    break;
            }
        }
    }

    private void addFaculty() {
        Faculty faculty = new Faculty();
        faculty.setFaculty(faculty);
        this.university.addFaculty(faculty);
    }
}
