
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
//Smart Assembly Language
public class SmartAssemblyLanguage {
	static HashMap<String,Integer> labelMap = new HashMap<String,Integer>();
	static HashMap<String,Integer> variableMap = new HashMap<String,Integer>();
	public static int Execute(ArrayList<String> code,int line_Exec){
		switch(code.get(0)){
			case "ECHO": try{
							System.out.println(Integer.parseInt(code.get(1)));
						}
						catch(Exception e){
							if(variableMap.containsKey(code.get(1))){
								System.out.println(variableMap.get(code.get(1)));
							}
							else{
								System.out.println("0");
							}
						}
						break;
			case "EXIT":return -1;
			case "SET":	try {
							variableMap.put(code.get(1),Integer.parseInt(code.get(2)));
						}
						catch(Exception e){
							if(variableMap.containsKey(code.get(2))){
								variableMap.put(code.get(1),variableMap.get(code.get(2)));
							}
							else{
								variableMap.put(code.get(1),0);
							}
						}
						break;
			case "ADD":	{
						int a=0,b=0;
						try{
							a = Integer.parseInt(code.get(1));
						}
						catch(Exception e){
							if(variableMap.containsKey(code.get(1))){
								a = variableMap.get(code.get(1));
							}
							else{
								a = 0;
							}
							try{
								b = Integer.parseInt(code.get(2));
							}
							catch(Exception d){
								if(variableMap.containsKey(code.get(2))){
									b = variableMap.get(code.get(2));
								}
								else{
									b = 0;
								}
							}
						}
						variableMap.put(code.get(3),a+b);
						}
						break;
			case "GOTO": return labelMap.get(code.get(1));
			case "CONTINUE": return Integer.parseInt(code.get(1));
			case "IF":{
						int a=0,b=0;
						try{
							a = Integer.parseInt(code.get(1));
						}
						catch(Exception e){
							if(variableMap.containsKey(code.get(1))){
								a = variableMap.get(code.get(1));
							}
							else{
								a = 0;
							}
							try{
								b = Integer.parseInt(code.get(2));
							}
							catch(Exception d){
								if(variableMap.containsKey(code.get(2))){
									b = variableMap.get(code.get(2));
								}
								else{
									b = 0;
								}
							}
						}
						if(a!=b){
							return Integer.parseInt(code.get(3));
						}
					}
					break;
		}			
		return ++line_Exec;
	}
	public static void main(String[] args) {
		System.out.println("STARTED");
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<String>> code = new ArrayList<ArrayList<String>>();
		Stack<Integer> codeStack = new Stack<Integer>();

		int line_num = 0;
		
		// COMPILE
		
		while(sc.hasNextLine()){
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			ArrayList<String> line = new ArrayList<String>();
			
			// IF BLOCK CHECK
			if(arr[0].equals("IF")){
				codeStack.push(line_num);
			}
			if(arr[0].equals("END")){
				if(codeStack.isEmpty()){
					System.out.println("EXCEPTION");
					return;
				}
				else{
					int ifLine = codeStack.pop();
					code.get(ifLine).add(""+line_num);
					continue;
				}
			}
			
			// Adding Label Line_Number to  LabelMAP
			
			if(arr[0].equals("LABEL")){
				labelMap.put(arr[1],line_num);
				continue;
			}
			
			for(int i=0 ; i < arr.length ; i++){
				line.add(arr[i]);
			}
			
			// CONTINUE WITHIN IF BLOCK
			if(arr[0].equals("CONTINUE")){
				if(codeStack.isEmpty()){
					System.out.println("EXCEPTION");
					return;
				}
				else{
					line.add(""+codeStack.peek());
				}
			}
			
			code.add(line);
			//System.out.println(line_num);
			line_num++;
		}
		System.out.println("COMPILED");
		
		//EXECUTING CODE
		boolean flag = true;
		int line_Exec = 0;
		while(line_Exec>=0 && line_Exec < code.size()){
			line_Exec = Execute(code.get(line_Exec),line_Exec);
		}
		System.out.println("EXECUTED");
	}
}