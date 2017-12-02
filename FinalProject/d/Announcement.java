package d;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;


public class Announcement implements Comparable, Serializable {
	private String title;
	String content;
	private Manager author;
	private LocalDateTime date;
	Vector<String> comments;
	public Announcement(String s,String content,Manager m){
		title = s;
		author = m;
		this.content=content;
		date= LocalDateTime.now(); 
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Manager getAuthor() {
		return author;
	}

	public void setAuthor (Manager author) {
		this.author = author;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	
	public int compareTo(Object o) {
		Announcement a = (Announcement)o;
		return date.compareTo(a.date);
	}

}
