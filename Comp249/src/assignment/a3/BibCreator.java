// -----------------------------------------------------
// Assignment 3
// Question:
// Written by: Jingchao Zhang, 40049474
// -----------------------------------------------------

/**
 * Name(s) and ID(s): Jingchao Zhang 40049474 <br>
 * COMP249 <br>
 * Assignment # 3 <br>
 * Due Date: Mar 16, 2018 <br>
 * Purpose: Read from 10 files with some article information, check their validity, and output proper files containing reference
 * information in 3 different format, IEEE, ACM, NJ.  
 */

package assignment.a3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BibCreator {

	public static void main(String[] args) {
		
		
		System.out.println("Welcome to BibCreator!\n");
		Scanner[] fileIn = new Scanner[10];
		PrintWriter[][] fileOut = new PrintWriter[10][3];
		File[][] outputFiles = new File[10][3];
		Article[][] articles = new Article[10][100];
		openInputFiles(fileIn);
		openOutputFiles(fileIn, fileOut, outputFiles);
		processFilesForValidation(fileIn, fileOut, outputFiles, articles);
		inquiry(0);
	}

	/**
	 * Open 10 Input Files
	 * @param fileIn the scanner array prepared for reading later.
	 */
	public static void openInputFiles(Scanner[] fileIn) {
		File[] inputFiles = new File[10];
		int i = 0;
		try {
			for (i = 0; i < 10; i++) {
				inputFiles[i] = new File("Comp249_W18_Assg3_Files/Latex" + (i + 1) + ".bib");
				fileIn[i] = new Scanner(new FileInputStream(inputFiles[i]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not open input file Latex" + (i + 1) + ".bib for reading. "
					+ "\n\nPlease check if file exists! Program will terminate after closing any opened files.");
			for (int j = 0; j < i; j++)
				fileIn[j].close();
			System.exit(0);
		}
	}

	/**
	 * Create 3 output files for each input file if it is possible
	 * @param fileIn input files for reading
	 * @param fileOut output files for writing
	 * @param outputFiles the File objects of output files
	 */
	public static void openOutputFiles(Scanner[] fileIn, PrintWriter[][] fileOut, File[][] outputFiles) {
		String[] bibFormat = {"IEEE", "ACM", "NJ"};
		int i = 0, j = 0;
		try {
			for (i = 0; i < 10; i++)
				for (j = 0; j < 3; j++) {
					outputFiles[i][j] = new File("Assignment3_output_files/" + bibFormat[j] + (i + 1) + ".json");
					fileOut[i][j] = new PrintWriter(new FileOutputStream(outputFiles[i][j]));
				}
		} catch (FileNotFoundException e) {
			System.out.println("Could not create output file " + bibFormat[j] + (i + 1) + ".json for writing. "
					+ "\n\nPlease check if file name is already used for a directory (folder) name or other reason. "
					+ "\nProgram will terminate after closing any opened files.");
			deleteOutputFiles(outputFiles, fileOut);
			// Close input files
			for (int k = 0; k < 10; k++)
				fileIn[k].close();
			System.exit(0);
		}
	}

	/**
	 * If any of the output file cannot be created, use this method to delete all the files have been created
	 * @param outputFiles the File objects of output files
	 * @param fileOut output files
	 */
	public static void deleteOutputFiles(File[][] outputFiles, PrintWriter[][] fileOut) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 3; j++)
				if (fileOut[i][j] != null) {
					fileOut[i][j].close();
					outputFiles[i][j].delete();
				}
	}

	/**
	 * process valid files in two steps. 1. store the date in the input files to some objects of type article. 2. write the date to output files
	 * @param fileIn input files (Scanner)
	 * @param fileOut output files (PrintWriter)
	 * @param outputFiles output files (File)
	 * @param articles the objects use for saving all the information
	 */
	public static void processFilesForValidation(Scanner[] fileIn, PrintWriter[][] fileOut, File[][] outputFiles, Article[][] articles) {
		saveAsArticles(fileIn, fileOut, outputFiles, articles);
		writeToFiles(fileOut, articles);
	}

	/**
	 * Read all the input files line by line, then store the information as article objects
	 * @param fileIn input files (Scanner)
	 * @param fileOut output files (PrintWriter)
	 * @param outputFiles output files (File)
	 * @param articles the objects use for saving all the information
	 */
	public static void saveAsArticles(Scanner[] fileIn, PrintWriter[][] fileOut, File[][] outputFiles, Article[][] articles) {
		int invalidCounter = 0;
		for (int i = 0; i < 10; i++) {
			int articleCounter = 0;
			try {
				String line = null;
				while (fileIn[i].hasNextLine()) {
					line = fileIn[i].nextLine();
					if (line.contains("@ARTICLE{")) {
						articles[i][articleCounter] = new Article();
						while (!line.startsWith("}")) {
							line = fileIn[i].nextLine();
							if (line.contains("{") && line.contains("}"))
								setAttributes(i, line, articles[i][articleCounter]);
						}
						articleCounter++;
					}
				}
			} catch (FileInvalidException e) {
				System.out.println(e.getMessage());
				invalidCounter++;
				for (int j = 0; j < 3; j++) {
					fileOut[i][j].close();
					outputFiles[i][j].delete();
					for (int k = 0; k < articleCounter + 1; k++)
						articles[i][k] = null;
				}
			} // catch ends
		} // for loop ends
		System.out.println("A total of " + invalidCounter + " files were invalid, and could not be processed. "
				+ "All other " + (10 - invalidCounter) + " \"Valid\" files have been created.\n");
	}

	/**
	 * Use the article objects generate proper format of each article, and write to output files
	 * @param fileOut output files (PrintWriter) for writing
	 * @param articles article objects for writing
	 */
	public static void writeToFiles(PrintWriter[][] fileOut, Article[][] articles) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++)
				if (articles[i][j] != null) {
					fileOut[i][0].println("[" + (j + 1) + "] " + articles[i][j].generateIEEE() + "\n");
					fileOut[i][1].println("[" + (j + 1) + "] " + articles[i][j].generateACM() + "\n");
					fileOut[i][2].println("[" + (j + 1) + "] " + articles[i][j].generateNJ() + "\n");
				} else
					break;
			for (int j = 0; j < 3; j++)
				fileOut[i][j].close();
		}
	}

	/**
	 * When a FileInvalidException is thrown, display this message
	 * @param i the index number of the file that is processing
	 * @param firstInvalidField the field that is checked as invalid
	 * @return the message 
	 */
	public static String fileInvalidMessage(int i, String firstInvalidField) {
		return "Error: Detected Empty Field!\n============================\n\n"
				+ "Problem detected with input file: Latex" + (i + 1) + ".bib\n" + "File is Invalid: Field \""
				+ firstInvalidField + "\" is Empty. Processing stopped at this point. "
				+ "Other empty fields may be present as well!\n";
	}

	/**
	 * analyze a specific line from the input file, match the line to proper attribute of the article object and set the attribute
	 * @param i the index of the input file, used for tracking which file threw an exception
	 * @param line the line of String for analyzing
	 * @param article the article object for storing the data of this line
	 * @throws FileInvalidException if the content in this line is empty, throw this exception
	 */
	public static void setAttributes(int i, String line, Article article) throws FileInvalidException {
		
		String content = line.substring(line.indexOf("{") + 1, line.lastIndexOf("}"));
		String firstInvalidField = null;
		if (line.contains("{}")) {
			firstInvalidField = line.substring(0, line.indexOf('='));
			throw new FileInvalidException(fileInvalidMessage(i, firstInvalidField));
		} else if (line.startsWith("author="))
			article.setAuthors(content);
		else if (line.startsWith("journal="))
			article.setJournal(content);
		else if (line.startsWith("title="))
			article.setTitle(content);
		else if (line.startsWith("year="))
			article.setYear(Integer.parseInt(content));
		else if (line.startsWith("volume="))
			article.setVolume(content);
		else if (line.startsWith("number="))
			article.setNumber(Integer.parseInt(content));
		else if (line.startsWith("pages="))
			article.setPages(content);
		else if (line.startsWith("keywords="))
			article.setKeywords(content);
		else if (line.startsWith("doi="))
			article.setDoi(content);
		else if (line.startsWith("ISSN="))
			article.setISSN(content);
		else if (line.startsWith("month="))
			article.setMonth(content);
		else if (Character.isDigit(line.charAt(0)))
			article.setSerialNumber(Integer.parseInt(line.substring(0, line.length() - 1)));
	}

	/**
	 * give the user two chance to input a filename to display
	 * @param inquiryCounter current times of inquiry, default should be 0.
	 */
	public static void inquiry(int inquiryCounter) {
		try {
			openFileAndDisplay();
		} catch (FileNotFoundException e) {
			inquiryCounter++;
			if (inquiryCounter < 2) {
				System.out.print("Could not open input file. File does not exit; possibly it could not be created!\n\n"
						+ "However, you will be allowed another chance to enter another file name.\n");
				inquiry(inquiryCounter);
			} else {
				System.out.println(
						"\nCould not open input file again! Either file does not exist or could not be created.\n"
								+ "Sorry! I am unable to display your desired files! Program will exit!");
				System.exit(0);
			}
		} catch (IOException e) {
			System.out.println("Error reading.");
			System.exit(0);
		}
	}

	/**
	 * used for inquiry, open File And Display if no exception is thrown
	 * @throws FileNotFoundException the name that the user input may does not exits
	 * @throws IOException there may be exception when reading the file with BufferedReader
	 */
	public static void openFileAndDisplay() throws FileNotFoundException, IOException {
		System.out.print("Please enter the name of one of the files that you need to review:");
		Scanner keyIn = new Scanner(System.in);
		String fileName = keyIn.next();
		BufferedReader br = new BufferedReader(new FileReader("Assignment3_output_files/" + fileName));
		System.out.println("Here are the contents of the successfully created Jason File:" + fileName + "\n");
		String line = br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		keyIn.close();
		br.close();
	}
}
