import java.util.*;
import java.lang.*;
import java.io.*;

class Maximum_Tip_Calculator {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t; i++){
		    int n,x,y;
		    n = sc.nextInt();
		    x = sc.nextInt();
		    y = sc.nextInt();
		    int arr_x[] = new int[n];
            int arr_y[] = new int[n];
		    Integer diff[] = new Integer[n];
		    for(int j = 0; j< n; j++){
		        arr_x[j] = sc.nextInt();    
		    }
		    int sum = 0;
		    for(int j = 0; j< n; j++){
		        arr_y[j] = sc.nextInt();
		        sum+= arr_y[j];
		        diff[j] = arr_x[j]-arr_y[j];
		    }
		    Arrays.sort(diff,Collections.reverseOrder());
		    for(int j = 0; j< x & j<n; j++){
		        if(diff[j]>0){
		          sum += diff[j];  
		        }
		        else if(y<n){
		            sum += diff[j];
		            y++;
		        }
		    }
		    System.out.println(sum);
		}
	}
}