public class MoodEntry {
    String date;
    String mood;
    int rating; // 1 to 5

    public MoodEntry(String date, String mood, int rating) {
        this.date = date;
        this.mood = mood;
        this.rating = rating;
    }

    public String toFileString() {
        return date + "," + mood + "," + rating;
    }

    public static MoodEntry fromFileString(String line) {
        String[] parts = line.split(",");
        return new MoodEntry(parts[0], parts[1], Integer.parseInt(parts[2]));
    }
}
