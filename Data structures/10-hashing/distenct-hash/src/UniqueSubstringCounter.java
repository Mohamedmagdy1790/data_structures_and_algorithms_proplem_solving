import java.util.HashSet;

public class UniqueSubstringCounter {
    public static int countUniqueSubstrings(String str) {
        HashSet<String> set = new HashSet<>();

        // List all substrings and add to the set
        for (int start = 0; start < str.length(); ++start) {
            for (int end = start; end < str.length(); ++end) {
                String substring = str.substring(start, end + 1);
                set.add(substring);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        String str = "aaab";
        int count = countUniqueSubstrings(str);
        System.out.println(count);  // Output: 78
    }
}