package service;

import model.Student;
import java.util.*;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student s) throws Exception {
        for (Student st : students) {
            if (st.getId() == s.getId()) {
                throw new Exception("Student ID already exists.");
            }
        }
        students.add(s);
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(st -> st.getId() == id);
    }

    public List<Student> searchByName(String keyword) {
        keyword = keyword.toLowerCase();
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(keyword)) {
                result.add(s);
            }
        }
        return result;
    }

    public void displayAll() {
        System.out.printf("%-10s %-30s %s\n", "ID", "Full Name", "GPA");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
