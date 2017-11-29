import java.io.*;
import java.util.*;

class GFG {
    static int a1,a2,a3,b1,b2,b3;
    public static int func(int a, int b,int call_type){
        if(a<0||b<0)
        return -1;
        else if(call_type == 1){
            return Math.max(func(a+a2,b+b2,2)+1,func(a+a3,b+b3,3)+1);
        }
        else if(call_type == 2){
            return Math.max(func(a+a1,b+b1,1)+1,func(a+a3,b+b3,3)+1);
        }
        else if(call_type == 3){
            return Math.max(func(a+a2,b+b2,2)+1,func(a+a1,b+b1,1)+1);
        }
        else{
            return Math.max(func(a+a1,b+b1,1)+1,Math.max(func(a+a2,b+b2,2)+1,func(a+a3,b+b3,3)+1));
        }
    } 
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
	    int a,b;
	    a = sc.nextInt();
	    b = sc.nextInt();
	    a1 = sc.nextInt();
	    b1 = sc.nextInt();
		a2 = sc.nextInt();
		b2 = sc.nextInt();
		a3 = sc.nextInt();
		b3 = sc.nextInt();
		System.out.println(func(a,b,-1));
	}
}