import java.util.*;
public class LongWords {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		/*String[] words=new String[n];
		String[] newStr=new String[n]; */
		for(int i=0;i<n;i++)
		{
			/*words[i]=s.next(); */ String word = s.next();
			if(/*words[i].length()*/ word.length() > 10 )
			{
				 /*newStr[i]=words[i].substring(0,1)+Integer.toString(words[i].substring(1,words[i].length()-1).length())+words[i].substring(words[i].length()-1); */
				System.out.println("" + word.charAt(0)+ (word.length() - 2)+ word.charAt( word.length() - 1 ) );
			    
			}
			else
			{
				/* newStr[i]=words[i]; */ System.out.println(word);
			}
		}
		/*for(int i=0;i<n;i++)
		{
			System.out.println(newStr[i]);
		}*/
	}
}
