import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class JavaFileMerger {

    public static void main(String[] args) {
        // Prompt user for folder path
        System.out.print("Enter the path of the folder: ");
        String folderPath = new Scanner(System.in).nextLine();

        // Call the method to open .java files
        openJavaFiles(new File(folderPath));
    }

    private static void openJavaFiles(File folder) {
        if (folder.exists() && folder.isDirectory()) {
            // List all files in the folder
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // If it's a directory, recursively call the method
                        openJavaFiles(file);
                    } else if (file.isFile() && file.getName().endsWith(".java")) {
                        // If it's a .java file, print the path (you can open it here)
                        System.out.println("Opening: " + file.getAbsolutePath());

                        writeJavaFile(file.getPath());
                    }
                }
            }
            System.out.println("Your java files added to \"temp.java\" file in this folder");
        } else {
            System.out.println("Invalid folder path. Please provide a valid folder path.");
        }
    }

    private static void writeJavaFile(String filePath) {

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileOutputStream fileOutputStream = new FileOutputStream("temp.java", true);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {

            // Read the input Java file line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                // Split the line into words
                String[] words = line.split("\\s+");

                // Check if the line does not start with "import", "public", or "package"
                if (!Objects.equals(words[0], "import") && !Objects.equals(words[0], "public")
                        && !Objects.equals(words[0], "package")) {

                    // Write the line as it is to the output file
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();

                }
                // Check if the line starts with "public"
                else if (Objects.equals(words[0], "public")) {

                    // Write the line starting from the first word (excluding "public")
                    for (int i = 1; i < words.length; i++) {
                        bufferedWriter.write(words[i] + " ");
                    }
                    bufferedWriter.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
