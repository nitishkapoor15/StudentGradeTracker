package org.Online_Job_Portal.StudentGrade;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Show Summary (Average, Highest, Lowest)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    students.add(new Student(name, marks));
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students added yet.");
                    } else {
                        System.out.println("\n--- Student Details ---");
                        for (Student s : students) {
                            System.out.println("Name: " + s.name + ", Marks: " + s.marks);
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students available to calculate.");
                    } else {
                        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
                        for (Student s : students) {
                            total += s.marks;
                            if (s.marks > highest) highest = s.marks;
                            if (s.marks < lowest) lowest = s.marks;
                        }
                        double average = (double) total / students.size();
                        System.out.println("\n--- Summary Report ---");
                        System.out.println("Total Students: " + students.size());
                        System.out.println("Average Marks: " + average);
                        System.out.println("Highest Marks: " + highest);
                        System.out.println("Lowest Marks: " + lowest);
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
