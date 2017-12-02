package d;

public class Textbook extends MyFiles {
	public Textbook(String t, String f,String ISBN,String auth) {
		super(t, f);
		this.ISBN = ISBN;
		this.author = auth;
	}
	private String author;
	private String ISBN;
	public int edition;
	public String getAuthor() {
	return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	@Override
	public String toString() {
		return "Textbook "+super.toString()+ " [author=" + author + ", ISBN=" + ISBN + ", edition=" + edition + "]";
	}
}
