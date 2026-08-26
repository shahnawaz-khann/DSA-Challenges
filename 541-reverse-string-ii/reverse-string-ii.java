class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = s.length();

        for(int i=0; i<n; i=i+2*k) {
            int left = i;
            int right = Math.min(i+k-1, n-1);

            while(left < right) {
                char temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;

                left++; right--;
            }
        }
        return new String(arr);
    }
}