package com.test;

public enum SingletonEnum {

	INSTANCE;
	
	int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}


class SingletonEnumDemo{
	public static void main(String args[]) {
		SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
		
		System.out.println(singletonEnum.getValue());
	}
}