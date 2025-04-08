import java.util.Scanner;

public class Gradestatistic {
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
        System.out.println("Grade Distribution:");

        // Find the maximum count for scaling the bars
        int maxCount = 0;
        for (int count : stats) {
            if (count > maxCount) maxCount = count;
        }

        // Print the bar graph
        for (int i = stats.length - 1; i >= 0; i--) {
            // Scale the bars to be at most 20 # characters for better display
            int barLength = maxCount > 0 ? (int) Math.ceil((double) stats[i] / maxCount * 20) : 0;
            System.out.print("#".repeat(barLength));

            // Print the count and range
            String range;
            if (i == 4) {
                range = "81-100";
            } else if (i == 3) {
                range = "61-80";
            } else if (i == 2) {
                range = "41-60";
            } else if (i == 1) {
                range = "21-40";
            } else {
                range = "0-20";
            }

            System.out.println(" " + stats[i] + " (" + range + ")");
        }

        scanner.close();
    }
}
