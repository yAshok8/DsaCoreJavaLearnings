package DSA.hashtable;

class RingsAndRods {

    public static void main(String[] args) {
//        String rings = "B0B6G0R6R0R6G9";
        String rings = "B0R0G0R9R0B0G0";
        int res = countPoints(rings);
        System.out.println(res);
    }

    private static int countPoints(String rings) {
        String [] rodsVal = new String[] {"", "", "", "", "", "", "", "", "", ""};
        int index = 0;
        int res = 0;
        while (index < rings.length()) {
            char color = rings.charAt(index);
            int rod = rings.charAt(index+1) - 48;
            if (rodsVal[rod] != null && rodsVal[rod].length() != 3 && !rodsVal[rod].contains(String.valueOf(color))) {
                rodsVal[rod] += color;
                if (rodsVal[rod].length() == 3) res++;
            }
            index+=2;
        }
        return res;
    }
}