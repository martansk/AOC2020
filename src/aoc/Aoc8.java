package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Aoc8 {
	public static void main(String[] args) {
		String file = "inputFiles/aocboot.txt";
		//String test = "aocboottest.txt";
		
		int x = findAccVal(file);
		System.out.println(x);
		
		int y = findAccValTask2(file);
		System.out.println("task 2: " + y);
	}
	
	
	public static int findAccVal(String file) {
		int acc = 0;
		String line;
		ArrayList<String> code = new ArrayList<String>();
		ArrayList<Integer> visitedIndexes = new ArrayList<Integer>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				code.add(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int i = 0;
		while (i < code.size()) {
			if (visitedIndexes.contains(i)) return acc;
			else if (code.get(i).contains("acc")) {
				visitedIndexes.add(i);
				String[] codeLine = code.get(i).split("\\s+");
				int value = Integer.parseInt(codeLine[1]);
				acc += value;
				i++;
			}
			else if (code.get(i).contains("nop")) {
				visitedIndexes.add(i);
				i++;
			}
			else if (code.get(i).contains("jmp")) {
				visitedIndexes.add(i);
				String[] codeLineJmp = code.get(i).split("\\s+");
				int jmp = Integer.parseInt(codeLineJmp[1]);
				i += jmp;
			} else {
				System.out.println("Non-valid input");
			}
		}
		
		
		return acc;
	}
	
	public static int findAccValTask2(String file) {
		int acc = 0;
		String line;
		ArrayList<String> code = new ArrayList<String>();
		ArrayList<Integer> visitedIndexes = new ArrayList<Integer>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				code.add(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		int muutettu = 0;
		int total = 0;
		int left = 0;
		int i = 0;
		while (i < code.size()) {
			if(visitedIndexes.contains(i)) {
				visitedIndexes.clear();
				total++;
				left = total;
				muutettu = 0;
				i = 0;
				acc = 0;
				continue;
			}
			if (code.get(i).contains("acc")) {
				visitedIndexes.add(i);
				String[] codeLine = code.get(i).split("\\s+");
				int value = Integer.parseInt(codeLine[1]);
				acc += value;
				i++;
			}
			else if (code.get(i).contains("nop")) {
				if (muutettu == 0 && left == 0) {
					visitedIndexes.add(i);
					String[] codeLineJmp = code.get(i).split("\\s+");
					int jmp = Integer.parseInt(codeLineJmp[1]);
					i += jmp;
					muutettu = 1;
					continue;
				} else if (muutettu == 0){
					left--;
				}
				visitedIndexes.add(i);
				i++;
			}
			else if (code.get(i).contains("jmp")) {
				if (muutettu == 0 && left == 0) {
					visitedIndexes.add(i);
					muutettu = 1;
					i++;
					continue;
				} else if (muutettu == 0) {
					left--;
				}
				visitedIndexes.add(i);
				String[] codeLineJmp = code.get(i).split("\\s+");
				int jmp = Integer.parseInt(codeLineJmp[1]);
				i += jmp;
			} else {
				System.out.println("Non-valid input");
			}
		}
		
		return acc;
	}
}
