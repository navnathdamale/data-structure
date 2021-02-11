package com.java.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class TestEqualAndHashCode {
	public static void main(String[] args) {
		Student s1 = new Student(12, "ABC");
		Student s2 = new Student(12, "ABC");

		//System.out.println("EQUALITY ==>>" + s1.equals(s2));

		Map<Student, String> hashMap = new HashMap<>();
		hashMap.put(s1, "NAVNATH"); // 1 bucket
		hashMap.put(s2, "DAMALE"); // 1 bucket
		//System.out.println(hashMap.get(s1));
		
		String someString = "This specification does not indicate the behavior, rendering or otherwise, of space characters other than those explicitly identified here as white space characters. For this reason, authors should use appropriate elements and styles to achieve visual formatting effects that involve white space, rather than space characters.For all HTML elements except PRE, sequences of white space separate 'words' (we use the term 'word' here to mean 'sequences of non-white space characters'). When formatting text, user agents should identify these words and lay them out according to the conventions of the particular written language (script) and target medium.";
		long count = someString.chars().count();
		System.out.println(count);
		
	}
}

class Student {	
	private int age;
	private String name;

	public Student() {
	}

	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student";
	}

}