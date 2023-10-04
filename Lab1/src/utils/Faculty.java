package utils;

import java.util.List;
import java.util.Scanner;

public class Faculty {
        private String name;
        private String abbreviation;
        private List<Student> students;
        private StudyField studyField;
        private Scanner scanner;
        public Faculty(){
                this.name = "";
                this.abbreviation = "";
                this.scanner = new Scanner(System.in);
        }

        public void setFaculty(Faculty faculty) {
                System.out.println("Introduce faculty name=");
                faculty.name = scanner.nextLine();
                System.out.println("Introduce abbreviation=");
                faculty.abbreviation = scanner.nextLine();
                System.out.println("Introduce StudyField");
                faculty.studyField = StudyField.valueOf(scanner.nextLine());
        }
}
