package com.test;

class StringPermutation
{
	
	public static void main (String[] args)
	{
		String str = "ABC";
		String answer="";
		
		permute(str,answer);
		
        /*String sortedStr = sortString(str);
        permutation("",sortedStr);*/ 
       
	}

	private static void permute(String s, String answer) {
		if (s.length() == 0)
	    {
	        System.out.print(answer + "  ");
	        return;
	    }
	     
	    for(int i = 0 ;i < s.length(); i++)
	    {
	        char ch = s.charAt(i);
	        String left_substr = s.substring(0, i);
	        String right_substr = s.substring(i + 1);
	        String rest = left_substr + right_substr;
	        permute(rest, answer + ch);
	    }
	}
	 
	 // Method to sort a string alphabetically 
    /*public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) 
        	System.out.print(prefix+" ");
        else {
            for (int i = 0; i < n; i++){
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }
    }*/
}