/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Reference: OpenAI. (2025). ChatGPT [Large language model]. For ideas on class structure and method implementation. Retrieved from https://chat.openai.com/ [Accessed 1 September 2025].

package com.mycompany.studentgrades;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Student {
    private String studentId;
    private String studentName;
    private ArrayList<Double> grades; // Using an advanced array (ArrayList)

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grades = new ArrayList<>();
    }

    // Getters and Setters (Information Hiding)
    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public ArrayList<Double> getGrades() { return grades; }
    public void addGrade(double grade) { this.grades.add(grade); }

    // A method for the report
    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
