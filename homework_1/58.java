public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
        if(!s.contains(" "))
            return s.length();
        //���ÿո���ַ��������и�
        String word[] = s.split(" ");
        if(word.length == 0)
            return 0;
        else
            return word[word.length - 1].length();
    }
}