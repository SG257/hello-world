import java.util.*;
import java.lang.*;
import java.io.*;

class Tree {
	private static void DFS(int node,Map<Integer,ArrayList<Integer>> map,int val[],int val1[] ){
			
			if(map.containsKey(node)){
				ArrayList<Integer> children = map.get(node);
				int sum = val[node];
				for(int i = 0; i < children.size(); i++ ){
					DFS(children.get(i),map,val,val1);
					sum+= val1[children.get(i)];
				}
				val1[node] = sum;
			}
			else{
				val1[node] = val[node];	
			}
			return;
	}
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int j =0; j < t; j++){
			int n,m,q;
			n  =sc.nextInt();
			m = sc.nextInt();
			q = sc.nextInt();
			int p[] = new int[n+1];
			int val[] = new int[n+1];
			int val1[] = new int[n+1];
			Map<Integer,ArrayList<Integer>> tree = new HashMap<Integer,ArrayList<Integer>>();
			for(int i = 1 ; i <= n+m+q; i++){
				if(i<n+1){
					p[i] = sc.nextInt();
					if(!tree.containsKey(p[i])){
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(i);
						tree.put(p[i],list);
					}
					else{
						tree.get(p[i]).add(i);
					}
				}
				else if(i <= n+m){
					if(i==n+1){
						sc.nextLine();
					}
					String str[] = sc.nextLine().split(" ");
					int x,y;
					x = Integer.parseInt(str[1]);
					y = Integer.parseInt(str[2]);
					if(str[0].equals("ADD")){
						val[x] += y;
					}
					else{
						while(x!=0){
							val[x]+=y;
							x = p[x];
						}
					}
				}
				else{
					if(i==n+m+1)
						DFS(0,tree,val,val1);
					String str[] = sc.nextLine().split(" ");
					int x;
					x = Integer.parseInt(str[1]);
					if(str[0].equals("VALTREE")){
						System.out.println(val1[x]);
					}
					else{
						System.out.println(val[x]);
					}
				}
			}
		}
	}
}