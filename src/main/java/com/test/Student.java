package com.test;

public class Student {
	
	private int sId;
	private String sName;
	private String department;
	private float marks;
	
	private Student(StudentBuilder builder){
		sId = builder.sId;
		sName = builder.sName;
		department = builder.department;
		marks = builder.marks;
	}
	
	static class StudentBuilder{
		
		private int sId;
		private String sName;
		private String department;
		private float marks;
		
		public StudentBuilder sId(int sId){
			this.sId = sId;
			return this;
		}
		
		public StudentBuilder sName(String sName){
			this.sName = sName;
			return this;
		}
		
		public StudentBuilder department(String department){
			this.department = department;
			return this;
		}
		
		public StudentBuilder marks(float marks){
			this.marks = marks;
			return this;
		}
		
		public Student build(){
			return new Student(this);
		}
		
	}
	
	public static void main(String args[]){
		Student student = new Student.StudentBuilder()
				.sId(10).sName("Parveen")
				.build();
		
		System.out.println(student);
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", department=" + department + ", marks=" + marks + "]";
	}

	
}
