import java.util.*;
import java.io.*;

// BJ #1152
public class Main {
	public static void main(String[] args) throws Exception{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        
        String[] arr = sc.nextLine().trim().split(" ");
       
        if(arr[0].equals("")) {
        	System.out.println(arr.length-1);
        }else {
        	System.out.println(arr.length);
        } 
	}
}