import java.util.HashMap;
import java.util.HashSet;

public class UniqueSubstringCounter {
    public static int countUniqueSubstrings(String str,String str2) {
        HashMap<String,String> map1 = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();


        // List all substrings and add to the set
        for (int start = 0; start < str.length(); ++start) {
            for (int end = start; end < str.length(); ++end) {
                String substring = str.substring(start, end + 1);
                map1.put(substring,substring);
                System.out.println(substring);
            }
        }
        System.out.println("-------------------------------------------");
        for (int start = 0; start < str2.length(); ++start) {
            for (int end = start; end < str2.length(); ++end) {
                String substring = str2.substring(start, end + 1);
                map2.put(substring,substring);
                System.out.println(substring);

            }
        }

        //check which map is bigger
        boolean map1bigger =map1.size()>map2.size();
        int count=0;
        if(map1bigger){
            for (String key : map2.keySet()) {
                System.out.println("Key: " + key);
                if(map1.get(key) != null) count++;

            }

        }
        else {
            for (String key : map1.keySet()) {
                System.out.println("Key: " + key);
                if(map2.get(key) != null) count++;

            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "aaab",str2="aaab";
        int count = countUniqueSubstrings(str,str2);
        System.out.println(count);  // Output: 78
    }
}