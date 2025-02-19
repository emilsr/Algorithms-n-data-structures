package main.f13;

public class MaxSum {
    public static int maxSumItr(int[] arr) {
        int maxCount = Integer.MIN_VALUE;
        int currentCount = 0;

        for (int i = 0; i < arr.length-1; i++) {
            currentCount += arr[i];
            if (currentCount >= maxCount ) { maxCount = currentCount; }
            if (currentCount < 1){ currentCount = 0; }
        }
        return maxCount;
    }

    public static int maxSumRec (int[] arr) {
        return maxSumRec(arr, 0, arr.length-1);
    }

    public static int maxSumRec (int[] arr, int left, int right) {
        if (left > right) { return 0; }
        if (left == right) { return Math.max(arr[left], 0); }
        int mid = (left + right) / 2;
        int leftSum = 0, maxLeft=0;
        for (int i = mid; i >= left; i--) {
            leftSum += arr[i];
            maxLeft = Math.max(maxLeft, leftSum);
        }
        int rightSum = 0, maxRight=0;
        for (int i = mid + 1; i <= right; i++) {
            rightSum += arr[i];
            maxRight = Math.max(maxRight, rightSum);
        }
        int sum = maxLeft + maxRight;
        return Math.max(sum, Math.max(maxSumRec(arr, left, mid), maxSumRec(arr, mid+1, right)));
    }

    public static void main(String[] args) {
        System.out.println(maxSumItr(new int[]{24, 35, -87, 21, 80, -12, 32, -90, 45, 10}));
        System.out.println(maxSumRec(new int[]{24, 35, -87, 21, 80, -12, 32, -90, 45, 10}));
    }
}
