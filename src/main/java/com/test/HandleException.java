package com.test;

public class HandleException
{
	
	 public static void main(String args[]){
		  try{
			  CustomException customException = new CustomException();
			  customException.process();
		  }
		 catch(MyException e){
			 System.out.println(e.getMessage());
		 }
	 }

}
class CustomException{
	public void process() throws MyException{
	  try{
		  
	       throw new MyException("Some Exception");
	       // throw is used to create a new exception and throw it.
	  }
	 catch(MyException e){
		 throw new MyException(e.getMessage());
	 }
	}
}

class MyException extends Exception{
   
   public MyException(String errorMessage) {
		super(errorMessage);
	}
   
}