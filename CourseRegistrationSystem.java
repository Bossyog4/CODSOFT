import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    int id;
    String name;
    List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.capacity > 0) {
            registeredCourses.add(course);
            course.capacity--;
            System.out.println("You have successfully registered for the course: " + course.title);
        } else {
            System.out.println("Sorry, the course is full. Registration failed.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.capacity++;
            System.out.println("You have successfully dropped the course: " + course.title);
        } else {
            System.out.println("You are not registered for this course.");
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CSE101", "Introduction to Computer Science", "An introductory course to computer science concepts", 30, "Monday, Wednesday, Friday 10:00 AM - 11:00 AM"));
        courses.add(new Course("ENG201", "English Literature", "Study of classic literature and writing techniques", 25, "Tuesday, Thursday 1:00 PM - 2:30 PM"));
        courses.add(new Course("MATH301", "Calculus I", "Fundamental concepts of calculus", 35, "Monday, Wednesday 2:00 PM - 3:30 PM"));

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(3, "Charlie"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Course Registration System =====");
            System.out.println("1. Course Listing");
            System.out.println("2. Student Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCourseListing(courses);
                    break;
                case 2:
                    studentRegistration(students, courses);
                    break;
                case 3:
                    courseRemoval(students, courses);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }

    public static void displayCourseListing(List<Course> courses) {
        System.out.println("\n===== Course Listing =====");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.code);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Capacity: " + course.capacity + " / " + course.capacity);
            System.out.println("Schedule: " + course.schedule);
            System.out.println();
        }
    }

    public static void studentRegistration(List<Student> students, List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Student Registration =====");
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter course code to register: ");
        String courseCode = scanner.next();

        Student student = findStudentById(students, studentId);
        Course course = findCourseByCode(courses, courseCode);

        if (student != null && course != null) {
            student.registerCourse(course);
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public static void courseRemoval(List<Student> students, List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Course Removal =====");
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter course code to drop: ");
        String courseCode = scanner.next();

        Student student = findStudentById(students, studentId);
        Course course = findCourseByCode(courses, courseCode);

        if (student != null && course != null) {
            student.dropCourse(course);
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public static Student findStudentById(List<Student> students, int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    public static Course findCourseByCode(List<Course> courses, String code) {
        for (Course course : courses) {
            if (course.code.equals(code)) {
                return course;
            }
        }
        return null;
    }
}
