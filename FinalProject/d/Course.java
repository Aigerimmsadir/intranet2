package d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;


public class Course implements Comparable, Cloneable, Serializable {
	
	ArrayList<MyFiles> files = new ArrayList<MyFiles>();
//	ArrayList<Student> students = new ArrayList<Student>();
	private Integer credits;
	private Faculty faculty;
	private String name;
	
	Vector<Teacher> teachers = new Vector<Teacher>();
	//public Teacher teacher;
	public Course(String name, Faculty faculty,int credits) {
		this.name = name;
		this.faculty = faculty;
		this.credits = credits;
		teachers = new Vector<Teacher>();
	}


/*	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Faculty getFaculty() {
		return faculty;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public String toString() {
		String b= "Course name: "+ name+" ,number of credits: "+credits;
		return b;
	}

	public boolean equals(Object o) {
		Course c = (Course)o;
		if(this.faculty.equals(c.getFaculty()) && this.name.equals(c.name) && 
				 this.credits.equals(c.getCredits())) return true;
		return false;
	}

	/*public ArrayList<Student> getStudents(String id) {
		return students;
	}

	public void addStudent(Student s) {
		students.add(s);
	}
	*/
	public void addFile(Textbook textbook) {
		files.add(textbook);
	}

	@Override
	public int compareTo(Object arg0) {//по количеству студентов
		Course c = (Course)arg0;
		return this.credits.compareTo(c.credits);
	}
}


