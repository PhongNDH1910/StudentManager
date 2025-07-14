package service;

import model.student;
import java.util.*;

public class studentService {
    private final List<student> students = new ArrayList<>();

    public void addStudent(student s) throws Exception {
        for (student st : students) {
            if (st.getId() == s.getId()) {
                throw new Exception("Student ID already exists.");
            }
        }
        students.add(s);
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(st -> st.getId() == id);
    }

    public List<student> searchByName(String keyword) {
        keyword = keyword.toLowerCase();
        List<student> result = new ArrayList<>();
        for (student s : students) {
            if (s.getFullName().toLowerCase().contains(keyword)) {
                result.add(s);
            }
        }
        return result;
    }

    public void displayAll() {
        System.out.printf("%-10s %-30s %s\n", "ID", "Full Name", "GPA");
        for (student s : students) {
            System.out.println(s);
        }
    }
}
