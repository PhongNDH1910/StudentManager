package model;

public class Student {
    private int id;
    private String fullName;
    private double gpa;

    public Student(int id, String fullName, double gpa) {
        this.id = id;
        this.setFullName(fullName);
        this.setGpa(gpa);
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.length() > 50) {
            throw new IllegalArgumentException("Full name must be <= 50 characters.");
        }
        this.fullName = fullName;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-30s %.2f", id, fullName, gpa);
    }
}
