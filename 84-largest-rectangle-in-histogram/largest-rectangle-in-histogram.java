class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = leftSmall(heights);
        int[] right = rightSmall(heights);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]); 
        }
        return max;
    }

    public static int[] leftSmall(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            } else {
                res[i] = -1; 
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] rightSmall(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            } else {
                res[i] = arr.length; 
            }
            stack.push(i);
        }
        return res;
    }
}