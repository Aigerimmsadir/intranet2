package d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static // Admin Mode

	Faculty selectFaculty() throws NumberFormatException, IOException {
		int i = 0;
		for (Faculty f : Admin.getInstance().allFaculties) {
			i++;
			System.out.println(i + " " + f.name);
		}
		int faculch = Integer.parseInt(br.readLine());
	
		Faculty f = Admin.getInstance().allFaculties.get(faculch - 1);
		return f;
	}

	static void addStudent() throws IOException {
		while (true) {
			System.out.println("Enter new student's full name(first name and last name):");
			String name = br.readLine();
			String surname = br.readLine();

			System.out.println("Select student's faculty:");
			for (int i = 0; i < Admin.getInstance().getInstance().allFaculties.size(); i++) {
				System.out.println((i + 1) + ") " + Admin.getInstance().allFaculties.get(i).toString());
			}
			Faculty f = Admin.getInstance().allFaculties.get(Integer.parseInt(br.readLine()) - 1);
			System.out.println("Select student's specialization:");
			for (int j = 0; j < f.specializations.size(); j++) {
				System.out.println((j + 1) + ") " + f.specializations.get(j).toString());
			}
			Specialization s = f.specializations.get(Integer.parseInt(br.readLine()) - 1);
			System.out.println("Does student have grant?\n1 - yes\n2 - no");
	
			int answer = Integer.parseInt(br.readLine());
			boolean grant;
			if (answer == 1)
				grant = true;
			else
				grant = false;
			System.out.println("Is this new student?\n1 - yes\n2 - no");
			int opt = Integer.parseInt(br.readLine());
			Student student;
			if (opt == 2) {
				System.out.println("Please enter student's total gpa:");
				double gpa = Double.parseDouble(br.readLine());
				System.out.println("Please enter student's year of study");
				int year = Integer.parseInt(br.readLine());
				student = new Student(name, surname, gpa, s, grant, year);
			} else {
				student = new Student(name, surname,0, s, grant,1);
			}
			if(Admin.getInstance().addStudent(student)) 
				System.out.println("Student "+student.getFullName()+" was seccuesfully added");
			else System.out.println("Student "+student.getFullName()+" is already added");
			System.out.println("Tap 1 to add another student\nTap 2 to do another operarion");
			int operation = Integer.parseInt(br.readLine());
			if (operation == 2)
				break;
		}
	}

	static void addTeacher() throws IOException {
		while (true) {
			System.out.println("Enter new teacher's full name(first name and last name):");
			String name = br.readLine();
			String surname = br.readLine();
			System.out.println("Enter teacher's salary:");
			int salary = Integer.parseInt(br.readLine());
			System.out.println("Enter teacher's rank:");
			for (int i = 0; i < Rank.values().length; i++) {
				System.out.println((i + 1) + ") " + Rank.values()[i]);
			}
			Rank rank = Rank.values()[Integer.parseInt(br.readLine()) - 1];
			System.out.println("Enter teacher's education degree:");
			for (int i = 0; i < EducationDegree.values().length; i++) {
				System.out.println((i + 1) + ") " + EducationDegree.values()[i]);
			}
			EducationDegree degree = EducationDegree.values()[Integer.parseInt(br.readLine()) - 1];
			System.out.println("Select teacher's faculty:");
			
			Faculty f = selectFaculty();
			Teacher teacher = new Teacher(name, surname, salary, rank, degree, f);
			if(Admin.getInstance().addTeacher(teacher))
				System.out.println("Teacher "+teacher.getFullName()+" was succesfully added!");
			else System.out.println("Teacher "+teacher.getFullName()+"is alredy added");
			System.out.println("Tap 1 to add another teacher\nTap 2 to do another operarion");
			int operation = Integer.parseInt(br.readLine());
			if (operation == 2)
				break;
		}
	}

	static void addManager() throws IOException {
		while (true) {
			System.out.println("Enter new managers's full name(first name and last name):");
			String name = br.readLine();
			String surname = br.readLine();
			System.out.println("Enter manager's salary:");
			int salary = Integer.parseInt(br.readLine());
			System.out.println("Enter manager's office:");
			for (int i = 0; i < ManagerTypes.values().length; i++) {
				System.out.println((i + 1) + ") " + ManagerTypes.values()[i]);
			}
			ManagerTypes type = ManagerTypes.values()[Integer.parseInt(br.readLine()) - 1];
			Manager manager = new Manager(name, surname, salary, type);
			if (!Admin.getInstance().addManager(manager)) 
				System.out.println("Manager "+manager.getFullName()+" was succesfully added!");
			else System.out.println("Manager "+manager.getFullName()+"is alredy added");
			System.out.println("Tap 1 to add another manager\nTap 2 to do another operarion");
			int operation = Integer.parseInt(br.readLine());
			if (operation == 2)
				break;
		}
	}

	static void addExecutor() throws IOException {
		while (true) {
			System.out.println("Enter new executor's full name(first name and last name):");
			String name = br.readLine();
			String surname = br.readLine();
			System.out.println("Enter executor's salary:");
			int salary = Integer.parseInt(br.readLine());
			Executor executor = new Executor(name, surname, salary);
			if (!Admin.getInstance().addExecutor(executor)) 
				System.out.println("Executor "+executor.getFullName()+" was succesfully added!");
			else System.out.println("Executor "+executor.getFullName()+"is alredy added");
			
			System.out.println("Tap 1 to add another executor\nTap 2 to do another operarion");
			int operation = Integer.parseInt(br.readLine());
			if (operation == 2)
				break;
		}
	}

	static void addCourse() throws IOException {
		while (true) {
			System.out.println("Enter new course's name:");
			String name = br.readLine();
			System.out.println("Select faculty from the list below");
			
			Faculty f =selectFaculty();
			System.out.println("Enter number of credits of this course:");
			int credits = Integer.parseInt(br.readLine());
			Course course = new Course(name, f, credits);
			System.out.println("Select teachers of this course:");
			for (int i = 0; i < Admin.getInstance().allTeachers.size(); i++) {
				System.out.println((i + 1) + Admin.getInstance().allTeachers.get(i).getFullName());
			}
			Integer inp = null;

			while (true) {
				System.out.println("Select teacher or tap 0 to end input");
				inp = Integer.parseInt(br.readLine());
				if (inp == 0)
					break;
				Teacher t = Admin.getInstance().allTeachers.get(inp - 1);
				if(!course.teachers.contains(t)) course.teachers.add(t);
			}

			if (!Admin.getInstance().allCourses.contains(course)) {
				Admin.getInstance().allCourses.add(course);
				System.out.println("Course " + name + " was succesfully added.");
			} else
				System.out.println("This course is already added");
			System.out.println("Tap 1 to add another course\nTap 2 to do another operarion");
			int operation = Integer.parseInt(br.readLine());
			if (operation == 2)
				break;

		}
	}

	static void addTextbook() throws IOException {
		while (true) {
			System.out.println("Enter new textbook's name and it's format:");
			String name = br.readLine();
			String format = br.readLine();
			System.out.println("Enter new textbook's ISBN");
			String ISBN = br.readLine();
			System.out.println("Enter new textbook's author");
			String author = br.readLine();
			Textbook textbook = new Textbook(name, format, ISBN, author);
			if (!Admin.getInstance().allTextbooks.contains(textbook)) {
				Admin.getInstance().allTextbooks.add(textbook);
				System.out.println("Textbook " + name + " was succesfully added.");
			} else
				System.out.println("This textbook is already added");
			System.out.println("Tap 1 to add another course\nTap 2 to do another operarion");
			int operation = Integer.parseInt(br.readLine());
			if (operation == 2)
				break;
		}
	}

	// Student mode
	static void ViewCourses(Student s) throws NumberFormatException, IOException {
		
		System.out.println("Below is a list of courses of student " + s.toString());
		System.out.println(s.viewCourses());
		//System.out.println(s.teachers.size());

	}
	static void viewCourseTextbooks(Student s) throws NumberFormatException, IOException {
		int i=0;
		Vector<Course > courses = new Vector<Course >();
		for (Entry<Course, Teacher> entry : s.teachers.entrySet()) {
			i++;
			System.out.println(i+ ") "+entry.getKey());
			courses.add(entry.getKey());
		}
		System.out.println("Select course:");
		int ch = Integer.parseInt(br.readLine());
		Course c = courses.get(i-1);
		ViewCourseTextbooks( c);
	}
	static void ViewCourseTextbooks(Course c) throws NumberFormatException, IOException {
		System.out.println("Textbooks and files of the course " + c.getName());
		Integer choice = 16000;
		while (true) {
			System.out.println("Tap index of the file or 0 to exit from ViewFileMenu");
			for (int i = 0; i < c.files.size(); i++) {
				System.out.println((i + 1) + ") " + c.files.get(i));
			}
			choice = Integer.parseInt(br.readLine());
			if (choice == 0)
				break;
			File file = c.files.get(choice - 1).file;
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s = "", line = null;
			while ((line = in.readLine()) != null) {
				s = s + "\n" + line;
			}
			System.out.println(s);
		}
	}

	static void RegisterForCourse(Student s) throws NumberFormatException, IOException {
		Vector<Course> registered = new Vector<Course>();
		int credits = 0;
		System.out.println("Name of student: "+ s.getFullName());
		System.out.println("Below is a list of available courses:");
		for (int i = 0; i < Admin.getInstance().allCourses.size(); i++) {
			System.out.println((i + 1) + ") " + Admin.getInstance().allCourses.get(i));
		}
		while (true) {
			System.out.println("Select course to register or tap 0 to exit from registration menu");
			int choice = Integer.parseInt(br.readLine());
			if (choice == 0)
				break;
			Course c = Admin.getInstance().allCourses.get(choice - 1);
			 if(c.getFaculty().specializations.contains(s.getSpecialization()) &&
			s.numOfCredits + c.getCredits() <= 21) {

				System.out.println("Selected course is: " + c.getName());
				System.out.println("Now select teacher of the course:");
				for (int i = 0; i < c.teachers.size(); i++) {
					System.out.println((i + 1) + ") " + c.teachers.get(i).getFullName());
				}

				int teacherChoise = Integer.parseInt(br.readLine());
				if (teacherChoise == 0)
					break;
				Teacher t = c.teachers.get(teacherChoise - 1);
		
				//&& Manager.approveStudentRegistration(s)
					if(!s.Courses.containsKey(c) 	) {
				//	Admin.getInstance().allCourses.remove(c);
					s.Courses.put(c, new Mark());
					s.teachers.put(c, t);	
					s.numOfCredits = s.numOfCredits + c.getCredits();
					
					//Admin.getInstance().allCourses.add(c);
					System.out.println("Course has been added");
				}
	
				
				else {
					System.out.println("You cannot register to the course " + c.getName());
				}
		}
			 if(s.numOfCredits==21) break;
		}
	}

	static void viewStudentMarks(Student s) {
		System.out.println(s.viewMarks());
	}

	static void viewStudentTranscript(Student s) {
		System.out.println(s + "\nTranscript:");
		System.out.println(s.transcript);
	}

	static void ViewTeachersAndRate(Student s) throws NumberFormatException, IOException {
		System.out.println("Below is a list of teachers :");
		int i = 0;
		Vector<Teacher> v = new Vector<Teacher>();
				v.addAll(s.teachers.values());
		Integer choice = null;
		while (true) {
			System.out.println(" Select teacher to rate or tap 0 to exit");
			for (Teacher t : v) {
				i++;
				System.out.println(i + " " + t.getFullName());
			}

			choice = Integer.parseInt(br.readLine());
			if (choice == 0)
				break;
			Teacher t = v.get(choice - 1);		
		//	Admin.getInstance().allTeachers.remove(t);

			System.out.println(t);
			System.out.println(" Please rate teacher from 0 to 100");
			int rating = Integer.parseInt(br.readLine());
			s.rateTeacher(t, rating);
		//	Admin.getInstance().allTeachers.add(t);
		}
	}


	// Teacher mode
	static void viewCourses(Teacher t) {
		Vector<Course> v = t.viewCourses();
		System.out.println("Below is all courses of teacher " + t.getFullName());
		for (Course c : v) {
			System.out.println(c.getName());
		}
	}

	static void manageCourseFiles(Teacher t) throws NumberFormatException, IOException {
		Integer filech = null;
		while (filech != 0) {
			System.out.println("Tap 1 to add new files \nTap2 to delete files");

			filech = Integer.parseInt(br.readLine());
			if (filech == 1) {
				System.out.println("Please enter file's name and format ");
				String filename = br.readLine();

				File f = new File(filename);
				if (f.createNewFile()) {
					MyFiles doc = new MyFiles(f);
					if (filename.equals("syllabus.txt") || filename.equals("Syllabus")) {
						t.setSyllabus(doc);
						System.out.println("Syllabus was successfully added!");
					} else {
						t.addFiles(doc);
						System.out.println("File was successfully added!");
					}
				}
			} else if (filech == 2) {
				int h = 0;
				System.out.println("Select file to delete:");
				for (MyFiles mf : t.library) {
					h++;
					System.out.println(h + ")" + mf);
				}
				int delch = Integer.parseInt(br.readLine());
				// t.library.remove(delch-1);
				t.deleteFiles(delch - 1);
				System.out.println("File " + t.library.get(delch - 1) + " was succesfully deleted");
			} else
				break;
		}
	}

	static void putMarks(Teacher t) throws NumberFormatException, IOException {
		viewCourses(t);
		Vector<Course> v = t.viewCourses();
		
		while (true) {	
			int i=0;
			System.out.println("Select course: ");
			for(Course c1:v) {
				i++;
				System.out.println(i+"  "+c1.getName());
			}
			int h = Integer.parseInt(br.readLine());
			if(h==0) break;
			Integer studch = 1600;
			Course c = v.get(h - 1);
			viewStudents(t, c);
			Vector<Student> vs = t.viewStudents(c);
			System.out.println("Select student or tap 0 to exit Marks Menu");
			studch = Integer.parseInt(br.readLine());
			if (studch == 0)
				break;
			Student s = vs.get(studch - 1);
			System.out.println("Selected student is: " + s.getFullName() + "\nNow enter the mark:");
			int m = Integer.parseInt(br.readLine());
			t.putMark(c, s, m);
			System.out.println("Mark was put succesfully!");
		}
	}
	static Course getCoursesOfTeacher(Teacher t) throws NumberFormatException, IOException {
		Vector<Course> v = new Vector<Course>();
		int i=0;
		for(Course c:Admin.getInstance().allCourses) {
			if(c.teachers.contains(t)) {
				v.add(c);
				i++;
				System.out.println(i+" "+c.getName());
			}
		}
		int ch = Integer.parseInt(br.readLine());
		Course c = v.get(ch-1);
		return c;
	
	}
	static void viewStudents(Teacher t, Course c) {
		Vector<Student> v = t.viewStudents(c);
		int i=0;
		System.out.println("Below is list of all students of the course : " + c.getName());
		for (Student s : v) {
			i++;
			System.out.println(i+" "+s.getFullName());
		}
	}

	// Manager mode
	static void assignCourseToTeacher(Manager m) throws NumberFormatException, IOException {
		
		System.out.println("Select faculty of the course or tap 0 to exit");
		while (true) {
			System.out.println("Select faculty of the course or tap 0 to exit");
			int i = 0;
			for (Faculty f : Admin.getInstance().allFaculties) {
				i++;
				System.out.println(i + " " + f.name);
			}
			int faculch = Integer.parseInt(br.readLine());
			if (faculch == 0)
				break;
			i = 0;
			Faculty f = Admin.getInstance().allFaculties.get(faculch - 1);

			for (Course c : Admin.getInstance().allCourses) {
				if (c.getFaculty().equals(f)) {
					i++;
					System.out.println(i + " " + c.getName());
				}
			}
			System.out.println("Select the course or tap 0 to exit");
			faculch = Integer.parseInt(br.readLine());
			Course c = Admin.getInstance().allCourses.get(faculch - 1);
			System.out.println("Selected course is: " + c + "\nNow select the teacher to assign");
			i = 0;
			for (Teacher t : Admin.getInstance().allTeachers) {
				if (t.faculty.equals(f)) {
					i++;
					System.out.println(t.getFullName());
				}
			}
			faculch = Integer.parseInt(br.readLine());
			if (faculch == 0)
				break;
			Teacher t = Admin.getInstance().allTeachers.get(faculch - 1);
			m.assignCourseToTeacher(c, t);
			System.out.println("Teacher " + t.getFullName() + " was assigned to the course " + c.getName());
		}
	}


	static void printAcademicReport(Manager m) {
		for (Course c : Admin.getInstance().allCourses) {
			System.out.println("Academic report for the course " + c.getName());
			System.out.println(m.writeReport(c));
		}
	}

	static void writeDepartmentNews(Manager m) throws IOException {
		System.out.println("Enter announcement title: ");
		String title = br.readLine();
		String content = "";
		System.out.println("Write content.At the end of the input enter END");
		while (true) {
			String cc = br.readLine();
			if (!cc.equals("END")) {
				content = content + cc + "\n";
			} else
				break;
		}
		m.writeDepartmentNews(title, content);
		System.out.println("Announcement was added!");
	}
	// Executor mode

	static void viewAcceptedOrders(Executor e) throws NumberFormatException, IOException, InterruptedException {
		System.out.println("Below are list of accepted orders:");
		System.out.println(e.viewAcceptedOrders());
		Integer choice = null;
		while (true) {
			System.out.println("Select order or tap 0 to exit menu");
			choice = Integer.parseInt(br.readLine());
			if (choice == 0)
				break;
			Order o = Admin.getInstance().allOrders.get(choice - 1);
			if (e.acceptOrder(o)) {
				System.out.println("Order " + o.toString() + " is accepted");
				Thread.sleep(5000);
				System.out.println("Order " + o.toString() + " is done");
				e.addExecutedOrder(o);
			} else {
				System.out.println("Order " + o.toString() + " is not accepted");
			}
		}

	}
	static void viewAnnouncements() throws NumberFormatException, IOException {
		int i=0;
		LocalDateTime ld =LocalDateTime.now();
		System.out.println("Announcements:  	      Date: "+ld);
		for(Announcement a:Admin.getInstance().allAnnouncements) {
			i++;
			System.out.println(i+") "+ a.getTitle());
			System.out.println(a.content+"\n");
		}
		
		Integer ch=null;
		while(true) {
			System.out.println("Select announcement is you want to write comment or tap 0 to exit");
				ch = Integer.parseInt(br.readLine());
				if(ch==0) break;
				Announcement a=Admin.getInstance().allAnnouncements.get(ch-1);
				System.out.println(a.comments.size()+" comments :");
				for(String s:a.comments) {
					System.out.println(s);
				}
				System.out.println("Write:");
				String comment = "";
				while (true) {
					String cc = br.readLine();
					if (!cc.equals("END")) {
						comment = comment + cc + "\n";
					} else
						break;
				}
				a.comments.add(comment);
		}
	
	}
	//general mode
	static String admin = "root";
	static String pass = "me";
	static void viewLibrary() {
		System.out.println("Below is a list of books available in the Library");
		for(Textbook t:Admin.getInstance().allTextbooks) {
			System.out.println(t);
		}
	}
	public static void main(String[] args) throws IOException, 
			ClassNotFoundException, NumberFormatException, InterruptedException {
		Admin.getInstance().initializeObjects();
		addCourse();
		Specialization s = new Specialization("IS");
		Admin.getInstance().allFaculties.get(0).specializations.add(s);
		addStudent();
		for(Student sq: Admin.getInstance().allStudents)
			RegisterForCourse(sq);
		Teacher t = Admin.getInstance().allTeachers.get(0);
		putMarks(t);
		
		Admin.getInstance().serializeUser();
/*		System.out.println("Welcome!");
		menu: while (true) {
			System.out.println("Please enter login and password:");
			String login = br.readLine();
			String password = br.readLine();
			//usermodes
			if(Admin.getInstance().allPasswords.containsKey(login)&&
					password.hashCode()==Admin.getInstance().allPasswords.get(login)) {
				viewAnnouncements();
				if(Login.recognizeUser(login).equals("Student")) {

					Student s = Login.recognizeStudent(login);
					while(true) {
						System.out.println("Tap 1 to view all courses\n"
							+ "Tap 2 to view textbooks of the course\nTap 3 to view marks"
							+ " of current semester\nTap 4 to view teachers and rate"
							+ "\nTap 5 to register on courses\nTap 0 to exit");
						int stch = Integer.parseInt(br.readLine());
						if(stch==1) ViewCourses(s);
						else if(stch==2) viewCourseTextbooks(s);
						else if(stch==3) viewStudentMarks(s);
						else if(stch==4) ViewTeachersAndRate(s);
						else if(stch==4) RegisterForCourse(s);
						else if(stch==0) break;
					}
				}
				else if(Login.recognizeUser(login).equals("Teacher")) {
		
					Teacher t  = Login.recognizeTeacher(login);
					System.out.println("Tap 1 to view my courses\nTap 2 to manage files "
							+"of the courses\nTap 3 to view students of the course\nTap 4 to "
							+"put marks to students \nTap 0 to exit");
					int stch = Integer.parseInt(br.readLine());
					if(stch==1) viewCourses(t);
					else if(stch==2) manageCourseFiles(t);
					else if(stch==3) {
						viewStudents(t, getCoursesOfTeacher( t));
					}
					else if(stch==4) putMarks(t);
					else if(stch==0) break;
				}
				else if(Login.recognizeUser(login).equals("Manager")) {
					Manager m = Login.recognizeManager(login);
					System.out.println("Tap 1 assign course to teacher\nTap 2 to print academic report "
							+"of the courses\nTap 3 to write department news\nTap 4 to "
							+"\nTap 0 to exit");
					int stch = Integer.parseInt(br.readLine());
					if(stch==1) assignCourseToTeacher(m);
					else if(stch==2) printAcademicReport(m);
					else if(stch==3) writeDepartmentNews(m);
					else if(stch==0) break;
				}
				else if(Login.recognizeUser(login).equals("Executor")) {
					viewAnnouncements();
					Executor t  = Login.recognizeExecutor(login);
					while(true) {
						System.out.println("Tap 1 to view orders"+"\nTap 0 to exit");
						int stch = Integer.parseInt(br.readLine());
						if(stch==1) viewAcceptedOrders(t);
						else break;
					}
					
				}
			}
			//adminmode
			else if(login.equals(admin) && password.equals(pass)) {
				viewAnnouncements();
				
				while(true) {
					System.out.println("Press 1 to add students\nPress 2 to add teachers\nPress"
						+ "3 to addCourse\n Press 0 to exit add menu");
					int admch = Integer.parseInt(br.readLine());
					if(admch==1) addStudent();
					else if(admch==2) addTeacher();
					else if(admch==3) addCourse();
					else if(admch==9) break;
				}
			}
			
			String s = br.readLine();
			if(s.equals("0")) break;

		Admin.getInstance().SerializeAll();
		}
*/

	
//		Course course =Admin.getInstance().allCourses.get(4);
//		Teacher t = Admin.getInstance().allTeachers.get(2);
//		course.teachers.add(t);
	
	}
}