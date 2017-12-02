package d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;


public class Faculty implements Comparable, Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	 Vector<Teacher> teachers;
	 Vector<Specialization> specializations;
	// Vector<Course> allCourses;
	public Faculty(String name) {
		this.name = name;
		teachers = new  Vector<Teacher>();
		specializations = new Vector<Specialization>();
		
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addTeacher(Teacher teacher) { 
		teachers.add(teacher);
	}

	
	public int compareTo(Object o) {
		Faculty f = (Faculty)o;
		Integer i1 = teachers.size();
		Integer i2  = f.teachers.size();
		return i1.compareTo(i2);
	}

	public String toString() {
		return "Faculty name: " + name + "\nTeachers: " + teachers.size() + "\nCourses: "  + 
				"\nSpecialization: " + specializations.size();
	}

	public boolean equals(Object o) {
		Faculty f = (Faculty) o;
		if(name.equals(f.getName()) && teachers.equals(f.teachers) 
				&& specializations.equals(f.specializations)) return true;
		return false;
				
	}

	
}


