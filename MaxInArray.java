import java.util.*;
public class MaxInArrayOfSizeK {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int k=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=s.nextInt();
			}
			Queue<Integer> q=new LinkedList<Integer>();
			for(int i=0;i<=n-k;i++)
			{
				q.offer(arr[i]);
				if(q.size()==k)
				{
					System.out.println(maxInQ(q));
					int waste=q.poll();
				}
					
				
			}
			t--;
		}
	}
	public static int maxInQ(Queue<Integer> q)
	{
		int max=q.poll();
		while(!q.isEmpty())
		{
			 max=Math.max(max,q.poll());
		}
		return max;
	}

}
