package DSA.arrays.gen;

class FindAbsentAndDuplicateNumber {
	public static void main(String[] args){
//		int [] a = {6,3,2,1,1,5}; //dup: 1, absent: 4
//		int [] a = {1,1,3}; //dup 1, absent 2
//		int [] a = {2,3,3}; //dup 3, absent 1
//		int [] a = {1,3,3}; //dup 3, absent 2
		int [] a = {1,2,3}; //dup -1, absent -1
		int dup = -1;
		int absentNum = -1;
		int index = 0;
		while(index < a.length){
			if(a[index] == index + 1){
				index++;
			}else{
				if(a[index] == a[a[index]-1]){
					dup = a[index];
					absentNum = index + 1;
					break;
				}else{
					int temp = a[index];
					a[index] = a[a[index]-1];
					a[temp-1] = temp;
				}
			}
		}
		System.out.println("Duplicate "+dup);
		System.out.println("Absent Number "+absentNum);
	}
}