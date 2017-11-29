import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int n,k,m;
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		int arr[] = new int[m+1];
		for(int i = 0 ; i < m+1; i++){
			arr[i] = sc.nextInt();
		}
		int count = 0;
		for(int i = 0; i < m; i++){
			/* ---BITWISE XOR--- */
			int diff = 0 ; 						/* number of diff set bits * for a given player i/
			int player_army = arr[i];   		/* int a = 60; 60 = 0011 1100 */    
			int xor = player_army^arr[m];		/* int b = 13; 13 = 0000 1101 */
			for(int j = 0; j < 20; j++){		/* int c = a ^ b;        /* 49 = 0011 0001 */
				if((xor&1) == 1){  				/* --BITWISE AND-- */ 
					diff++;					/* if rightmost bit is set count++  : counting ones(set bits) in var xor  just like c has 3 ones */
				}
				if(diff > k)
					break;
				xor = xor>>>1;				/* Zero fill Right Shift */
			}
			if(diff <= k)
				count++;
		}
		System.out.println(count);
	}
}