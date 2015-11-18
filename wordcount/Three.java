import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Three {
	public static void main(String[] args){
		File file1 = new File("E:/JavaWorkspace/WordCount/src/document/1.txt");
		File file2 = new File("E:/JavaWorkspace/WordCount/src/document/2.txt");
		BufferedReader reader = null;
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();
		HashMap<String,Integer> map2 = new HashMap<String,Integer>();
		HashSet<String> same = new HashSet<String>();
		try{
			reader = new BufferedReader(new FileReader(file1));
			String temp = null;
			while((temp = reader.readLine()) != null){
				//System.out.println(temp);
				String[] word = temp.split(" |\\.|,");//按空格逗号和句号将单词进行拆分
				for(String x : word){
					if(x.equals(""))
						continue;
					if(!map1.containsKey(x))
						map1.put(x,1);
					else
					{
						int num = map1.get(x) + 1;
						map1.put(x,num);
					}
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
					if(map1.containsKey(x))
						same.add(x);
					if(!map2.containsKey(x))
						map2.put(x,1);
					else
					{
						int num = map2.get(x) + 1;
						map2.put(x,num);
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
		//file1
		int total = 0;
		Iterator iter1 = map1.keySet().iterator();
		while(iter1.hasNext()){
			String key = (String) iter1.next();
			total = total + map1.get(key);
		}
		System.out.println("file1 total word = " + total);
		
		//file2
		total = 0;
		Iterator iter2 = map2.keySet().iterator();
		while(iter2.hasNext()){
			String key = (String) iter2.next();
			total = total + map2.get(key);
		}
		System.out.println("file2 total word = " + total);
		
		int size_a = map1.size();
		int size_b = map2.size();
		for(String x : same)
		{
			map1.remove(x);
			map2.remove(x);
		}
		
		System.out.println("proportion = " + map1.size()*1.0/size_a);
		System.out.println("proportion = " + map2.size()*1.0/size_b);
	}
}
