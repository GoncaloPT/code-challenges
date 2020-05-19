package interviewprepkit.sorting;

import java.util.Arrays;

/*
 * Created by: @author Gonçalo Silva
 * 18/05/2020
 * Complete the function maximumToys in the editor below. It should return an integer representing the maximum number of toys Mark can purchase.
 * maximumToys has the following parameter(s):
 * prices: an array of integers representing toy prices
 * k: an integer, Mark's budget
 */
public class MarkAndToys {

    int maximumToys(int[] prices, int k) {

        int numberOfToys = 0;
        Arrays.sort(prices);
        for(int price: prices){
            k -= price;
            if( k < 0 )
                break;
            numberOfToys++;
        }
        return numberOfToys;


    }
}
