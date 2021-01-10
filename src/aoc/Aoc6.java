package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Aoc6 {
	public static void main(String[] args) {
		String file = "inputFiles/aocquestions.txt";
		//String file = "aocquestionstest.txt";
		int x = sumOfAnswers(file);
		System.out.println("answer for task 1: " + x);
		
		int y = sumForTaskTwo(file);
		System.out.println("answer for task 2: " + y);
	}
	
	
	public static int sumOfAnswers(String file) {
		int answer = 0;
		String line;
		StringBuffer group = new StringBuffer();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while((line = br.readLine()) != null) {
				if (line.length() > 0) {
					group.append(line);					
				} else {
					answer += group.chars().distinct().count();
					group.delete(0, group.length());
				}	
			}
			answer += group.chars().distinct().count();
			group.delete(0, group.length());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return answer;
	}
	
	
	public static int sumForTaskTwo(String file) {
		int answer = 0;
		String line;
		List<HashSet<String>> group = new ArrayList<HashSet<String>>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while((line = br.readLine()) != null) {
				if (line.length() > 0) {
					HashSet<String> onePerson = new HashSet<String> (Arrays.asList(line.split("")));
					group.add(onePerson);				
				} else {
					int i = 1;
					Set<String> result = new HashSet<>(group.get(0));
					while (i < group.size()) {
						result.retainAll(group.get(i));
						i++;
					}
					answer += result.size();
					group.clear();
				}	
			}
			int i = 1;
			Set<String> result = new HashSet<>(group.get(0));
			while (i < group.size()) {
				result.retainAll(group.get(i));
				i++;
			}
			answer += result.size();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return answer;
	}
}
