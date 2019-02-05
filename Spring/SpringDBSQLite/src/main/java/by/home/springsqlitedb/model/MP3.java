package by.home.springsqlitedb.model;

public class MP3 {

    private String name;

    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "MP3{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
