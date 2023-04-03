package interviewAsked;// Java program for the above approach

import java.util.*;

class StringRotatedCheck_EmiratesGroup {

	static boolean checkString(String s1, String s2,
							   int indexFound, int Size) {
		for (int i = 0; i < Size; i++) {
			if (s1.charAt(i)
					!= s2.charAt((indexFound + i) % Size))
				return false;
		}

		return true;
	}

	// Driver code
	public static void main(String args[]) {
		String s1 = "abacd";
		String s2 = "cdaba";

		if (s1.length() != s2.length()) {
			System.out.println(
					"s2 is not a rotation on s1");
		} else {

			ArrayList<Integer> indexes = new ArrayList<
					Integer>(); // store occurrences of the
			// first character of s1

			int Size = s1.length();

			char firstChar = s1.charAt(0);

			for (int i = 0; i < Size; i++) {
				if (s2.charAt(i) == firstChar) {
					indexes.add(i);
				}
			}

			boolean isRotation = false;

			// check if the strings are rotation of each
			// other for every occurrence of firstChar in s2
			for (int idx : indexes) {
				isRotation = checkString(s1, s2, idx, Size);

				if (isRotation)
					break;
			}

			if (isRotation)
				System.out.println(
						"Strings are rotations of each other");
			else
				System.out.println(
						"Strings are not rotations of each other");
		}
	}
}