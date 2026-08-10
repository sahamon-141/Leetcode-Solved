import java.util.ArrayList;
import java.util.List;

class Solution {
    // Mapping of digits to corresponding phone keypad letters
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case: Empty input string
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        
        // Start backtracking from index 0 with an empty string builder
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: If we've processed all digits, add the combination to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        char digit = digits.charAt(index);
        String letters = KEYPAD[digit - '0'];

        // Loop through all letters mapped to the current digit
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));          // Choose
            backtrack(digits, index + 1, current, result); // Explore next digit
            current.deleteCharAt(current.length() - 1); // Backtrack (Undo choice)
        }
    }
}
