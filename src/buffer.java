package day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class buffer {
	

    public static void main(String[] args) {
        // File names
        String inputFileName = "essay.txt";
        String outputFileName = "report.txt";

        // Variables to hold line and word count
        int lineCount = 0;
        int wordCount = 0;

        try {
            // STEP 1: Create a sample essay.txt file (if not already there)
            FileWriter fw = new FileWriter(inputFileName);
            fw.write("Java is a powerful language.\n");
            fw.write("It is used for web, desktop, and mobile apps.\n");
            fw.write("Learning file handling helps understand data flow.\n");
            fw.close(); // Close after writing sample data

            // STEP 2: Open the file for reading
            FileReader fr = new FileReader(inputFileName);
            BufferedReader br = new BufferedReader(fr); // BufferedReader reads line by line

            String line; // To store each line temporarily

            // STEP 3: Read each line from the file
            while ((line = br.readLine()) != null) {
                lineCount++; // Count each line
                // Split line into words using spaces and count
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }

            // STEP 4: Close the reading streams
            br.close();
            fr.close();

            // STEP 5: Write the report in a new file
            FileWriter reportWriter = new FileWriter(outputFileName);
            BufferedWriter bw = new BufferedWriter(reportWriter);

            bw.write("Total number of lines: " + lineCount + "\n");
            bw.write("Total number of words: " + wordCount + "\n");

            // STEP 6: Close the writing streams
            bw.close();
            reportWriter.close();

            // STEP 7: Print message on console
            System.out.println("Report generated successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
            e.printStackTrace();
        }
    }

	
}
