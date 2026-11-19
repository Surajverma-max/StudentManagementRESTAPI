
package com.kiet.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.student.model.Student;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Add sample student when application starts
    public StudentService() {
        students.add(new Student(
            101,
            "Rahul",
            "rahul@gmail.com",
            "CSE",
            2,
            8.5
        ));

        students.add(new Student(
            102,
            "Aman",
            "aman@gmail.com",
            "ECE",
            2,
            8.0
        ));

        students.add(new Student(
            103,
            "Priya",
            "priya@gmail.com",
            "CSE",
            3,
            9.0
        ));
    }

    // Add student
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Get student by ID
    public Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }

    // Update student
    public Student updateStudent(int id, Student updatedStudent) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                s.setName(updatedStudent.getName());
                s.setEmail(updatedStudent.getEmail());
                s.setBranch(updatedStudent.getBranch());
                s.setYear(updatedStudent.getYear());
                s.setCgpa(updatedStudent.getCgpa());

                return s;
            }
        }
        return null;
    }

    // Delete student
    public boolean deleteStudent(int id) {
        return students.removeIf(
            s -> s.getStudentId() == id
        );
    }

    // Search students by branch
    public List<Student> searchByBranch(String branch) {
        List<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getBranch().equalsIgnoreCase(branch)) {
                result.add(s);
            }
        }

        return result;
    }
}
