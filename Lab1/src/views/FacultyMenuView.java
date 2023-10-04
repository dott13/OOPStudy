package views;

import utils.Faculty;
import utils.University;

import java.io.IOException;
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
        switch (options){
            case 1: clearConsole();
                    addFaculty();
        }
    }

    private void addFaculty() {
        Faculty faculty = new Faculty();
        faculty.setFaculty(faculty);
        this.university.addFaculty(faculty);
    }
}
