package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aoc2 {
	public static void main(String[] args) throws IOException {
		String file = "inputFiles/scndaocinput.txt";
		int x = ValidPasswords(file);
		System.out.println(x);
		
		int y = ValidPasswordsSecondTask(file);
		System.out.println(y);
	}
	
	public static int ValidPasswords(String file) throws IOException {
		int answer = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				if (isValid(line) == true) answer++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		
		return answer;
	}

	public static boolean isValid(String line) {
		String regex = "[-:\s]+";
		String[] a = line.split(regex);
		
		//System.out.println(line);
		String password = a[3];
		char[] cArr = a[2].toCharArray();
		char c = cArr[0];
		// amount of that character
		int amount = 0;
		
		for (int j = 0; j < password.length(); j++) {
			if (password.charAt(j) == c) {
				amount++;
			}
		}
		
		int min = Integer.parseInt(a[0]);
		int max = Integer.parseInt(a[1]);
		
		if (amount >= min && amount <= max) {
			return true;
		} else return false;
	}
	
	public static int ValidPasswordsSecondTask(String file) throws IOException {
		int answer = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				if (isValidSecondTask(line) == true) answer++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		
		return answer;
	}
	
	public static boolean isValidSecondTask(String line) {
		String regex = "[-:\s]+";
		String[] a = line.split(regex);
		
		//System.out.println(line);
		String password = a[3];
		char[] cArr = a[2].toCharArray();
		char c = cArr[0];
		int firstpos = Integer.parseInt(a[0]); // e.g. 3
		int scndpos = Integer.parseInt(a[1]); // e.g. 5
		// indexing starts from 1 (not 0)
		if(password.charAt(firstpos-1) == c ^ password.charAt(scndpos-1) == c) {
			return true;
		} else return false;	
	}
}
