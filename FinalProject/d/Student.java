package d;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

public class Student extends User {
	int yearOfStudy;
	Double gpa;
	Specialization specialization;
	Transcript transcript;
	HashMap<Course, Mark> Courses;
	HashMap<Course, Teacher> teachers;
	int numOfCredits;
	public boolean grant;

	public Student(String n, String s, double gpa, Specialization specialization, boolean grant, int year) {
		super(n, s);
		this.grant = grant;
		login = Character.toLowerCase(name.toCharArray()[0]) + "_" + surname.toLowerCase();
		Courses = new HashMap<Course, Mark>();
		teachers = new HashMap<Course, Teacher>();
		yearOfStudy = year;
		this.specialization = specialization;
	}



	/*
	 * public static getStudents(Course c) { Vector<Student> studs = new
	 * Vector<Student>(); for(Student s : Admin.allStudents)
	 * if(s.Courses.keySet().contains(c)) studs.add(s);
	 * 
	 * }
	 */
	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Double getGpa() {
		return gpa;
	}
	public void rateTeacher(Teacher t,int rating) {
		t.setRating(rating);
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public int getNumOfCredits() {
		return numOfCredits;
	}

	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}

	public String viewMarks() {
		String s = "";
		s += ("Marks of the student " + super.toString());
		for (Entry<Course, Mark> entry : Courses.entrySet()) {
			s = s + "\n" + (entry.getKey() + ":" + entry.getValue());
		}
		return s;

	}

	public void addCourse(Course c, Teacher t) {
		if (c.getFaculty().specializations.contains(this.specialization)) {
			Courses.put(c, new Mark());
			teachers.put(c, t);
		}
	}

	@Override
	public boolean equals(Object obj) {

		Student other = (Student) obj;
		if (super.equals(obj)) {
			if (gpa == other.getGpa() && specialization.equals(other.getSpecialization())
					&& Courses.equals(other.Courses))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		return gpa.compareTo(s.getGpa());
	}

	public String toString() {
		String s="Student: "+super.toString()+", specialization: "+
				specialization+", year of study: "+yearOfStudy;
		return s;
	}

	public String viewCourses() {
		String s = "";
		for (Entry<Course, Teacher> entry : teachers.entrySet()) {
			s = s + "\n" + (entry.getKey() + "  -   " + entry.getValue());
		}
		return s;
	}
}