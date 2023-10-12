import java.util.*;
import java.io.*;

// BJ #
// Strategy: 

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String id = br.readLine();
        
        for(int i=0;i<3;i++) {
        	for(int j=0;j<3;j++) {
        		if(i==1 && j==1) {
        			System.out.print(":"+id+":");
        		}else {
        			System.out.print(":fan:");
        		}
        	}
        	System.out.println();
        }
	}
}