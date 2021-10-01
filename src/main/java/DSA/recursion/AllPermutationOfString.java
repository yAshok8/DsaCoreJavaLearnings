package DSA.recursion;

public class AllPermutationOfString {

    public static void main(String[] args) {
        String name = "ashok";
    }

    private static void swapAndPrint(String name){
        char [] nameChars = name.toCharArray();
        int init = 0;
        int swap = 0;
        for (int i=0; i<name.length(); i++){
            for (int j=0; j<name.length(); j++){
                System.out.print(nameChars[j]+" ");
            }
        }
    }
}
