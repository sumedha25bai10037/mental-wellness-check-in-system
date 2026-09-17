import java.util.*;

public class WellnessTracker {

    private ArrayList<MoodEntry> entries;

    public WellnessTracker() {
        entries = new ArrayList<>();
    }

    public void addEntry(MoodEntry entry) {
        entries.add(entry);
        System.out.println("✅ Mood recorded successfully!");
    }

    public void showAllEntries() {
        if (entries.isEmpty()) {
            System.out.println("No mood entries found.");
            return;
        }

        System.out.println("\n--- Mood History ---");
        for (MoodEntry e : entries) {
            System.out.println(e.date + " | " + e.mood + " | Rating: " + e.rating);
        }
    }

    public void showAverageMood() {
        if (entries.isEmpty()) {
            System.out.println("No data to calculate average.");
            return;
        }

        int sum = 0;
        for (MoodEntry e : entries) {
            sum += e.rating;
        }

        double avg = (double) sum / entries.size();
        System.out.println("📊 Average Mood Score: " + avg);
    }

    public void showTrend() {
        if (entries.size() < 2) {
            System.out.println("Not enough data to show trend.");
            return;
        }

        int last = entries.get(entries.size() - 1).rating;
        int prev = entries.get(entries.size() - 2).rating;

        if (last > prev) {
            System.out.println("📈 Your mood is improving!");
        } else if (last < prev) {
            System.out.println("📉 Your mood is declining.");
        } else {
            System.out.println("➡️ Your mood is stable.");
        }
    }

    public void giveSuggestion() {
        if (entries.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        int rating = entries.get(entries.size() - 1).rating;

        System.out.println("\n💡 Suggestion:");
        if (rating <= 2) {
            System.out.println("Take a break, talk to a friend, or listen to music.");
        } else if (rating == 3) {
            System.out.println("Try doing something you enjoy today!");
        } else {
            System.out.println("Keep up the positive energy!");
        }
    }

    public ArrayList<MoodEntry> getEntries() {
        return entries;
    }
}
