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

    // Method to read student data from a file and initialize Student objects
    public boolean readFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new FileInputStream(new File(fileName)))) {
            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                String name = scanner.next();
                double grade = scanner.nextDouble();

                // Create a new student object
                Student student = new Student(id, name, grade);

                // Add the student to the array
                addStudent(student);
            }
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return false;
        }
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

    // Method to search for a student by ID
    public boolean searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student found:\n" + student.toString());
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return false;
    }

    // Method to update a student's grade by ID
    public boolean updateStudentGradeById(int id, double grade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(grade);
                System.out.println("Student's grade updated successfully.");
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found. Update unsuccessful.");
        return false;
    }

    // Helper method to add a student to the array
    private void addStudent(Student student) {
        Student[] newArray = new Student[students.length + 1];
        System.arraycopy(students, 0, newArray, 0, students.length);
        newArray[students.length] = student;
        students = newArray;
    }
}
