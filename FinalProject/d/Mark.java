package d;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


public class Mark implements Cloneable, Comparable, Serializable {
	public Integer total;
	private Integer attestation1;
	private Integer attestation2;
	private Integer fnal;
	public String lastPutMark;
	private String letter;
	private double gpa;
	private Date timeOfPutting;
	public Mark() {
		total = 0;
		attestation1=0;
		attestation2=0;
		fnal = 0;
		lastPutMark = "";
	}

	public int getAttestation1() {
		return attestation1;
	}
	public void setAttestation1(int attestation1) {
		this.attestation1 = attestation1;
		total = total+attestation1;
		lastPutMark = "attestation1";
	}
	public int getAttestation2() {
		return attestation2;
	}
	public void setAttestation2(int attestation2) {
		this.attestation2 = attestation2;
		total = total+attestation2;
		lastPutMark = "attestation2";
	}
	public int getFnal() {
		return fnal;
	}
	public void setFnal(int fnal) {
		this.fnal = fnal;
		total = total+fnal;
		if(total<50) gpa=0;
		else if(total<55) {
			gpa =1.0;
			letter = "D";
		}
		
		else if(total<60) {
			gpa =1.33;
			letter = "D+";
		}
		else if(total<65) {
			letter = "-C";
			gpa =1.67;
		}
		else if(total<70) {
			letter = "C";
			gpa =2;
		}
		else if(total<75) {
			letter = "C+";
			gpa =2.33;
		}
		else if(total<80) {
			letter = "B-";
			gpa =2.67;
		}
		
		else if(total<85) {
			letter = "B";
			gpa =3.0;
		}
		else if(total<90) {
			letter = "B+";
			gpa =3.33;
		}
		else if(total<95) {
			letter = "A-";
			gpa =3.67;
		}
		else if(total<100) {
			letter = "A";
			gpa =4;
		}
		timeOfPutting=  Calendar.getInstance().getTime(); 
		
	}
	public double getGpa() {
		return gpa;
	}
		

	public Date  getTimeOfPutting() {
	
		return timeOfPutting;
	}

	public String getLetter() {
		return letter;
	}
	public String markWithLetter() {
		return total+" - "+letter;
	}
	public String toString() {
		return "Mark [Attestation1=" + attestation1
				+ ", attestation2=" + attestation2 + ", final exam =" + fnal+ "]";
	}
	@Override
	public int compareTo(Object o) {
		Mark m = (Mark)o;
		if(total.compareTo(m.total)==0) {
			return fnal.compareTo(m.getFnal());
		}
		return total.compareTo(m.total);
	}	
	
}

