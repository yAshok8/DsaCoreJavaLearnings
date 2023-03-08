package interviewAsked;

public class Atoi_MediaNet {
    public static void main(String[] args) {
        String input = "500";
        System.out.println(findNumber(input));
    }

    private static int findNumber(String s) {
        if (s == null || s.length() == 0) return -1;
        int lastPtr = s.length() - 1;
        int res = 0;
        int multiplier = 1;
        int lastCalculated = 0;
        for (int i=lastPtr; i>=0; i--) {
            int asciiRep = (int) s.charAt(i);
            if (asciiRep < 48 || asciiRep > 57)
                return -1;
            lastCalculated = (asciiRep - 48) * multiplier;
            res = res + lastCalculated;
            multiplier *= 10;
        }
        return res;
    }
}
