package com.unilog.assignment;

import static com.unilog.assignment.LargeFileReader.*;

public class MainDriver {

	public static void main(String[] args) {

		String file_to_be_read = "D:\\Personal\\InterviewPreparation\\UnilogAssignment\\verses.txt";
		String word_to_be_search = "यत्र";
		System.out.print("Word Count in file:" + getCountFromFile(file_to_be_read, word_to_be_search));
	}

}
