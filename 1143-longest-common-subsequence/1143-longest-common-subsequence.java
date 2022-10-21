class Solution {
    public int longestCommonSubsequence(String text2, String text1) {
        int [][] lengths = new int [text2.length() + 1][text1.length() + 1];
        
        for (int i=1;i<text2.length()+1;i++) {
            for (int j=1;j<text1.length()+1;j++) {
                if (text2.charAt(i-1) == text1.charAt(j-1)) {
                    lengths[i][j] = lengths[i-1][j-1] + 1;
                } else {
                    lengths[i][j] = Math.max(lengths[i-1][j], lengths[i][j-1]);
                }
            }
        }
        return lengths[text2.length()][text1.length()];
        // return buildSequence(lengths, text1);
    }
    
//     private int buildSequence(int [][] lengths, String str) {
//         String seq = "";
//         int i = lengths.length - 1;
//         int j = lengths[0].length - 1;
        
//         while (i != 0 && j != 0) {
//             if (lengths[i][j] == lengths[i-1][j]) {
//                 i--;
//             } else if (lengths[i][j] == lengths[i][j-1]) {
//                 j--;
//             } else {
//                 seq = str.charAt(j-1) + seq;
//                 i--;
//                 j--;
//             }
//         }
//         return seq.length();
//     }
}