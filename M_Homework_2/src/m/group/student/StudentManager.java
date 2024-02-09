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

	///File reader and formatter 
	public boolean readFromFile(String fileName)
    {
    	try
		{
			Scanner fileIn = new Scanner(new FileInputStream(fileName));
				while(fileIn.hasNext())
				{
					////Variable Declaration
					int id = fileIn.nextInt();
					String name = fileIn.next()+" "+fileIn.next();
					double grade = fileIn.nextDouble();
					int organize = id;
					
					///Adding objects to list
					Student student= new Student(id,name,grade);
					addStudent(student);
				}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Error: Data not found");
			return false;
		}
    	return true;
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
    
    //Method to search students by id
    public boolean searchStudentById(int id) {
    	for (Student student : students) {
    		if (student.getId() == id) {
    			System.out.println("Student with ID " + id + " found!");
    			System.out.println(student.toString());
    			return true;
    		}
    	}
    	System.out.println("Student with ID " + id + " not found!");
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
