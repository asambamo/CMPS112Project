
import java.util.Scanner;

public class cmps112 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number");
		String s = scan.next();
		long x = Long.parseLong(s);
		String numtoWord = sayNum(x);
		System.out.println(numtoWord);
		scan.close();
	}

	// 1-19
	private static final String[] setOne = { "zero", "one", "two", "three",
			"four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };

	// 20-90
	private static final String[] setTwo = { "twenty", "thirty", "forty",
			"fifty", "sixty", "seventy", "eighty", "ninety" };

	// thousand to vigintillion
	private static final String[] setLarge = { "thousand", "million",
			"billion", "trillion", "quadrillion", "quintillion", "sextillion",
			"septillion", "octillion", "nonillion", "decillion", "undecillion",
			"duodecillion", "tredecillion", "quattuordecillion",
			"quindecillion", "sexdecillion", "septendecillion",
			"octodecillion", "novemdecillion", "vigintillion" };

	public static String sayNum(long x) {
		if (x < 0) {
			return "minus " + sayNum(-x);
		}
		if (x <= 999) {
			return convertTo999(x);
		}
		int t = 0;
		String s1 = null;
		while (x > 0) {
			if (x % 1000 != 0) {
				String s2 = convertTo999(x % 1000);
				if (t > 0) {
					s2 = s2 + " " + setLarge[t - 1];
				}
				if (s1 == null) {
					s1 = s2;
				} else {
					s1 = s2 + ", " + s1;
				}
			}
			x /= 1000;
			t++;
		}
		return s1;
	}

	// 0 to 999.
	private static String convertTo999(long x) {
		String s1 = setOne[(int) (x / 100)] + " hundred";
		String s2 = convertTo99(x % 100);
		if (x <= 99) {
			return s2;
		} else if (x % 100 == 0) {
			return s1;
		} else {
			return s1 + " " + s2;
		}
	}

	// 0 to 99.
	private static String convertTo99(long x) {
		if (x < 20) {
			return setOne[(int) x];
		}
		String s = setTwo[(int) (x / 10 - 2)];
		if (x % 10 == 0) {
			return s;
		}
		return s + "-" + setOne[(int) (x % 10)];
	}
}
