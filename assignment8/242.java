public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        if(sc.length != tc.length)
            return false;
            
        int[] ch = new int['z' - 'a' + 1];
            
        for(int i=0; i<sc.length; i++)
        {
            ch[sc[i] - 'a']++;
            ch[tc[i] - 'a']--;
        } 
        
        for(int j=0; j<ch.length; j++)
        {
            if(ch[j] != 0)
                return false;
        }
        return true;
    }
}