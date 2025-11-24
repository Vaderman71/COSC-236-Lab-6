public class EBook implements Book {
  private String title;

public EBook(String title){
  this.title = title;
}

@Override
public String getTitle(){
  return this.title;
}

@Override
public boolean getIsAvailable(){
  return true;
}

@Override
  public void setIsAvailable (boolean isAvailable){
    //Ebooks are always available
  }
@Override
  public String toString(){
    return "Ebook: "+title;
  }
}
