package rough_work;

public class RoughWork {
    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        System.out.println(Integer.toBinaryString(15));
//        System.out.println(Integer.toBinaryString(-15));
//        System.out.println(areOccurrencesEqual("abc"));
        String [] strs = {"a", "asolhi", "astol", "ak"};
        System.out.print("Prefix String is " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        StringBuffer prefix = new StringBuffer();
        while(charCheck(index, strs)){
            prefix.append(strs[0].charAt(index));
            index++;
        }
        return prefix.toString();
    }

    private static boolean charCheck(int index, String [] strs){
        boolean flag = true;
        char c  = (strs[0].length() > index) ? strs[0].charAt(index) : '\0';
        if(c == '\0')
            return false;
        for(String s : strs){
            //check if string has character at the index place
            if(index >= s.length() || s.charAt(index) != c)
                return false;
        }
        return flag;
    }

    private static boolean areOccurrencesEqual(String s){
        int [] charArray = new int[300];
        char [] c_arr = s.toCharArray();
        for(char c : c_arr)
            ++charArray[c];
        int common_freq = 0, freq = charArray[c_arr[0]];
        for(char c : c_arr){
            common_freq = charArray[c];
            if(freq != common_freq)
                return false;
        }
        return true;
    }

    private static void printMatInZigZag(){
        int size = 9;
        for(int i=0; i<=size; i++){
            int innerI = i;
            for(int j=0; j<=size-i; j++){
                System.out.print("("+j+","+(innerI++)+") ");
            }
            System.out.println();
        }
    }
}
