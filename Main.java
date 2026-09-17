import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        WellnessTracker tracker = new WellnessTracker();

        // Load previous data
        FileHandler.loadEntries(tracker);

        while (true) {
            System.out.println("\n===== Mental Wellness Check-In =====");
            System.out.println("1. Add Mood Entry");
            System.out.println("2. View Mood History");
            System.out.println("3. Average Mood");
            System.out.println("4. Mood Trend");
            System.out.println("5. Get Suggestion");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    System.out.print("Enter mood (Happy/Sad/Neutral): ");
                    String mood = sc.nextLine();

                    System.out.print("Rate your mood (1-5): ");
                    int rating = sc.nextInt();

                    MoodEntry entry = new MoodEntry(date, mood, rating);
                    tracker.addEntry(entry);
                    FileHandler.saveEntry(entry);
                    break;

                case 2:
                    tracker.showAllEntries();
                    break;

                case 3:
                    tracker.showAverageMood();
                    break;

                case 4:
                    tracker.showTrend();
                    break;

                case 5:
                    tracker.giveSuggestion();
                    break;

                case 6:
                    System.out.println("Take care! 👋");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
