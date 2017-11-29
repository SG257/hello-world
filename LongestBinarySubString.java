import java.io.*;
import java.util.*;

class GFG {
   
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int left_sum[] = new int[str.length()];
		for(int  i = 0 ; i < left_sum.length; i++){
			if(str.charAt(i)=='1')
				left_sum[i]+=1;
			else
				left_sum[i]+=-1;
			if(i>0)
			    left_sum[i] += left_sum[i-1]; 
		}
		//System.out.println(Arrays.toString(left_sum));
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int max = 0;
		for(int i = 0 ; i < left_sum.length; i++){
			if(!hm.containsKey(left_sum[i])){
				hm.put(left_sum[i],i);
			}
			else{
				int x = hm.get(left_sum[i]);
				if(str.charAt(x)=='1'||(i+1< left_sum.length && str.charAt(i+1)=='1')){
					if(max < i-x +1){
					    max = i-x +1;
					}		    
				}
			}
		}
		if(left_sum[left_sum.length-1]>0){
			System.out.println(max);
		}
		else{
			System.out.println(left_sum.length);
		}
	}
}