import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFile {
	public static void main(String[] args) {

		creatingFile();
	}
	public static void creatingFile() {
		String file_name = "ZigZagLogFile.txt";

		try {
			FileWriter FW = new FileWriter(file_name);
			BufferedWriter out = new BufferedWriter(FW);
			System.out.println();
			out.write("Log File");
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			out.write("\nCurrent date and time: " + now.format(formatter));

			out.write("\nI'm writing this in a file!\n");
			out.write("\nI'm writing this in a file!\n");
			out.write("\nI'm writing this in a file!\n");
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.println(Zigzag.UI.RED+"ERROR: Unable to write journey details to the text file. Please check file permissions\n"+Zigzag.UI.RESET);
			e.printStackTrace();
		}
		File file = new File(file_name);
		System.out.println("Path: "+file.getAbsolutePath());
		//System.exit(1);


	}

}