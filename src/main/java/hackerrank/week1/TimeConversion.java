package hackerrank.week1;

class TimeConversionResult {

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 *
 * Input 1 : "12:01:00PM"
 * Output 1 : "12:01:00"
 * Input 2 : "12:01:00AM"
 * Output 2 : "00:01:00"
 */

    //07:05:45PM
    public static String timeConversion(String s) {
        //fetch first and last 2 chars as string
        int strlen = s.length();
        String period = s.substring(strlen-2, strlen);
        int hour = Integer.parseInt(s.substring(0,2));
        int finalHour = 0;
        String finalTime = null;
        if ("AM".equalsIgnoreCase(period)){
            finalHour = hour % 12;
            finalTime =  "0" + finalHour + "" + s.substring(2, strlen-2);
        }else{
            finalHour = 12 + ( hour % 12 );
            finalTime = finalHour + "" + s.substring(2,strlen-2);
        }
        return finalTime;
    }

}

public class TimeConversion {
    public static void main(String[] args){
        System.out.println(TimeConversionResult.timeConversion("12:01:00PM"));
        System.out.println(TimeConversionResult.timeConversion("12:01:00AM"));
    }
}
