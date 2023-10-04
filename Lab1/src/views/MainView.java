package views;

import helpers.ConsoleHelper;

import java.io.IOException;
import java.util.Scanner;

public class MainView extends ConsoleHelper {
    private Integer option;
    private Scanner scanner;
    private FacultyMenuView facultyMenuView;
    private StudentMenuView studentMenuView;
    public MainView(){
        this.option = 31;
        this.scanner = new Scanner(System.in);
        this.facultyMenuView = new FacultyMenuView();
    }
    public void run() throws IOException, InterruptedException {
        clearConsole();
        System.out.println("TUM - Management System");
        System.out.println("Chose What you want to do");;
        System.out.println("1. Faculty Options");
        System.out.println("2. Student Options");
        System.out.println("0. Quit");

        while(this.option != 0){
            this.option = scanner.nextInt();
            switch (option){
                case 1: clearConsole();
                        facultyMenuView.run();
                        break;
                case 2: clearConsole();
                        studentMenuView.run();
                case 0: break;
                default: System.out.println("This is not a valid command");
            }
        }
    }
}
