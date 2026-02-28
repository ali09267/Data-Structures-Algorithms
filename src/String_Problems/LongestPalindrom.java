package String_Problems;

public class LongestPalindrom {
    public static String longestPalindromic(String str){
        if (str.length() <= 1){
            return str;
        }

        String LPS = "";

        for (int i = 1; i < str.length(); i++) {
            //odd length
            int low = i;
            int high = i;

            // Keep extending in both left and right directions
            // till the conditions for a palindrome are met
            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                // Terminating condition if we reach the end/start of the string
                if (low == -1 || high == str.length())
                    break;
            }

            // Indexes low and high can be used to extract the substring
            String palindrome = str.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                // Capture the longest palindrome found
                LPS = palindrome;
            }
            //even length
            low = i - 1;
            high = i;

            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            palindrome = str.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                // Keep track of the longest even length palindrome
                LPS = palindrome;
            }
        }

        return LPS;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindromic("ayxnoonxyeqiur"));
    }
}
