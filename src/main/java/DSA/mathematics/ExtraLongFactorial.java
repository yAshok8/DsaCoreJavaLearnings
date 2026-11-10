package DSA.mathematics;

public class ExtraLongFactorial {

    public static void main(String[] args) {
        extraLongFactorials(10);
    }

    public static void extraLongFactorials(int n) {
        String ans = "1";
        while (n > 1) {
            ans = multiply(ans, n);
            n--;
        }
        System.out.println(ans);
    }

    private static String multiply(final String numStr, final int multiplier) {
        StringBuilder stringBuffer = new StringBuilder();
        int index = numStr.length() - 1;
        int carry = 0;
        while (index >= 0) {
            int lastDigit = numStr.charAt(index) - '0';
            int mulRes = (lastDigit * multiplier) + carry;
            carry = mulRes / 10;
            int rem = mulRes % 10;
            stringBuffer.append(rem);
            index--;
        }
        stringBuffer.reverse();
        if (carry != 0) stringBuffer.insert(0, carry);
        return stringBuffer.toString();
    }
}
