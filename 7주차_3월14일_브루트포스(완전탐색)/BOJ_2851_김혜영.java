import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851_슈퍼마리오 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int[] arr = new int[10];  
	    for(int i=0; i<arr.length; i++) {
	    	   arr[i] = Integer.parseInt(br.readLine());
	       }
	    
	    int sum=0;
	    
	    for(int i=0; i<arr.length; i++){
		    if(sum<=100 && 100<sum+arr[i]) {
		    	if(100-sum >= sum+arr[i]-100) {
		    		sum=sum+arr[i];
		    		System.out.println(sum);
		    		System.exit(0);
		    	}else {
		    		System.out.println(sum);
		    		System.exit(0);
		    	}
		    }else{
		    	sum+=arr[i];
		    }
	    }
	    System.out.println(sum);
	}
}
