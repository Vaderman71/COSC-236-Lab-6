package lab5;

public class EBookFactory implements BookFactory{
	public EBook createBook(String title){
		return new EBook(title);
	}
};
