public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> old = new ArrayList<Integer>();
		for(int size = 1; size <= numRows; size++)
		{
			List<Integer> now = new ArrayList<Integer>();
			if(size == 1)
			{
				now.add(1);
			}
			else if(size == 2)
			{
				now.add(1);
				now.add(1);
			}
			else
			{
				now.add(1);
				for(int i = 0; i < size - 2; i++)
				{
					now.add(old.get(i) + old.get(i + 1));
				}
				now.add(1);
			}
			old = now;
			answer.add(now);
		}
		return answer;
    }
}