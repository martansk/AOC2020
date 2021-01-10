package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Aoc5 {
	public static void main(String[] args) {
		String file = "inputFiles/aocboardingpassses.txt";
		int x = findHighestID(file);
		System.out.println(x);
		
		int mySeat = findMySeat(file);
		System.out.println(mySeat);
	}
	
	public static int findHighestID(String file) {
		int answer = -1;
		ArrayList<Integer> listOfSeats = new ArrayList<Integer>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = br.readLine()) != null) {
				int firstRow = 0;
				int lastRow = 127;
				int firstCol = 0;
				int lastCol = 7;
				for (int i = 0; i < line.length(); i++) {
					int rowmidpoint = (firstRow + lastRow) / 2;
					int colmidpoint = (firstCol + lastCol) / 2;
					if (line.charAt(i) == 'F' ) {
						lastRow = rowmidpoint;
					} else if (line.charAt(i) == 'B') {
						firstRow = rowmidpoint + 1;
					} else if (line.charAt(i) == 'L') {
						lastCol = colmidpoint;
					} else if (line.charAt(i) == 'R') {
						firstCol = colmidpoint + 1;
					}
				}
				
				
				if (firstRow == lastRow && firstCol == lastCol) {
					int seatID = (lastRow*8) + lastCol;
					listOfSeats.add(seatID);
					if (seatID > answer) {
						answer = seatID;
					}
				} else {
					System.out.println("Error, firstRow= " + firstRow +
							" lastRow = " + lastRow + " firstCol = " + firstCol +
							" lastCol = " + lastCol);
				}	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return answer;
	}
	
	public static int findMySeat(String file) {
		int answer = -1;	
		String line;
		ArrayList<Integer> listOfSeats = new ArrayList<Integer>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			while((line = br.readLine()) != null) {
				int firstRow = 0;
				int lastRow = 127;
				int firstCol = 0;
				int lastCol = 7;
				for (int i = 0; i < line.length(); i++) {
					int rowmidpoint = (firstRow + lastRow) / 2;
					int colmidpoint = (firstCol + lastCol) / 2;
					if (line.charAt(i) == 'F' ) {
						lastRow = rowmidpoint;
					} else if (line.charAt(i) == 'B') {
						firstRow = rowmidpoint + 1;
					} else if (line.charAt(i) == 'L') {
						lastCol = colmidpoint;
					} else if (line.charAt(i) == 'R') {
						firstCol = colmidpoint + 1;
					}
				}
				
				
				if (firstRow == lastRow && firstCol == lastCol) {
					int seatID = (lastRow*8) + lastCol;
					listOfSeats.add(seatID);
					
				} else {
					System.out.println("Error, firstRow= " + firstRow +
							" lastRow = " + lastRow + " firstCol = " + firstCol +
							" lastCol = " + lastCol);
				}
				
			}
			int highestID = (127 * 8) + 7;
			for (int j = 0; j < highestID; j++) {
				if (listOfSeats.contains(j) != true && listOfSeats.contains(j+1) == true && listOfSeats.contains(j-1) == true) {				
					return j;
				}
			}
		} catch (Exception e) {			
			System.out.println(e.getMessage());
		}
		return answer;
	}
}
