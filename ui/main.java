package ui;

import model.student;
import service.studentService;

import java.util.Scanner;
import java.util.List;

public class main {
    public static void main(String[] args) {
        studentService service = new studentService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter GPA: ");
                        double gpa = Double.parseDouble(sc.nextLine());

                        student s = new student(id, name, gpa);
                        service.addStudent(s);
                        break;

                    case 2:
                        System.out.print("Enter ID to delete: ");
                        int delId = Integer.parseInt(sc.nextLine());
                        boolean deleted = service.deleteStudent(delId);
                        System.out.println(deleted ? "Deleted successfully." : "Student not found.");
                        break;

                    case 3:
                        System.out.print("Enter name to search: ");
                        String keyword = sc.nextLine();
                        List<student> result = service.searchByName(keyword);
                        if (result.isEmpty()) {
                            System.out.println("No matching students.");
                        } else {
                            result.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        service.displayAll();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
    }
}
