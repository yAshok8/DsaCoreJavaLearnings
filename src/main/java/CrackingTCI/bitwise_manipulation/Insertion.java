package CrackingTCI.bitwise_manipulation;

/*
 * Problem: You are given two 32-bit numbers, N and M, and two bit positions, i
 * and j. Write a method to insert M into N such that M starts at bit j and ends
 * at bit i. You can assume that the bits j through i have enough space to fit
 * all of M. That is, if M = 10011, you can assume that there are at least 5
 * bits between j and i. You would not, for example, have j = 3 and i = 2,
 * because M could not fully fit between bit 3 and bit 2.
 *
 * EXAMPLE
 *
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 *
 * Output: N = 10001001100
 *
 */

public class Insertion {
    public static void main(String[] args) {
        int n = 1024;
        int m = 19;
        int i = 2;
        int j = 6;
        System.out.println(Integer.toBinaryString(bitwiseInsertion(n,m,j,i)));
    }

    private static int bitwiseInsertion(int n, int m, int j, int i){
        //First create a mask (m) in which all the bits will be one except bits from i -> j
            //create left ones l
            //create right ones r
            // m = l | m
        //Second move m left to i bits (moved_m)
        //Then moved_m | m will give the answer
        int allOnes = ~0;
        int leftOnes = allOnes << (j+1);
        int rightOnes = (1 << i) - 1;
        int mask = leftOnes | rightOnes;
        int clearN = n & mask;
        int shiftMbyIbits = m << i;
        return clearN | shiftMbyIbits;
    }
}
