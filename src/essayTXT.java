package day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class essayTXT {

	public static void main(String[] args) {
		String inputFileName = "essay.txt";
		String outputFileName = "report.txt";
		
		int lineCount = 0;
		int wordCount = 0;
		
		try {
			FileWriter fw = new FileWriter(inputFileName); //writer
			fw.write("java is powerful");
			fw.write("java is used for making application");
			fw.write("it helps in eficiency");
			fw.close();
			
			FileReader fr = new FileReader(inputFileName);
			BufferedReader br = new BufferedReader(fr);  //it reads it lne by line
			
			String line ;
			
			while((line = br.readLine()) != null) {
				lineCount++;
				
				String[] words = line.trim().split("\\s+");
						wordCount += words.length;
			}
			br.close();
			fr.close();
			
			  FileWriter reportWriter = new FileWriter(outputFileName);
	            BufferedWriter bw = new BufferedWriter(reportWriter);
	            
	            bw.write("total lines " + lineCount + "\n");
	            bw.write("total word " + wordCount + "\n");
	            
	            bw.close();
	            reportWriter.close();
	            System.out.println("generated " + lineCount + ","+ wordCount);
	            

	            
			
		}catch(IOException e) {
			System.out.println("an error occured");
			e.printStackTrace();
		}

	}

}
