// MINIMUM DELETIONS TO MAKE ARRAYS DIVISIBLE
// You are given two positive integer arrays nums and numsDivide. You can delete any number of elements from nums.
// Return the minimum number of deletions such that the smallest element in nums divides all the elements of numsDivide.
// If this is not possible, return -1.
// Note that an integer x divides y if y % x == 0.



import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(numsDivide);
        int val = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            val = gcd(val, numsDivide[i]);
        }
        Arrays.sort(nums);
        int c = 0;
        if (nums[0] > val) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > val) break;
            if (val % nums[i] != 0) c++;
            else break;
        }
        if (c == nums.length) return -1;
        return c;
    }

    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        String[] elements = sc.nextLine().split("\\s+");
        String[] elements1 = sc.nextLine().split("\\s+");
        int[] numsDivide = new int[elements1.length];
        int[] nums = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            nums[i] = Integer.parseInt(elements[i]);
        }
        for (int i = 0; i < elements1.length; i++) {
            numsDivide[i] = Integer.parseInt(elements1[i]);
        }
        System.out.println(minOperations(nums, numsDivide));
    }
}