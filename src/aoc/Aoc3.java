package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Aoc3 {
	public static void main(String[] args) throws IOException {
		String file = "inputFiles/aocslope.txt";
		Double trees = findTrees(file, 3, 1);
		System.out.println("trees, 3, 1 = " + trees);
		
		Double t2 = findTrees(file, 1, 1);
		System.out.println("t2 = " + t2);
		Double t3 = findTrees(file, 5, 1);
		System.out.println("t3 = " + t3);
		Double t4 = findTrees(file, 7, 1);
		System.out.println("t4 = " + t4);
		Double t5 = findTrees(file, 1, 2);
		System.out.println("t5 = " + t5);
		
		double x = trees * t2 * t3 * t4 * t5;
		System.out.println(x);

	}

	
	public static Double findTrees(String file, int right, int left) throws IOException {
		Double answer = (double) 0; // amount of trees
		int x = 0; // position on the x-axis
		ArrayList<String> arr = new ArrayList<String>();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			String line;
			while ((line = br.readLine()) != null) {
				arr.add(line);
			}
		} finally {
			br.close();
		}

		
		// if the position on the x-axis is greater than the row width, then x minus row width is the new position
		int y = 0;
		int lineLength = arr.get(y).length();
		while (y < arr.size()) { // when y is less than the length of the whole table
			
			// if x is greater the row width...			
			if (x >= lineLength) { // e.g. position index 0 < lineLength 1
				x = x - lineLength;
			} else {
				if (arr.get(y).charAt(x) == '#') {
					answer++;
				}
				x = x + right;
				y = y + left;
			}		
		}		
		return answer;
	}	
}
