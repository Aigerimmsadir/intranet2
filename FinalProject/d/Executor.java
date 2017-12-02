package d;

import java.util.ArrayList;
import java.util.Random;

public class Executor extends Employee {
	public Executor(String name, String surname, Integer salary) {
		super(name, surname, salary);

	}

	//public static ArrayList<Order> orders=new ArrayList<Order> ();
	public ArrayList<Order> executedOrders = new ArrayList<Order>();
	 int bonus;
	

	public void addExecutedOrder(Order o) {
		executedOrders.add(o);
		addbonus(2);
	}


	public void addbonus(int bonus) {
		this.salary +=bonus;
	}
	public String viewAcceptedOrders() {
		String s = "";
		int i=0;
		for(Order o:Admin.getInstance().allOrders) {
			i++;
			s = s+i+") "+o.getTitle()+"\n";
		}
		return s;
	}
	public boolean acceptOrder(Order o) {
		Random randomAnswer = new Random();
		return randomAnswer.nextBoolean();
	}

	@Override
	public int compareTo(Object arg0) {
		 Executor e = ( Executor)arg0;
		return this.surname.compareTo(e.getSurname());
	}
}

