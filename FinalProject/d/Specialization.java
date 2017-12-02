package d;

import java.io.Serializable;

public class Specialization implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String title;
public Specialization(String s){
	title =s;
}
@Override
	public String toString() {

		return title;
	}
@Override
	public boolean equals(Object arg0) {
	Specialization s = (Specialization)arg0;
		return title.equals(s.title);
	}
}
