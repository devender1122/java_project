package sms;

import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    // Method to add a new student
    public void addStudent(int id, String name, int age, String course) {
        Student newStudent = new Student(id, name, age, course);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    // Method to update student details by ID
    public void updateStudent(int id, String name, int age, String course) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Method to delete a student by ID
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        System.out.println("Student deleted successfully.");
    }

    // Method to display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Main method to run the system
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Student Course: ");
                    String course = scanner.nextLine();
                    sms.addStudent(id, name, age, course);
                    break;
                case 2:
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();
                    sms.updateStudent(updateId, newName, newAge, newCourse);
                    break;
                case 3:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    sms.deleteStudent(deleteId);
                    break;
                case 4:
                    sms.displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
