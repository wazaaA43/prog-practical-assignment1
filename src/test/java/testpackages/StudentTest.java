/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

// Reference: OpenAI. (2025). ChatGPT [Large language model]. For guidance on unit testing concepts and the use of the JUnit framework. Retrieved from https://chat.openai.com/ [Accessed 4 September 2025].
package testpackages;

import com.mycompany.studentgrades.PostgraduateStudent;
import com.mycompany.studentgrades.Student;
import com.mycompany.studentgrades.UndergraduateStudent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class StudentTest {
    
    // A sample student object for our tests
    private Student student;
    private UndergraduateStudent ugStudent;
    private PostgraduateStudent pgStudent;
    
    // This method runs before each test to set up a clean environment
    @BeforeEach
    public void setUp() {
        student = new Student("S123", "John Doe");
        ugStudent = new UndergraduateStudent("U456", "Jane Smith", "Computer Science");
        pgStudent = new PostgraduateStudent("P789", "Peter Jones", "Quantum Computing");
    }
    
    // This method runs after each test to clean up
    @AfterEach
    public void tearDown() {
        student = null;
        ugStudent = null;
        pgStudent = null;
    }

    /**
     * Test of calculateAverageGrade method, of class Student.
     */
    @Test
    public void testCalculateAverageGrade() {
        System.out.println("Testing calculateAverageGrade...");
        student.addGrade(80.0);
        student.addGrade(90.0);
        student.addGrade(75.0);
        double expectedAvg = (80.0 + 90.0 + 75.0) / 3;
        assertEquals(expectedAvg, student.calculateAverageGrade(), 0.001, "Average grade calculation should be correct.");
    }

    /**
     * Test of addGrade method, of class Student.
     */
    @Test
    public void testAddGrade() {
        System.out.println("Testing addGrade...");
        student.addGrade(95.0);
        assertEquals(1, student.getGrades().size(), "Grades list should have one item after adding a grade.");
        assertEquals(95.0, student.getGrades().get(0), "The added grade should be correct.");
    }
    
    /**
     * Test to verify UndergraduateStudent correctly extends Student.
     */
    @Test
    public void testUndergraduateStudentInheritance() {
        System.out.println("Testing UndergraduateStudent inheritance...");
        assertEquals("U456", ugStudent.getStudentId(), "Undergraduate student should inherit student ID.");
        assertEquals("Jane Smith", ugStudent.getStudentName(), "Undergraduate student should inherit student name.");
        assertEquals("Computer Science", ugStudent.getMajor(), "Major should be correct for undergraduate student.");
    }
    
    /**
     * Test to verify PostgraduateStudent correctly extends Student.
     */
    @Test
    public void testPostgraduateStudentInheritance() {
        System.out.println("Testing PostgraduateStudent inheritance...");
        assertEquals("P789", pgStudent.getStudentId(), "Postgraduate student should inherit student ID.");
        assertEquals("Peter Jones", pgStudent.getStudentName(), "Postgraduate student should inherit student name.");
        assertEquals("Quantum Computing", pgStudent.getThesisTopic(), "Thesis topic should be correct for postgraduate student.");
    }}
