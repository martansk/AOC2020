package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Aoc4 {
	public static void main(String[] args) {
		String file = "inputFiles/aocpassport.txt";
		int x = passportCount(file);
		System.out.println("answer for second task is: " + x);
	}
	
	public static int passportCount(String file) {
		int answer = 0;
		String line;
		HashMap<String, String> keyValMap = new HashMap<String, String>();
		ArrayList<String> validPp = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
			{
				add("byr");
				add("iyr");
				add("eyr");
				add("hgt");
				add("hcl");
				add("ecl");
				add("pid");
			}
		};
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				if(line.length() > 0) {
					String[] keyValArr = line.split("\s"); // ppArr[0] = key:value etc...
					for (int i = 0; i < keyValArr.length; i++) {
						String[] pair = keyValArr[i].split(":");
						keyValMap.put(pair[0], pair[1]);
					}
				} else {
					if (isPpValid(keyValMap, validPp) == true) {
						if (areValuesValid(keyValMap) == true) {
							answer++;
						}
					}
					keyValMap.clear();
				}
			}
			
			if (isPpValid(keyValMap, validPp)) {
				if (areValuesValid(keyValMap) == true ) {
					answer++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		};
		
		return answer;
	}
	
	public static boolean isPpValid(HashMap<String, String> ppMap, ArrayList<String> validPp) {
		Set<String> ppKeySet = ppMap.keySet();
		
		if (ppKeySet.containsAll(validPp)) {
			return true;
		}
		
		else return false;
	}
	
	public static boolean areValuesValid(HashMap<String, String> passport) {
		for(String i : passport.keySet()) {
			//System.out.println(i);
			switch ( i ) {
			case "byr":
				String byr = passport.get(i);
				int byrVal = Integer.parseInt(byr);
				if(byr.length() != 4 || byrVal < 1920 || byrVal > 2002) return false;
				break;
			case "iyr":
				String iyr = passport.get(i);
				int iyrVal = Integer.parseInt(iyr);
				if(iyr.length() != 4 || iyrVal < 2010 || iyrVal > 2020) return false;
				break;
			case "eyr":
				String eyr = passport.get(i);
				int eyrVal = Integer.parseInt(eyr);
				if(eyr.length() != 4 || eyrVal < 2020 || eyrVal > 2030) return false;
				break;
			case "hgt":
				String hgt = passport.get(i);
				int hgtVal = Integer.parseInt(hgt.replaceAll("\\D", ""));
				if (hgt.contains("cm")) {
					if (hgtVal < 150 || hgtVal > 193) return false;
					else break;
				} else if (hgt.contains("in")) {
					if (hgtVal < 59 || hgtVal > 76) return false;
					else break;
				} else return false;
			case "hcl":
				String hcl = passport.get(i);
				if (hcl.startsWith("#") != true || hcl.length() != 7) return false;
				String[] hclVal = hcl.split("#");
				if(hclVal[1].matches("^([a-f0-9]{6})$") != true) return false;
				break;
			case "ecl":
				String ecl = passport.get(i);
				if ((ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn") || ecl.equals("gry") || ecl.equals("grn") || ecl.equals("hzl") || ecl.equals("oth")) != true) {
					return false;
				}
				break;
			case "pid":
				String pid = passport.get(i);
				if (pid.length() != 9) return false;
				if(pid.replaceAll("\\d", "").length() > 0) return false;
				break;
			default: 
				//System.out.println("error");
			}
		}
		
		return true;
		
	}
}
