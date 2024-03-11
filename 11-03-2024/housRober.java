// HOUSE ROBBER
// You are a professional robber planning to rob houses along a street. 
// Each house has a certain amount of money stashed, the only constraint 
// stopping you from robbing each of them is that adjacent houses have security 
// systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
// Input
// In 1st Line, Enter the money in each house separated by commas
// Output
// Print the maximum amount of money
// Example
// Input:

// 1,2,3,1
// Output:

// 4
import java.util.Scanner;
class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; 
        if (n == 1) return nums[0];  
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); 
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[n - 1];
    }
    
    public static void main(String[] args) {
        // Taking input
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        
        // Finding the maximum amount of money
        int maxAmount = rob(nums);
        
        // Printing the result
        System.out.println(maxAmount);
    }
}