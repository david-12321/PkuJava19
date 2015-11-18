import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;


public class TextOps
{
	
	public static void main(String[] args)
	{
		String fileName="";
		TextOps ops=new TextOps();
		
		HashSet<String> textSetA=null;
		HashSet<String> textSetB=null;
//		HashSet<String> intersectionSet=null;
		
		
		fileName="D:\\textA.txt";
		textSetA = ops.getTextA(fileName);
		ops.printSet(textSetA);
		
		fileName="D:\\textB.txt";
		textSetB = ops.getTextB(fileName);
		ops.printSet(textSetB);
		
		HashSet<String> textUnion = ops.getUnionWord(textSetA, textSetB);
		ops.printSet(textUnion);
		System.out.println(textUnion.size());
		
		HashSet<String> textIntersection = ops.getIntersectionWord(textSetA, textSetB);
		ops.printSet(textIntersection);
		System.out.println(textIntersection.size());
//		
		//new TextOps().getAllWord();
	}
	
	public HashSet<String> getUnionWord(HashSet<String> textSetA,HashSet<String> textSetB)
	{
		HashSet<String> set = new HashSet<String>();
		Iterator<String> it;
		if(textSetA!=null && textSetA.size()>0)
		{
			it = textSetA.iterator();
			while(it.hasNext())
			{
				set.add(it.next());
			}
		}

		if(textSetB!=null && textSetB.size()>0)
		{
			it = textSetB.iterator();
			while(it.hasNext())
			{
				set.add(it.next());
			}
		}
			
		return set;
	}
	
	public HashSet<String> getIntersectionWord(HashSet<String> textSetA,HashSet<String> textSetB)
	{
		HashSet<String> set = new HashSet<String>();
		if(textSetA==null&&textSetB==null)
			return set;
		Iterator<String> it;
		if(textSetA!=null && textSetA.size()>0)
		{
			it = textSetA.iterator();
			while(it.hasNext())
			{
				String s=it.next();
				if(textSetB.contains(s))
				{
					set.add(s);
				}
			}
		}
			
		return set;
	}
	
	public HashSet<String> getTextB(String fileName)
	{
		if(fileName!=null && fileName!="")
			return getText(fileName);
		return null;
	}
	
	public HashSet<String> getTextA(String fileName)
	{
		if(fileName!=null && fileName!="")
			return getText(fileName);
		return null;
	}
	
	@SuppressWarnings("resource")
	public HashSet<String> getText(String fileName)
	{
		File file = new File(fileName);
		BufferedReader reader = null;
		HashSet<String> set = new HashSet<String>();
		
		String line="";
		try
		{
			StringTokenizer st = null;
			reader = new BufferedReader(new FileReader(file));
			while((line=reader.readLine())!=null)
			{
				st = new StringTokenizer(line," ,?.!:\"\"''\n");
				while(st.hasMoreTokens())
				{
					set.add(st.nextToken());
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return set;
	}
	
	public void printSet(HashSet<String> set)
	{
		if(set!=null)
		{
			Iterator<String> it = set.iterator();
			while(it.hasNext())
			{
				System.out.print(it.next()+" ");
			}

			System.out.println();
		}
	}
}