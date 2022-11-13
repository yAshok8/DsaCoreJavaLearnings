package DSA.arrays.gen; /******************************************************************************
Welcome to GDB Online.
Code, Compile, Run and Debug online from anywhere in world.
*******************************************************************************/
import java.util.*;

class SplitIntoSubArray {
	public static void main(String[] args) {
		int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};//, 10};
//		int[] original = {1, 2, 3, 4};
		int splitSize = 3;
		
		/* expected Output 
		[0, 1, 2]
		[3, 4, 5]
		[6, 7, 8]
		[9]
		*/

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
		int[] temp = null;
		for (int i=0; i<array.length; i++) {
			int min = Math.min((array.length - i), splitSize);
			if (s == splitSize) {
				result.add(temp);
				temp = new int[min];
				s = 0;
			} else {
				if (temp == null)
					temp = new int[min];
			}
			temp[s++] = array[i];
		}
		if (null != temp) {
			result.add(temp);
		}
		return result;
	}
}




