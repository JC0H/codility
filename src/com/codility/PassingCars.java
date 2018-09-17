package com.codility;
//A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
//
//Array A contains only 0s and/or 1s:
//
//0 represents a car traveling east,
//1 represents a car traveling west.
//The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
//
//For example, consider array A such that:
//
//  A[0] = 0
//  A[1] = 1
//  A[2] = 0
//  A[3] = 1
//  A[4] = 1
//We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
//                                     0  1    0  1    0  1    0  1    0  1
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
//
//The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
//
//For example, given:
//
//  A[0] = 0
//  A[1] = 1
//  A[2] = 0
//  A[3] = 1
//  A[4] = 1
//the function should return 5, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..100,000];
//each element of array A is an integer that can have one of the following values: 0, 1.

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PassingCars {

    @Test
    public void solutionTest(){
        int [] actual = new int[]{0, 1, 0, 1, 1};
        assertEquals(5, new PassingCars().solution(actual));
    }

    @Test
    public void solutionTest2(){
        int [] actual = new int[]{0, 1, 0, 1, 1, 0, 1};
        assertEquals(8, new PassingCars().solution(actual));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int zCount = 0;  // how many going east
        int passing = 0; // total passing pairs

        for(int i : A){
            if(i == 1){
                passing += zCount;
            }
            else zCount++;
        }
        if(passing > 1e9 || passing < 0) return -1;
        else return passing;
    }
}
