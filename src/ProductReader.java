import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<String> lines = new ArrayList<>();

        System.out.println("Welcome to the Product Reader!");

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
                System.out.printf("%-10s %-20s %-30s %10s%n", "ID", "Product Name", "Description", "Cost");
                System.out.println("===============================================================");

                // Process and print each line
                for (String record : lines) {
                    String[] fields = record.split(",\\s*");
                    if (fields.length == 4) {
                        String id = fields[0].trim();
                        String name = fields[1].trim();
                        String description = fields[2].trim();
                        double cost = Double.parseDouble(fields[3].trim());

                        System.out.printf("%-10s %-20s %-30s %10.2f%n", id, name, description, cost);
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
