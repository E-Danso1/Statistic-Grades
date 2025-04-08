 import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int N = scanner.nextInt();

        int[] scores = new int[N];

        System.out.println("Enter the grades of the students:");
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }


        int max = scores[0];
        int min = scores[0];
        double sum = 0;

        for (int score : scores) {
            if (score > max) max = score;
            if (score < min) min = score;
            sum += score;
        }
        double average = sum / N;

        System.out.println("\nTask 1 Results:");
        System.out.println("Maximum grade: " + max);
        System.out.println("Minimum grade: " + min);
        System.out.printf("Average grade: %.2f\n", average);


        int[] stats = new int[5];

        for (int score : scores) {
            if (score >= 81) {
                stats[4]++;
            } else if (score >= 61) {
                stats[3]++;
            } else if (score >= 41) {
                stats[2]++;
            } else if (score >= 21) {
                stats[1]++;
            } else {
                stats[0]++;
            }
        }

        System.out.println("\nTask 2 Results:");
        System.out.println("Grade Distribution Bar Chart:");


        int maxCount = 0;
        for (int count : stats) {
            if (count > maxCount) maxCount = count;
        }


        for (int y = maxCount; y >= 0; y--) {
            System.out.printf("%2d |", y);


            for (int count : stats) {
                if (count >= y) {
                    System.out.print("  ***");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }

        
        System.out.println("   +----------------------------------------→");
        System.out.println("     0-20  21-40  41-60  61-80 81-100 (Grade Ranges)");

        scanner.close();
    }
}

