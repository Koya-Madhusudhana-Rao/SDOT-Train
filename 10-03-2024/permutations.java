import java.util.*;

class Main {
    public static void permute(int[] arr, int l, int h) {
        if (l == h) {
            printArray(arr);
        } else {
            for (int i = l; i <= h; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, h);
                swap(arr, l, i);
            }
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter numbers separated by space: ");
        String input = sc.nextLine();
        String[] numbers = input.split("\\s+");
        
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        permute(arr, 0, arr.length - 1);
    }
}