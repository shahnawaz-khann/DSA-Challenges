    class Solution {
        public String reverseWords(String s) {
            String[] str = s.split("\\s+");
            
            for(int i=0; i<str.length; i++) {
                str[i] = reverse(str[i].toCharArray());
            }
            return String.join(" ", str);
        }
        private String reverse(char[] arr) {
            int i = 0;
            int j = arr.length - 1;

            while(i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++; j--;
            }
            return new String(arr);
        }
    }