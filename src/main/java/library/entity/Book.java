package library.entity;

/**
 * @author azielinski1
 */
public interface Book {

    long getId();

    void setId(long id);

    String getAuthor();

    void setAuthor(String author);

    String getTitle();

    void setTitle(String title);

    String getLocalization();

    void setLocalization(String localization);

    String getCategory();

    void setCategory(String category);

    String getRemarks();

    void setRemarks(String remarks);

    String printBook();

}
