package d;

public abstract class Employee extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Employee(String name, String surname,Integer salary) {
		super(name, surname);
		this.salary = salary;
		login = Character.toLowerCase(name.toCharArray()[0])+"".toLowerCase()+"."+surname.toLowerCase();
	}

	protected Integer salary;

public int getSalary() {
	return salary;
}

public void setSalary(int salary) {
	this.salary = salary;
}
public String toString() {
    return name+" "+surname;
}
}


