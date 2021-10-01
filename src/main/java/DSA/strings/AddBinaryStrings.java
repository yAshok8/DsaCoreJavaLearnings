package DSA.strings;

class AddBinaryStrings {

    public static void main(String[] args) {
        String a = "100111";
        String b = "110010";
        System.out.println(addBinaryBF(a, b));
        System.out.println(addBinaryCleanOptimized(a, b));
    }

    private static String addBinaryCleanOptimized(String a, String b){
        int a_idx = a.length() - 1;
        int b_idx = b.length() - 1;
        int carry = 0;
        StringBuilder sbr = new StringBuilder();

        while(a_idx > -1 || b_idx > -1 || carry == 1){

            if(a_idx > -1)
                carry += a.charAt(a_idx) - '0';

            if(b_idx > -1)
                carry += b.charAt(b_idx) - '0';

            sbr.append(carry%2);

            carry = carry / 2;
            a_idx--;
            b_idx--;

        }

        return sbr.reverse().toString();
    }

    private static String addBinaryBF(String a, String b) {
        int a_index = a.length()-1;
        int b_index = b.length()-1;
        StringBuilder ans = new StringBuilder();
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
            while(b_index >= 0){
                if(carry == 0){
                    ans.append(Math.abs(b.charAt(b_index)-48));
                }else{
                    if(Math.abs(b.charAt(b_index)-48) == 1){
                        ans.append(0);
                        carry = 1;
                    }else{
                        ans.append(1);
                        carry = 0;
                    }
                }
                b_index--;
            }
        }else{
            //while loop for a_index to be 0
            while(a_index >= 0){
                if(carry == 0){
                    ans.append(Math.abs(a.charAt(a_index)-48));
                }else{
                    if(Math.abs(a.charAt(a_index)-48) == 1){
                        ans.append(0);
                        carry = 1;
                    }else{
                        ans.append(1);
                        carry = 0;
                    }
                }
                a_index--;
            }
        }

        if(carry==1)
            ans.append(1);

        return ans.reverse().toString();
    }
}