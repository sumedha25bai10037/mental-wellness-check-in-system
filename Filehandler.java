import java.io.*;

public class FileHandler {

    private static final String FILE_NAME = "mood_data.txt";

    public static void saveEntry(MoodEntry entry) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(entry.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public static void loadEntries(WellnessTracker tracker) {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                MoodEntry entry = MoodEntry.fromFileString(line);
                tracker.addEntry(entry);
            }

        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
    }
}
