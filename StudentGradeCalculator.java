import java.util.Scanner;

public class StudentGradeCalculator {
    private String studentName;
    private double[] scores;
    private int numberOfSubjects;

    public StudentGradeCalculator(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
        this.scores = new double[numberOfSubjects];
    }

    public void inputStudentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student's name: ");
        studentName = scanner.nextLine();

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
        }
    }

    public double calculateAverage() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / numberOfSubjects;
    }

    public char determineGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void displayResults() {
        double average = calculateAverage();
        char grade = determineGrade(average);

        System.out.printf("Student Name: %s%n", studentName);
        System.out.printf("Average Score: %.2f%n", average);
        System.out.printf("Grade: %c%n", grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        StudentGradeCalculator calculator = new StudentGradeCalculator(numberOfSubjects);
        
        calculator.inputStudentDetails();
        calculator.displayResults();

        scanner.close();
    }
}