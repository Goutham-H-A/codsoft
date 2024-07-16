import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        int totalMarks = 0;
        int totalSubjects;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        totalSubjects = input.nextInt();

        System.out.println("Enter the marks of each subject (out of 100)");
        int[] subjectMarks = new int[totalSubjects];

        for (int i = 0; i < totalSubjects; i++) {
            System.out.println("Enter the marks:");
            subjectMarks[i] = input.nextInt();

            if (subjectMarks[i] < 0 || subjectMarks[i] > 100) {
                System.out.println("Invalid input. The marks should be between 0 and 100");
                return;
            }
            totalMarks += subjectMarks[i];
        }

        // Calculate total marks and average percentage
        double averagePercentage = (double) totalMarks / totalSubjects;
        char grade = 'N';
        int score = (int) averagePercentage / 10;

        switch (score) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
                break;
        }

        // Display Results
        System.out.println("\n" + "--------- Results ---------");
        System.out.println("Total Obtained Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("--------------------------");
    }
}
