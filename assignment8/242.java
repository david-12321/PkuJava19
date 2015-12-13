import java.util.HashMap;

//leetcode 242
public class ValidAnagram
{

	public static void main(String[] args)
	{
		String s = "a";
		String t = "a";
		System.out.println(new ValidAnagram().isAnagram(s, t));
	}

    public boolean isAnagram(String s, String t) {
    	if(s.length()!=t.length())
    		return false;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	char[] sChar = s.toCharArray();
    	for(int i=0;i<sChar.length;i++)
    	{
    		if(map.containsKey(sChar[i]))
    		{
    			map.put(sChar[i], map.get(sChar[i])+1);
    		}
    		else {
    			map.put(sChar[i], 1);
			}
    	}
    	char[] tChar = t.toCharArray();
    	for(int i=0;i<tChar.length;i++)
    	{
    		if(map.containsKey(tChar[i]))
    		{
    			int count = map.get(tChar[i]);
    			if(count-1==0)
    			{
    				map.remove(tChar[i]);
    			}
    			else {
    				map.put(tChar[i], count-1);
				}
    		}
    		else {
				return false;
			}
    	}
    	if(!map.isEmpty())
    		return false;
    	return true;
    }
}
