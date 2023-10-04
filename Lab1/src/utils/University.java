package utils;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Faculty> faculties = new ArrayList<>();

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    public void getFaculties(){
        for (Faculty faculty : faculties) {
            System.out.println("Faculty Name: " + faculty.getName());
            System.out.println("Abbreviation: " + faculty.getAbbreviation());
            System.out.println("Study Field: " + faculty.getStudyField());
            System.out.println("--------------");
        }
    }
}
