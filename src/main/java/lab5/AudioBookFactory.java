package lab5;

public class AudioBookFactory implements BookFactory{
	public AudioBook createBook(String title){
		return new AudioBook(title);
	}
};
