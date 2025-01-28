import java.util.Scanner;

public class SafeInputObj {

    private Scanner pipe; // Instance variable for Scanner

    // Default constructor: Initializes `pipe` with `System.in`
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    // Constructor with a Scanner parameter
    public SafeInputObj(Scanner pipe) {
        this.pipe = pipe;
    }

    // Method: Get a non-empty string
    public String getNonZeroLenString(String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
            if (retString.length() == 0) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (retString.length() == 0);
        return retString;
    }

    // Method: Get an integer in a specific range
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // Clear buffer
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range [" + low + "-" + high + "]. Please try again.");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid integer. Invalid input: " + trash);
            }
        } while (!done);

        return retVal;
    }

    // Method: Get an integer
    public int getInt(String prompt) {
        int retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // Clear buffer
                done = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid integer. Invalid input: " + trash);
            }
        } while (!done);

        return retVal;
    }

    // Method: Get a double in a specific range
    public double getRangedDouble(String prompt, int low, int high) {
        double retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // Clear buffer
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range [" + low + "-" + high + "]. Please try again.");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid double. Invalid input: " + trash);
            }
        } while (!done);

        return retVal;
    }

    // Method: Get a double
    public double getDouble(String prompt) {
        double retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // Clear buffer
                done = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("You must enter a valid double. Invalid input: " + trash);
            }
        } while (!done);

        return retVal;
    }

    // Method: Get a [Y/N] confirmation
    public boolean getYNConfirm(String prompt) {
        boolean retVal = true;
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y")) {
                retVal = true;
                gotAVal = true;
            } else if (response.equals("N")) {
                retVal = false;
                gotAVal = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!gotAVal);

        return retVal;
    }

    // Method: Get a string matching a regular expression
    public String getRegExString(String prompt, String regExPattern) {
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regExPattern)) {
                gotAVal = true;
            } else {
                System.out.println("Input does not match the required pattern: " + regExPattern);
            }
        } while (!gotAVal);

        return response;
    }
}
