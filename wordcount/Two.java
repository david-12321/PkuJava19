import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Two {
	public static void main(String[] args){
		File file1 = new File("E:/JavaWorkspace/WordCount/src/document/1.txt");
		File file2 = new File("E:/JavaWorkspace/WordCount/src/document/2.txt");
		BufferedReader reader = null;
		HashMap<String,Integer> answer = new HashMap<String,Integer>();
		try{
			reader = new BufferedReader(new FileReader(file1));
			String temp = null;
			while((temp = reader.readLine()) != null){
				//System.out.println(temp);
				String[] word = temp.split(" |\\.|,");//按空格逗号和句号将单词进行拆分
				for(String x : word){
					if(x.equals(""))
						continue;
					if(!answer.containsKey(x))
						answer.put(x,1);
				}
			}
			reader.close();
			reader = new BufferedReader(new FileReader(file2));
			while((temp = reader.readLine()) != null){
				//System.out.println(temp);
				String[] word = temp.split(" |\\.|,");//按空格逗号和句号将单词进行拆分
				for(String x : word){
					if(x.equals(""))
						continue;
					if(answer.containsKey(x)){
						int num = answer.get(x) + 1;
						answer.put(x,num);
					}
				}
			}
			reader.close();
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			if(reader != null){
				try{
					reader.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		}
		
		Iterator iter = answer.keySet().iterator();
		while(iter.hasNext()){
			String key = (String) iter.next();
			int num = answer.get(key);
			if(num > 1){
				System.out.print(key + " ");
				System.out.println("num:" + answer.get(key));
			}
		}
	}
}
