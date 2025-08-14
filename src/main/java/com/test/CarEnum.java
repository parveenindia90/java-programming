package com.test;

public enum CarEnum {
   lamborghini(900),tata(2),audi(50),fiat(15),honda(12);
   private int price;
   
   CarEnum(int p) {
	  
      price = p;
   }
   int getPrice() {
      return price;
   } 
}
