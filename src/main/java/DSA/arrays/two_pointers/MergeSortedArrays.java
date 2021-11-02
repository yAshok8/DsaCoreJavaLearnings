package DSA.arrays.two_pointers;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int [] a = {4,5,6,0,0,0};
        int [] b = {1,2,3};
//        int [] a = {1,3,0};
//        int [] b = {2};
        mergeTwoSortedArrays(a, 3, b, 3);
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
    }

    private static void mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n){
        int pl = m + n - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0) {
            if(nums1[m] >= nums2[n]){
                nums1[pl] = nums1[m];
                m--;
                pl--;
            }else{
                nums1[pl] = nums2[n];
                n--;
                pl--;
            }
        }
        if(m<0){
            while (n >=0){
                nums1[pl--] = nums2[n--];
            }
        }
    }
}
