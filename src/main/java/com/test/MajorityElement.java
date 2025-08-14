package com.test;

public class MajorityElement {
	
	public static void main(String args[]){
		
		int[] arr = {3,5,3,5,3,5,3,5,3};
		
		System.out.println(majority(arr));
	}
	
	public static int majority(int[] ar){
	    
	    int majority=ar[0];
	    int count=1;
	    for(int i=1;i<ar.length;i++){
	        if(ar[i]==majority){
	            count++;
	        }
	        else{
	            count--;
	        }
	        if(count==0){
	            majority=ar[i];
	            count=1;
	        }
	    }
	    
	    
	    count=0;
	    for(int i=0;i<ar.length;i++){
	        if(ar[i]==majority){
	            count++;
	        }
	    }
	    if(count>ar.length/2){
	        return majority;
	    }
	    
	    return -1;
	}

}
