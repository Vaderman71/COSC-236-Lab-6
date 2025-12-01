package lab5;

public class PaperBookFactory implements BookFactory{
	public paperBook createBook(String title){
		return new PaperBook(title);
	}
};
