package m.group.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentManager {
	
    private Student[] students;

    // Default constructor
    public StudentManager() {
        students = new Student[0];
    }

    // Method to display details of all students
    public void displayStudents() {
        if (students.length == 0) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }

    // Helper method to add a student to the array
    private void addStudent(Student student) {
        Student[] newArray = new Student[students.length + 1];
        System.arraycopy(students, 0, newArray, 0, students.length);
        newArray[students.length] = student;
        students = newArray;
    }
}
