package DSA.arrays.gen; /******************************************************************************
Welcome to GDB Online.
Code, Compile, Run and Debug online from anywhere in world.
*******************************************************************************/
import java.util.*;

class SplitIntoSubArray {
	public static void main(String[] args) {
		int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};//, 10};
		int splitSize = 4;
		List<int[]> list = splitArray(original, splitSize);
		list.forEach(splitArray -> System.out.println(Arrays.toString(splitArray)));
	}

	public static List<int[]> splitArray(int[] array, int splitSize) {
		List<int[]> result = new ArrayList<>();
		if (splitSize > array.length || splitSize == 0) {
			result.add(array);
			return result;
		}
		int s = 0;
		int[] temp = new int[splitSize];
		for (int i=0; i<array.length; i++) {
			if (s == splitSize) {
				result.add(temp);
				temp = new int[Math.min((array.length - i), splitSize)];
				s = 0;
			}
			temp[s++] = array[i];
		}
		result.add(temp);
		return result;
	}
}




