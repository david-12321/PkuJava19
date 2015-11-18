import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class One {
	public static void main(String[] args){
		File file1 = new File("E:/JavaWorkspace/WordCount/src/document/1.txt");
		File file2 = new File("E:/JavaWorkspace/WordCount/src/document/2.txt");
		BufferedReader reader = null;
		HashSet<String> answer = new HashSet<String>();
		try{
			reader = new BufferedReader(new FileReader(file1));
			String temp = null;
			while((temp = reader.readLine()) != null){
				//System.out.println(temp);
				String[] word = temp.split(" |\\.|,");//按空格逗号和句号将单词进行拆分
				for(String x : word){
					if(x.equals(""))
						continue;
					answer.add(x);
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
					answer.add(x);
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
		
		for(String x : answer)
			System.out.println(x);
	}
}