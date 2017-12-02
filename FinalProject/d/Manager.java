package d;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;


public class Manager extends Employee implements Orders { 
	static HashMap<Student,Course> registration=new  HashMap<Student,Course>();
	public Manager(String name, String surname, Integer salary, ManagerTypes type) {
		super(name, surname, salary);
		this.type = type;
	
	}
	private ManagerTypes type;
	
	public String  writeReport(Course c) {
		HashMap<String,Integer> frequency =  new HashMap<String,Integer>();
		String s ="";
		for(Student st: Admin.getInstance().allStudents) {
			if(st.Courses.keySet().contains(c)) {
				Mark m = st.Courses.get(c);
				if(frequency.containsKey(m.getLetter())){
					frequency.put(m.getLetter(),frequency.get(m.getLetter())+1);
				}
				else frequency.put(m.getLetter(),1);
			}
		}
		for (HashMap.Entry<String,Integer> entry : frequency.entrySet())
		{
			s = entry.getKey()+"     "+entry.getValue()+"\n";
		}
		
		return s;
	}
	public static boolean approveStudentRegistration(Student s) {
		
	/*	for (HashMap.Entry<Student,Course> entry : registration.entrySet())
		{
		   	Student s = entry.getKey();
		   	if(s.gpa<2 && s.Courses.size()>=4) {
		   		s.teachers.remove(entry.getValue());
		   		s.Courses.remove(entry.getValue());
		   		s.numOfCredits=s.numOfCredits-entry.getValue().getCredits();
		   	}
		}
		registration.clear();*/
		if(s.gpa<2 && s.Courses.size()>=4)
		return false;
		return true;
		
	}
	public void assignCourseToTeacher(Course c,Teacher t) {
		c.teachers.add(t);
	}
	public boolean checkSyllabus(Teacher t) {
		if(type == ManagerTypes.OR)
		if(t.syllabus!=null) return true;
		return false;
	}
	
	public boolean checkMarkTime(Student s) throws ParseException {
		boolean inTime=true;
		if(type == ManagerTypes.OR) {
		
				HashMap<Course,Teacher> map =s.teachers;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				 Date d1;
						for (Entry<Course, Teacher> entry : map.entrySet())
						{
						    if(Login.semester.equals("Fall") ) {
						    	d1 = sdf.parse("2017-12-20");
						    	Mark temp = s.Courses.get(entry.getKey());
						    	if(d1.compareTo(temp.getTimeOfPutting())<0) {
						    		inTime=false;
						    		System.out.println("Teacher "+entry.getValue().toString()+
						    		" didn't put mark in time for course "+ entry.getKey().getName());
						    	}
						    }
						    else{
						    	d1 = sdf.parse("2018-06-01");
						    	Mark temp = s.Courses.get(entry.getKey());
						    	if(d1.compareTo(temp.getTimeOfPutting())<0) {
						    		inTime=false;
						    		System.out.println("Teacher "+entry.getValue().toString()+
						    		" didn't put mark in time for course "+ entry.getKey().getName());
						    	}
						    }
						}
			}
	    return inTime;
	}
	public void writeDepartmentNews(String news,String content) {
		Announcement an = new Announcement(news,content,this);
		Admin.getInstance().allAnnouncements.add(an);
	}
	
	@Override
	public int compareTo(Object o) {
		Manager m = (Manager )o;
		return salary.compareTo(m.getSalary());
	}
	@Override

	public void sendOrder(Order o) {
		Admin.getInstance().allOrders.add(o);
		
	}
}

