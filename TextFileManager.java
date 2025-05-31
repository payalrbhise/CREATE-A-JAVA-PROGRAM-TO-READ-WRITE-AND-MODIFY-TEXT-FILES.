import java.io.*;
import java.util.*;

public class TextFileManager {

    // Method to write data to a text file
    public static void createFile(String filePath, String data) {
        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(data);
            System.out.println("✔️ File has been created and written to successfully.");
        } catch (IOException e) {
            System.out.println("❗ Failed to write to file: " + e.getMessage());
        }
    }

    // Method to read and display contents of a text file
    public static void displayFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            System.out.println("📄 File Contents:");
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            System.out.println("❗ Failed to read file: " + e.getMessage());
        }
    }

    // Method to update text in a file (word replacement)
    public static void updateFile(String filePath, String target, String replacement) {
        File file = new File(filePath);
        StringBuilder updatedContent = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String modifiedLine = scanner.nextLine().replace(target, replacement);
                updatedContent.append(modifiedLine).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("❗ Error reading file for updating: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(updatedContent.toString());
            System.out.println("🔁 File has been updated (\"" + target + "\" changed to \"" + replacement + "\").");
        } catch (IOException e) {
            System.out.println("❗ Error writing updated data: " + e.getMessage());
        }
    }

    // Main method to demonstrate file operations
    public static void main(String[] args) {
        String filePath = "myTextFile.txt";
        String originalText = "Welcome to Java file handling.\nLet's practice file writing, reading, and updating.";

        // 1. Create and write
        createFile(filePath, originalText);

        // 2. Read and display
        displayFile(filePath);

        // 3. Modify content
        updateFile(filePath, "file", "document");

        // 4. Display updated content
        displayFile(filePath);
    }
}
