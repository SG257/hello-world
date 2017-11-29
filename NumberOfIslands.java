import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k =0 ; k < t; k++){
			int n,m;
			n = sc.nextInt();
			m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i = 0 ;i<n;i++){
				for(int j=0;j<m;j++){
					arr[i][j] = sc.nextInt();
				}
			}
			int island_count = 0;
			for(int i = 0 ;i<n;i++){
				for(int j=0;j<m;j++){
					if(arr[i][j] ==1)
					{	island_count++;
						Stack<Integer> dfsi = new Stack<Integer>();
						Stack<Integer> dfsj = new Stack<Integer>();
						dfsi.push(i);
						dfsj.push(j);
						while(!dfsi.isEmpty()){
							int x = dfsi.pop();
							int y = dfsj.pop();
							arr[x][y] = 0;
							for(int a = -1; a < 2; a++){
								for(int b = -1; b <2; b++){
									if((x+a >= 0 && x+a < n) && (y+b >= 0 && y+b < m) && arr[x+a][y+b]==1){
										dfsi.push(x+a);
										dfsj.push(y+b);
									}
								}
							}
						}
					}
				}
			}
			System.out.println(island_count);
		}
	}
}