package com.codility;

//An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)],
// which means that exactly one element is missing.
//
//Your goal is to find that missing element.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A, returns the value of the missing element.
//
//For example, given array A such that:
//
//  A[0] = 2
//  A[1] = 3
//  A[2] = 1
//  A[3] = 5
//the function should return 4, as it is the missing element.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..100,000];
//the elements of A are all distinct;
//each element of array A is an integer within the range [1..(N + 1)].

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermMissingElem {

    @Test
    public void solutionTest(){
        int[] expect = new int[]{2,3,1,5};
        assertEquals(4,new PermMissingElem().solution(expect));
    }

    @Test
    public void solutionTest2(){
        int[] expect = new int[]{2,1,5,6,8,4,7};
        assertEquals(3,new PermMissingElem().solution(expect));
    }

    public static int solution(int[] A) {

        long N = A.length + 1;
        long total = N * (N + 1) / 2;

        for (int i : A) {
            total -= i;
        }

        return (int)total;
    }



}
