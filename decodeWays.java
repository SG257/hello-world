import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int j = 0 ; j < t; j++ ){
		    int n = sc.nextInt();
		    if(n>0){
    		    int arr[] = new int[n];
    		    int num = sc.nextInt();
    		    int last_digit = num%10;
    		        arr[0] = 1;
    		    if(num%10 == 0){
                    arr[0] = 0;
    		    }
    		    num = num/10;
    		    int temp = num;
    		    int i = 1;
    		    while(temp>0){
    		        int rem = temp%10;
    		        if(rem != 0){
        		        if(i>0){
                            arr[i] = arr[i-1];
                            //System.out.println(arr[0] + " "+arr[1] + " "+arr[2]);
        		        }
        		        if((rem*10 + last_digit) <= 26 ){
                            if(i>1)
                                arr[i] = arr[i] + arr[i-2];
                            else if(i==1)
                                arr[i]++;
                            //System.out.println(arr[0] + " "+arr[1] + " "+arr[2]);
    		            }
                    }
                    last_digit = rem;
                    temp = temp/10;
                    i++;
    		    }
		        System.out.println(arr[n-1]);
		    }    		    
		    else
		        System.out.println(1);
		    
		}
	}
}