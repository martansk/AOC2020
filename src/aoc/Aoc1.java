package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Aoc1 {
	public static int FindAnswer(String file) throws IOException {
		int answer = -1;
		int a, b;
	
		// Input is stored into list
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int toList;
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			while((line = br.readLine()) != null) {
				toList = Integer.parseInt(line);
				list.add(toList);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			br.close();
		}
		
		for (int i = 0; i < list.size(); i++) {
			a = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				b = list.get(j);
				if (a+b == 2020) {
					answer = a*b;
					return answer;
				}
			}
		}
		
		
		return answer;
	}
	
	public static int FindAnswerSecondTask(String file) throws IOException {
		int answer = -1;
		int a, b, c;
	
		// Input is stored into list
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int toList;
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			while((line = br.readLine()) != null) {
				toList = Integer.parseInt(line);
				list.add(toList);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			br.close();
		}
		
		for (int i = 0; i < list.size(); i++) {
			a = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				b = list.get(j);
				for(int k = 0; k < list.size(); k++) {
					c = list.get(k);
					if (a+b+c == 2020) {
						answer = a*b*c;
						return answer;
					}
				}
			}
		}
		
		
		return answer;
	}
	
	public static void main(String args[]) throws IOException {
		String file = "inputFiles/aocinput.txt";
		int x = FindAnswer(file);
		System.out.println("Answer for first task: " + x);
		int y = FindAnswerSecondTask(file);
		System.out.println("Answer for second task: " + y);
	}
}
