import java.util.*;

class tpEasy1 {
    /**
     * myFirst solution, using two pointers to check for palindrome. We start
     * with one pointer at the beginning and another at the end of the string.
     * We move both pointers towards the center, skipping non-alphanumeric
     * characters. If the characters at both pointers don't match (case-insensitive),
     * we return false. If we successfully check all characters, we return true.
     * @param s input string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Other solutions can be made by, for example,
// 1. Using StringBuilder to create a filtered version of the string
//    containing only alphanumeric characters, then checking if it's
//    equal to its reverse.
// 2. Using recursion to compare characters from the start and end
//    of the string, moving towards the center.