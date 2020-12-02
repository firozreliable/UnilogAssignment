package com.unilog.assignment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

/*
 * This class will read the provided files and search the specific word.
 */
public class LargeFileReader {

	private LargeFileReader() {
	}

	private static final Logger LOGGER = Logger.getLogger(LargeFileReader.class.getName());

	public static long getCountFromFile(String input, String word_to_be_search) {
		// Just making sure if input string is in unicode format
		byte[] bytes = word_to_be_search.getBytes(StandardCharsets.UTF_8);
		word_to_be_search = new String(bytes);

		long wordCount = 0;
		try (FileInputStream fis = new FileInputStream(input);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(isr)) {
			String line = "";

			while ((line = reader.readLine()) != null) {

				String[] words = line.split(" ");
				for (String word : words) {
					if (word_to_be_search.equals(word)) {
						wordCount++;
					}
				}

			}
			LOGGER.info("Word Count:" + wordCount);
		} catch (FileNotFoundException e) {
			// We will have logger.error here
			LOGGER.info("Error: " + input + " is not present");
		} catch (IOException e) {
			LOGGER.info("Got Exception:" + e.getMessage());
		}
		return wordCount;
	}

}
