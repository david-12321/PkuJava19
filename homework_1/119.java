public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> answer = new ArrayList<Integer>();
        if(rowIndex == 0)
        {
        	answer.add(1);
        }
        else if(rowIndex == 1)
        {
        	answer.add(1);
        	answer.add(1);
        }
        else
        {
        	int row[] = new int[rowIndex + 2];
        	row[1] = row[2] = 1;
        	for(int i = 3; i <= rowIndex + 1; i++)
        	{
        		row[i] = 1;
        		for(int j = i - 1; j > 1; j--)
        		{
        			row[j] = row[j] + row[j - 1];
        		}
        	}
        	for(int i = 1; i <= rowIndex + 1; i++)
        	{
        		answer.add(row[i]);
        	}
        }
        return answer;
    }
}