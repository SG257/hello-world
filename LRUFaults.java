import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i = 0 ; i < t; i++){
           int n = sc.nextInt();
           int pages[] = new int[n];
           for(int j = 0; j < n; j++) {
               pages[j] = sc.nextInt();
            }
            int m = sc.nextInt();
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>(m);
            Queue<Integer> q = new ArrayBlockingQueue<Integer>(n);
            int faults =0;
            for(int j = 0; j < n; j++){
                q.offer(pages[j]);
                if(!hm.containsKey(pages[j])){
                    faults++;
                    hm.put(pages[j],1);
                    while(hm.size() > m){
                        int x = q.poll();
                        if(hm.get(x) == 1){
                            hm.remove(x);
                        }
                        else{
                            hm.put(x,hm.get(x) -1);
                        }
                    }
                }
                else{
                    hm.put(pages[j], hm.get(pages[j]) + 1);
                }
            }
            System.out.println(faults);
        }
    }
}