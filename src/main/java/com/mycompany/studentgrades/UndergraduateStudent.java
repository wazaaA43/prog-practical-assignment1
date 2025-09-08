/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Reference: OpenAI. (2025). ChatGPT [Large language model]. For ideas on what to put in child classes, specifically UndergraduateStudent.java class. Retrieved from https://chat.openai.com/ [Accessed 2 September 2025].

package com.mycompany.studentgrades;

/**
 *
 * @author user
 */
public class UndergraduateStudent extends Student {
    private String major;
    
    public UndergraduateStudent(String studentId, String studentName, String major) {
        super(studentId, studentName);
        this.major = major;
    }
    
    public String getMajor() {
        return major;
    }
    
    
}
