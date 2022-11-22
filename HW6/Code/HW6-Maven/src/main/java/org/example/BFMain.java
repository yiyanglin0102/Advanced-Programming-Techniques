package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Pattern;

public class BFMain {

	public static void main(String[] args) throws IOException {

		FileReader inputFile = new FileReader("/Users/yiyanglin/IdeaProjects/HW6/src/main/java/org/example/sample.xml");
		BufferedReader reader1 = new BufferedReader(inputFile);
		String line = reader1.readLine();
		Date date = new Date();

		// getting the object of the Timestamp class
		Timestamp ts = new Timestamp(date.getTime());

		// printing the timestamp of the current date
		System.out.println(ts);
		int count = 0;
		while (line != null) {

			line = line.replaceAll("\\<.*?\\>", "");

			if (Pattern.compile(Pattern.quote("Conversational Agent"), Pattern.CASE_INSENSITIVE).matcher(line).find()) {
				System.out.println(count);
			}
			count += 1;
			line = reader1.readLine();
		}
		reader1.close();
		Date date1 = new Date();

		// getting the object of the Timestamp class
		Timestamp ts1 = new Timestamp(date1.getTime());

		// printing the timestamp of the current date
		System.out.println(ts1);
	}

}
