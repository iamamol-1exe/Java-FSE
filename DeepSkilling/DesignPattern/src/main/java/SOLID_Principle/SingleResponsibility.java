package SOLID_Principle;


// class should only have one responsibility. Furthermore, it should only have one reason to change.

//How does this principle help us to build better software? Let’s see a few of its benefits:
//Testing – A class with one responsibility will have far fewer test cases.
//Lower coupling – Less functionality in a single class will have fewer dependencies.
//Organization – Smaller, well-organized classes are easier to search than monolithic ones
public class SingleResponsibility {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("NCERT");
        book.setAuthor("NCERT");
        book.setText("12 th Class BIO book");
        BookPrinter bookPrinter = new BookPrinter();
        bookPrinter.printTextToConsole(book);
    }
}




class Book {
    private String name;
    private String text;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    // methods that directly relate to the book properties

    public String replaceWord(String word,String wordToReplace){
        return word.replaceAll(wordToReplace,name);
    }
    public boolean isWordInText(String word){
        return text.contains(word);
    }

}


class BadBook {

    private String name;
    private String text;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    void printTextToConsole(){
        // our code for formatting and printing the text
    }
}



class BookPrinter {

    // methods for outputting text
    void printTextToConsole(Book book){
        System.out.println(book.getText());
    }

    void printTextToAnotherMedium(String text){
        // code for writing to any other
    }
}
