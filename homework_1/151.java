public class Solution {
    public String reverseWords(String s) {
        // String[] words = s.split(" ");
        String[] words = s.trim().split(" ");
        int size = words.length;
        if(size == 0)
            // return null;
            return "";
        String answer = words[size - 1];
        for(int i = size - 2; i >= 0; i--)
        {
            if(words[i].equals(""))
                continue;
        	answer += " " + words[i];
        }
        return answer;
    }
}