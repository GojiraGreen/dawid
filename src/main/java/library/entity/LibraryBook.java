package library.entity;

/**
 * @author azielinski1
 */
public class LibraryBook implements Book {

    private long id;
    private String author;
    private String title;
    private String localization;
    private String category;
    private String remarks;

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String printBook() {
        return null;
    }
}
