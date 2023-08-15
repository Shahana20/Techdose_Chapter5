class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                mp.put(stack.pop(), nums2[i]);
            }
            stack.push(i);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = mp.getOrDefault(findIndex(nums2, nums1[i]), -1);
        }
        
        return nums1;
    }
    
    private int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
