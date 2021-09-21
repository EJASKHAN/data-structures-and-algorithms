package leetcode;

/**
 * @author Ejaskhan
 **/

import java.util.Arrays;

/**
 * Question: Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class LeetCode1 {
    public static void main(String[] args) {
     Arrays.stream(twoSum(new int[]{3, 2, 3}, 6))
             .forEach(a-> System.out.println(a+"-"));

    }

    public static int[] twoSum(int[] nums, int target) {

        int index= 0;
        int secondIndex = 1;
        while(index < nums.length)
        {
            if(nums[index] + nums[secondIndex] == target)
            {
                return new int[]{index,secondIndex};
            }
            if(secondIndex == nums.length-1)
            {
                index=index+1;
                secondIndex= index+1;
            }
            else
            {
                secondIndex =  secondIndex+1;
            }

        }
        return null;
    }
}
