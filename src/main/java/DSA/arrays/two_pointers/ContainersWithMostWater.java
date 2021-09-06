package DSA.arrays.two_pointers;

public class ContainersWithMostWater {
    public static void main(String[] args) {
        int [] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
    public static int maxArea(int[] height) {
        int maxVol = 0;
        int currentVol = 0;
        int l = 0;
        int h = height.length-1;

        while(l<=h){
            currentVol = Math.min(height[l], height[h]) * (h-l);
            maxVol = Math.max(currentVol, maxVol);
            if(height[l]<height[h])
                l++;
            else
                h--;
        }
        return maxVol;
    }
}
