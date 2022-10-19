class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        
        for(int i =0; i<haystack.length();i++) {
            int k = i, j =0;
            
            while(j < needle.length() && k < haystack.length() && haystack.charAt(k) == needle.charAt(j) ){
                k++;
                j++;
            }
            
            if (j == needle.length()) return i;
        }
        
        return -1;
    }
}