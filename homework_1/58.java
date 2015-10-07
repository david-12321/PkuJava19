public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
        if(!s.contains(" "))
            return s.length();
        //利用空格对字符串进行切割
        String word[] = s.split(" ");
        if(word.length == 0)
            return 0;
        else
            return word[word.length - 1].length();
    }
}