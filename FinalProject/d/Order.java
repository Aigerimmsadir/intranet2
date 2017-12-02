package d;

import java.io.Serializable;
import java.util.Date;


public class Order implements Cloneable, Comparable,Serializable {
	private String title;
	private String text;
	private Date timeAccepted;
	private boolean isDone;
	private Date timeFinished;
	private boolean isAccepted;
	
	public Order(String title) {
		super();
		this.title = title;
	//	this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTimeAccepted() {
		return timeAccepted;
	}

	public void setTimeAccepted(Date timeAccepted) {
		this.timeAccepted = timeAccepted;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public Date getTimeFinished() {
		return timeFinished;
	}

	public void setTimeFinished(Date timeFinished) {
		this.timeFinished = timeFinished;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	public String toString() {
		return "Order [title=" + title + ", text="
					+ text + ", timeAccepted=" + timeAccepted +"]";
	}

	public int compareTo(Object o) {
	    Order or = (Order)o;
	    return or.timeAccepted.compareTo(or.timeAccepted);
	}
} 

