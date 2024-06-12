import java.util.Scanner;

public class studentgradecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int TotalSubjects = sc.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= TotalSubjects; i++) {
            System.out.println("Enter marks obtained in subject " + i + ":");
            int marks = sc.nextInt();
            totalMarks += marks;
        }
        double Percentage = (double) totalMarks / TotalSubjects;
        char grade;
        if (Percentage >= 90) 
        {
            grade = 'A';
        }
        else if (Percentage >= 80)
        {
            grade = 'B';
        } 
        else if (Percentage >= 70) 
        {
            grade = 'C';
        } 
        else if (Percentage >= 60) 
        {
            grade = 'D';
        } 
        else if (Percentage >= 50) {
            grade = 'E';
        } 
        else {
            grade = 'F';
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + Percentage + "%");
        System.out.println("Grade: " + grade);
        sc.close();
    }
}
