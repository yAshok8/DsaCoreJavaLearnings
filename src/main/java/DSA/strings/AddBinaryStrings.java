package DSA.strings;

class AddBinaryStrings {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        int a_index = a.length()-1;
        int b_index = b.length()-1;
        StringBuffer ans = new StringBuffer();
        int carry = 0;
        while(a_index >= 0 && b_index >= 0){
            int a_c = Math.abs(a.charAt(a_index)-48);
            int b_c = Math.abs(b.charAt(b_index)-48);
            if (a_c == 1 && b_c == 1){
                if (carry == 1){
                    ans.append(1);
                }else{
                    ans.append(0);
                }
                carry = 1;
            }else{
                if(a_c == 0 && b_c == 0){
                    if (carry == 1){
                        ans.append(1);
                    }else{
                        ans.append(0);
                    }
                    carry = 0;
                }else{
                    if (carry == 1){
                        ans.append(0);
                        carry = 1;
                    }else{
                        ans.append(1);
                        carry = 0;
                    }
                }
            }
            a_index--;
            b_index--;
        }
        if(a_index<0){
            //while loop for b_index to be 0
        }else{
            //while loop for a_index to be 0
        }
        return ans.reverse().toString();
    }
}