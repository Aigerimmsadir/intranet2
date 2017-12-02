package d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Transcript implements Serializable, Cloneable,Comparable {
    Double overallgpa;
    int allcredits;
    HashMap< Integer,HashMap<Course,Mark> > semesters = new HashMap< Integer,HashMap<Course,Mark> >();
	public double getOverallgpa() {
	    return this.overallgpa;
	}
	public void addMark(Integer semester,Course c,Mark mark) {
		semesters.get(semester).put(c, mark);
		allcredits = allcredits+c.getCredits();
		calculateGpa();
	}
	public void calculateGpa() {
		int numOfCourses=0;
		double ov=0;
		for(int i=1;i<=semesters.size();i++) {
			for (HashMap.Entry<Course,Mark> entry : semesters.get(i).entrySet())
			{
				numOfCourses++;
			    ov+=entry.getValue().getGpa();
			}
		}
		overallgpa = ov/numOfCourses;
	}
	@Override
	public int compareTo(Object arg0) {
		Transcript tt = (Transcript) arg0;
		return overallgpa.compareTo(tt.getOverallgpa());
	}
	public String toString() {
		String s = "";
		for(int i=1;i<=semesters.size();i++) {
			s =s+"Marks of semester "+(i+1)+"\n";
			for (HashMap.Entry<Course,Mark> entry : semesters.get(i).entrySet())
			{
			    s=s+(entry.getKey() + "-" + entry.getValue().markWithLetter())+"\n";
			}
		}
		return s;
	}
}

