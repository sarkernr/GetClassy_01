import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        boolean doneInput = false;
        String id, firstName, lastName, title, record;
        int yearOfBirth;
        ArrayList<String> persons = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Person Generator!");

        // Collect person data
        do {
            id = SafeInput.getNonZeroLenString(in, "Enter the person's ID (e.g., 000001)");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the person's first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the person's last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the person's title (e.g., Mr., Mrs., Dr., etc.)");
            yearOfBirth = SafeInput.getRangedInt(in, "Enter the person's year of birth", 1000, 9999);

            // Format the record
            record = String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth);
            persons.add(record);

            System.out.println("Person added: " + record);

            // Check if user wants to add more persons
            doneInput = SafeInput.getYNConfirm(in, "Are you finished?");
        } while (!doneInput);

        // File saving
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the desired file name (without extension)") + ".txt";
        Path file = Paths.get(System.getProperty("user.dir") + "\\" + fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            for (String person : persons) {
                writer.write(person);
                writer.newLine();
            }
            System.out.println("Data file written successfully to: " + file.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}