package d;

import java.io.File;
import java.io.Serializable;

public class MyFiles implements Serializable, Cloneable {

	public String title;
	public String format;
	public File file;
	//file
	public MyFiles(String t, String f) {
		title =t;
		format = f;
	}
	MyFiles(File f){
		file = f;
		title = f.getName();
		format= ".txt";
	}
	public void setFile(String filename) {
		//try {
		file = new File(filename+".txt");

	}
	public boolean equals(Object o) {
		MyFiles f = (MyFiles)o;
		if(title.equals(f.title)) return true;
		return false;
	}
	public String toString() {
		return title+format;
	}
}