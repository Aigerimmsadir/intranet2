package d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Admin {

	private static Admin instance = null;

	private Admin() {

	}

	public static Admin getInstance() {
		if (instance == null) {
			instance = new Admin();
		}
		return instance;
	}

	HashMap<String, Integer> allPasswords = new HashMap<String, Integer>();
	Vector<Student> allStudents = new Vector<Student>();

	Vector<Manager> allManagers = new Vector<Manager>();

	Vector<Teacher> allTeachers = new Vector<Teacher>();

	Vector<Executor> allExecutors = new Vector<Executor>();
	Vector<Faculty> allFaculties = new Vector<Faculty>();
	Vector<Textbook> allTextbooks = new Vector<Textbook>();
	Vector<Course> allCourses = new Vector<Course>();
	Vector<User> allUsers = new Vector<User>();
	Vector<Announcement> allAnnouncements = new Vector<Announcement>();
	Vector<Order> allOrders = new Vector<Order>();

	void initializeObjects() throws ClassNotFoundException, IOException {
		if (new File("courses.out").exists() && new File("user.out").exists() && new File("faculties.out").exists()
				&& new File("textbooks.out").exists()) {
			deserializeUser();
			deserializeAnnouncements();
			deserializeTextbooks();
			deserializeFaculties();
			deserializeCourses();
			deserializeOrders();
		}

	}

	void setUserPasswords() {
		for (User u : allUsers) {
			allPasswords.put(u.login, u.password);
		}
	}

	@SuppressWarnings("unchecked")
	void deserializeUser() throws IOException, ClassNotFoundException {
		allStudents.clear();
		allTeachers.clear();
		allManagers.clear();
		allExecutors.clear();
		allUsers.clear();
		FileInputStream fis = new FileInputStream("user.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		allUsers = (Vector<User>) oin.readObject();
		setUserPasswords();
		recognizeUser();
	}

	void recognizeUser() {
		for (User u : allUsers) {
			if (u instanceof Student)
				allStudents.add((Student) u);
			else if (u instanceof Teacher)
				allTeachers.add((Teacher) u);
			else if (u instanceof Executor)
				allExecutors.add((Executor) u);
			else if (u instanceof Manager)
				allManagers.add((Manager) u);
		}
	}

	void serializeUser() throws IOException, ClassNotFoundException {
		allUsers.clear();
		allUsers.addAll(allStudents);
		allUsers.addAll(allTeachers);
		allUsers.addAll(allManagers);
		allUsers.addAll(allExecutors);
		FileOutputStream fos = new FileOutputStream("user.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allUsers);
		oos.flush();
		oos.close();

	}

	void deserializeTextbooks() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("textbooks.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		allTextbooks = (Vector<Textbook>) oin.readObject();
	}

	void serializeTextbooks() throws IOException, ClassNotFoundException {

		FileOutputStream fos = new FileOutputStream("textbooks.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allTextbooks);
		oos.flush();
		oos.close();
	}

	void deserializeFaculties() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("faculties.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		allFaculties = (Vector<Faculty>) oin.readObject();
	}

	void serializeFaculties() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("faculties.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allFaculties);
		oos.flush();
		oos.close();
	}

	void deserializeCourses() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("courses.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		allCourses = (Vector<Course>) oin.readObject();
	}
	void serializeOrders() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("orders.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allOrders);
		oos.flush();
		oos.close();
	}

	void deserializeOrders() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("orders.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		allOrders = (Vector<Order>) oin.readObject();
	}

	void serializeCourses() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("courses.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allCourses);
		oos.flush();
		oos.close();
	}

	void deserializeAnnouncements() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("announcements.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		allAnnouncements = (Vector<Announcement>) oin.readObject();
	}

	void serializeAnnouncements() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("announcements.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allAnnouncements);
		oos.flush();
		oos.close();
	}
	void SerializeAll() throws ClassNotFoundException, IOException {
		serializeAnnouncements();
		serializeCourses();
		serializeFaculties();
		serializeTextbooks();
		serializeUser();
		serializeOrders();
	}
	
	public boolean addStudent(Student s) {
		if(!allStudents.contains(s)) {
			allStudents.add(s);
			return true;
		}
		return false;
	}
	public boolean addTeacher(Teacher t) {
		if(!allStudents.contains(t)) {
			allTeachers.add(t);
			return true;
		}
		return false;
	}
	public boolean addManager(Manager m) {
		if(!allStudents.contains(m)) {
			allManagers.add(m);
			return true;
		}
		return false;
	}
	public boolean addExecutor(Executor e) {
		if(!allStudents.contains(e)) {
			allExecutors.add(e);
			return true;
		}
		return false;
	}

}