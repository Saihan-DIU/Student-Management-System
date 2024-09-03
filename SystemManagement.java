/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.saint.systemmanagement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

class Student extends Person {
    private List<String> courses;
    private List<Integer> grades;

    public Student(String name, int id) {
        super(name, id);
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public List<String> getCourses() {
        return courses;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void printResultCard(int id) {
        Student student = searchStudent(id);
        if (student != null) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Courses: " + student.getCourses());
            System.out.println("Grades: " + student.getGrades());
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }
}


public class SystemManagement {

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
             System.out.println("--------------------------------------------\n");
            System.out.println("    1. Add student ");
            System.out.println("    2. Search student");
            System.out.println("    3. Print result card");
            System.out.println("    4. Exit\n");
            System.out.print("   -> Enter your choice : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("  Enter name: ");
                    String name = scanner.next();
                    System.out.print("  Enter id: ");
                    int id = scanner.nextInt();
                    Student student = new Student(name, id);
                    sms.addStudent(student);
                    break;
                case 2:
                    System.out.print("  Enter id: ");
                    id = scanner.nextInt();
                    student = sms.searchStudent(id);
                    if (student != null) {
                        System.out.println("    Student found: " + student.getName());
                    } else {
                        System.out.println("    No student found with ID: " + id);
                    }
                    break;
                case 3:
                    System.out.print("  Enter id: ");
                    id = scanner.nextInt();
                    sms.printResultCard(id);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
   

