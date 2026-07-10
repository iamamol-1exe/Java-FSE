package in.amolD.model;

public class Book {
    private int id;
    private String Name;
    private String Author;


    public Book(int id,String Name,String Author){
        this.id = id;
        this.Name = Name;
        this.Author = Author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
