package d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;

public class Teacher extends Employee implements Orders {
	public Teacher(String name, String surname, Integer salary,Rank rank,EducationDegree degree,Faculty f) {
		super(name, surname, salary);
		library = new Vector<MyFiles>();
		rating  = 0;
		this.rank = rank;
		this.degree  =degree;

		faculty = f;
	}
	Faculty faculty;
	 int rating;
	 Rank rank;
	 EducationDegree degree;
	public MyFiles syllabus = null;
	 Vector<MyFiles> library;	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public void deleteFiles(int index) {
		library.remove(index);
	}
	public Vector<Course> viewCourses() {
		Vector<Course> courses = new Vector<Course>();
		for (Student s: Admin.getInstance().allStudents) {
			for (HashMap.Entry<Course,Teacher> entry : s.teachers.entrySet())
			{
			   if(entry.getValue().equals(this)) courses.add(entry.getKey());			}
		}
		return courses;
	}
	public void addFiles(MyFiles f) {
		library.add(f);
	}
	public MyFiles getSyllabus() {
	   return syllabus;
	}
	public void setSyllabus(MyFiles syllabus) {
		this.syllabus = syllabus;
	}
	public void putMark(Course c,Student s,Integer i) {
		Mark m =s.Courses.get(c);
		if(m.lastPutMark.equals("")) m.setAttestation1(i);
		else if(m.lastPutMark.equals("attestation1")) m.setAttestation2(i);
		else if(m.lastPutMark.equals("attestation2")) m.setFnal(i);
	}

	public Vector<Student> viewStudents(Course c) {
		Vector<Student> v = new Vector<Student>();
		//if(v!=null)
		for(Student s:Admin.getInstance().allStudents) {
			if(s.teachers.get(c).equals(this)) v.add(s);
		}
		return v;
	}
	@Override
	public int compareTo(Object arg0) {
		Teacher t = (Teacher)arg0;
		return salary.compareTo(t.salary);
	}
	
	@Override
	public void sendOrder(Order o) {
		Admin.getInstance().allOrders.add(o);
		
	}
	public String toString() {
		return "Teacher:"+super.toString()+
				"\nDegree:"+degree+"\nRank: "+rank+"\nRating: "+rating;
		
	}
	public int getSalary() {
		salary=salary+salary*rating/100;
		return salary;
	}

}