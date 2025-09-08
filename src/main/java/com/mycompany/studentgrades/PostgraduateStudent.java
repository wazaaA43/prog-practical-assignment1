/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Reference: OpenAI. (2025). ChatGPT [Large language model]. For ideas on what to put in child classes, specifically PostgraduateStudent.java class. Retrieved from https://chat.openai.com/ [Accessed 2 September 2025].
package com.mycompany.studentgrades;

/**
 *
 * @author user
 */

public class PostgraduateStudent extends Student {
    private String thesisTopic;

    public PostgraduateStudent(String studentId, String studentName, String thesisTopic) {
        super(studentId, studentName);
        this.thesisTopic = thesisTopic;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }
}
