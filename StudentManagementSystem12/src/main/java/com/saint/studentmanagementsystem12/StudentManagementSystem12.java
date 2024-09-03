/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.saint.studentmanagementsystem12;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Submitted by : Md Saihan Alam.
 * Roll: 12, D-79.
 */

abstract class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public abstract void printDetails();
}


class Student extends Person {
    private List<String> courses;
    private List<String> grades;

    public Student(String name, int id) {
        super(name, id);
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses); 
    }

    public List<String> getGrades() {
        return new ArrayList<>(grades); // encapsulation
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void addGrade(String grade) {
        grades.add(grade);
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Courses: " + courses);
        System.out.println("Grades: " + grades);
    }
}

// Interface 
interface ManagementSystem {
    void addStudent(Student student);
    Student searchStudent(int id);
    void printResultCard(int id);
}


class StudentManagementSystem implements ManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    @Override
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void printResultCard(int id) {
        Student student = searchStudent(id);
        if (student != null) {
            student.printDetails();
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }
}

public class StudentManagementSystem12 {
    public static void main(String[] args) {
        ManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add student");
            System.out.println("2. Search student");
            System.out.println("3. Print result card");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Student student = new Student(name, id);

                    while (true) {
                        System.out.print("Enter course name (or 'done' to finish): ");
                        String course = scanner.nextLine();
                        if (course.equalsIgnoreCase("done")) {
                            break;
                        }
                        student.addCourse(course);

                        System.out.print("Enter grade for " + course + ": ");
                        String grade = scanner.nextLine();
                        student.addGrade(grade);
                    }

                    sms.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    Student foundStudent = sms.searchStudent(id);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent.getName());
                    } else {
                        System.out.println("No student found with ID: " + id);
                    }
                    break;
                case 3:
                    System.out.print("Enter id: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); 
                    sms.printResultCard(id);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close(); 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
                    break;
            }
        }
    }
}

