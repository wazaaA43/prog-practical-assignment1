/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

// Reference: OpenAI. (2025). ChatGPT [Large language model]. Ideas for Java console application menu structure and basic program flow. Retrieved from https://chat.openai.com/ [Accessed 1 September 2025].

package com.mycompany.studentgrades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */

public class StudentApp {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            // Display menu options
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("(1) Add a new student");
            System.out.println("(2) Search for a student");
            System.out.println("(3) Print all student grades (Report)");
            System.out.println("(4) Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
                    printReport();
                    break;
                case "4":
                    System.out.println("Exiting application. Goodbye!");
                    return; // Stop the loop and end the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void addStudent() {
        
        System.out.println("\n--- Add a New Student ---");
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Is this an (U)ndergraduate or (P)ostgraduate student? ");
        String type = scanner.nextLine();

        Student newStudent;
        if (type.equalsIgnoreCase("u")) {
            System.out.print("Enter major: ");
            String major = scanner.nextLine();
            
            newStudent = new UndergraduateStudent(id, name, major);
            
        } else if (type.equalsIgnoreCase("p")) {
            System.out.print("Enter thesis topic: ");
            String thesis = scanner.nextLine();
            
            newStudent = new PostgraduateStudent(id, name, thesis);
            
        } else {
            System.out.println("Invalid student type. Student not added.");
            return;
        }

        // Capture grades
        System.out.print("Enter grades separated by spaces (e.g., 85.5 90 78): ");
        String gradesInput = scanner.nextLine();
        
        String[] gradeArray = gradesInput.split(" ");
        
        for (String gradeStr : gradeArray) {
            try {
                double grade = Double.parseDouble(gradeStr);
                newStudent.addGrade(grade);
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade format. Skipping '" + gradeStr + "'.");
            }
        }

        studentList.add(newStudent);
        System.out.println("Student added successfully!");

    }
    
    public static void searchStudent() {
        System.out.println("\n--- Search for a Student ---");
        
        System.out.print("Enter student ID to search: ");
        String searchId = scanner.nextLine();

        Student foundStudent = null;
        for (Student s : studentList) {
            if (s.getStudentId().equals(searchId)) {
                foundStudent = s;
                break; // Exit the loop once the student is found
            }
        }

        if (foundStudent != null) {
            System.out.println("Student Found!");
            System.out.println("ID: " + foundStudent.getStudentId());
            System.out.println("Name: " + foundStudent.getStudentName());
            System.out.println("Average Grade: " + String.format("%.2f", foundStudent.calculateAverageGrade()));

            // Using instanceof to access specific child class information (Polymorphism)
            if (foundStudent instanceof UndergraduateStudent) {
                UndergraduateStudent ug = (UndergraduateStudent) foundStudent;
                System.out.println("Major: " + ug.getMajor());
                
            } else if (foundStudent instanceof PostgraduateStudent) {
                PostgraduateStudent pg = (PostgraduateStudent) foundStudent;
                System.out.println("Thesis Topic: " + pg.getThesisTopic());
                
            }
            
        } else {
            System.out.println("Student with ID " + searchId + " was not found.");
        }
        
    }
    
    public static void printReport() {
        System.out.println("\n--- Student Grades Report ---");
        
        if (studentList.isEmpty()) {
            System.out.println("No students have been added yet.");
            return;
        }

        for (Student student : studentList) {
            System.out.println("----------------------------------------");
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getStudentName());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Grade: " + String.format("%.2f", student.calculateAverageGrade()));

            // Display unique attributes based on student type
            if (student instanceof UndergraduateStudent) {
                UndergraduateStudent ug = (UndergraduateStudent) student;
                System.out.println("Type: Undergraduate (Major: " + ug.getMajor() + ")");
                
            } else if (student instanceof PostgraduateStudent) {
                PostgraduateStudent pg = (PostgraduateStudent) student;
                System.out.println("Type: Postgraduate (Thesis: " + pg.getThesisTopic() + ")");
                
            }
            
        }
        
        System.out.println("----------------------------------------");
        
    }
    
}
