import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class PersonReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<String> lines = new ArrayList<>();

        System.out.println("Welcome to the Person Reader!");

        // Set up file chooser
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }

                System.out.println("\nData file read successfully!");

                // Print table header
                System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==============================================================");

                // Process and print each line
                for (String record : lines) {
                    String[] fields = record.split(",\\s*");
                    if (fields.length == 5) {
                        String id = fields[0].trim();
                        String firstName = fields[1].trim();
                        String lastName = fields[2].trim();
                        String title = fields[3].trim();
                        int yearOfBirth = Integer.parseInt(fields[4].trim());

                        System.out.printf("%-10s %-15s %-15s %-10s %5d%n", id, firstName, lastName, title, yearOfBirth);
                    } else {
                        System.out.println("Malformed record: " + record);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}