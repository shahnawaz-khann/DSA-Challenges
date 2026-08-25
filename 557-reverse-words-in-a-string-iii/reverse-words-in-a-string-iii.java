class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++) {
            arr[i] = reverse(arr[i]);
        }
        return String.join(" ", arr);

    }
    private String reverse(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();

        while(i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        return new String(arr);
    }
}