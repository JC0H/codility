package com.codility;

//A binary gap within a positive integer N is any maximal sequence of consecutive zeros that
// is surrounded by ones at both ends in the binary representation of N.
//
//For example,
// number 9 has binary representation 1001 and contains a binary gap of length 2.
// The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
// The number 20 has binary representation 10100 and contains one binary gap of length 1.
// The number 15 has binary representation 1111 and has no binary gaps.
// The number 32 has binary representation 100000 and has no binary gaps.
//
//Write a function:
//
//class Solution { public int solution(int N); }
//
//that, given a positive integer N, returns the length of its longest binary gap. The function
// should return 0 if N doesn't contain a binary gap.
//
//For example, given N = 1041 the function should return 5, because N has binary representation
// 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0,
// because N has binary representation '100000' and thus no binary gaps.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..2,147,483,647].


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryGap {

    @Test
    public void shouldReturnTwoWhenInputNine(){
        assertEquals(2,new BinaryGap().solution(9));
    }

    @Test
    public void shouldReturnFourWhenInputFiveHundredTwentyNine(){
        assertEquals(4,new BinaryGap().solution(529));
    }

    @Test
    public void shouldReturnOneWhenInputTwenty(){
        assertEquals(1,new BinaryGap().solution(20));
    }

    @Test
    public void shouldReturnZeroWhenInputFifteen(){
        assertEquals(0,new BinaryGap().solution(15));
    }

    @Test
    public void shouldReturnZeroWhenInputThirtyTwo(){
        assertEquals(0,new BinaryGap().solution(32));
    }

    public int solution(int N) {
        String chars = Integer.toBinaryString(N);
        char[] c = chars.toCharArray();

        int firstIndex = 0;
        for (int i = 0; i < c.length; i++){
            if (c[i] == '1'){
                firstIndex = 1;
                break;
            }
        }

        int currentGap = 0;
        int biggestGap = 0;
        for (int i = firstIndex; i < c.length; i++){
            if (c[i] == '0'){
                currentGap++;
            }else {
                if (currentGap > biggestGap){
                    biggestGap = currentGap;
                }
                currentGap = 0;
            }
        }
        return biggestGap;
    }
}
