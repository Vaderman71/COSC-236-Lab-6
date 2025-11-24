package lab5;

public class EBook implements Book {
  private String title;
  private boolean isAvailable;

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
    this.isAvailable = true;
  }
@Override
  public String toString(){
    return "Ebook: "+title;
  }
}
