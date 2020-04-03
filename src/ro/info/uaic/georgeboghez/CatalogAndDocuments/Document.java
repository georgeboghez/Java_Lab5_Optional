package ro.info.uaic.georgeboghez.CatalogAndDocuments;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The Document class implements Serializable in order to allow Catalog to serialize its content (the documents array).
 */
public abstract class Document implements Serializable {
    private int id;
    private String name;
    private String path;
    private Map<String, String> tags;

    /**
     * it allocates the needed memory for the object and sets the name and the path of the file (local or external).
     * @param name the name of the file (how it will be stored inside the catalog).
     * @param path the path to the file
     */
    public Document(String name, String path) {
        id = 0;
        this.name = name;
        this.path = path;
        this.tags = new HashMap<String, String>();
    }

    /**
     * gets the document's id
     * @return an int representing the id of the file
     */
    public int getId() {
        return id;
    }

    /**
     * sets the document's id
     * @param id an int representing the document's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the document's name
     * @return a string representing the document's name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the document's name
     * @param name a string representing the document's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the document's path
     * @return a string representing the document's path
     */
    public String getPath() {
        return path;
    }

    /**
     * sets the document's path
     * @param path a string representing the document's path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * gets the document's tags
     * @return a map with the key and the value being strings representing the document's tags (example "author" : "Frank Herbert")
     */
    public Map<String, String> getTags() {
        return tags;
    }

    /**
     * sets the document's tags
     */
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    /**
     * sets the document's title tag
     * @param title a string representing the document's title tag
     */
    public void setTitle(String title) {
        this.tags.put("title", title);
    }

    /**
     * sets the document's author tag
     * @param author a string representing the document's author tag
     */
    public void setAuthor(String author) {
        this.tags.put("author", author);
    }

    /**
     * sets a document's publishing year
     * @param year a string representing the document's publishing year tag
     */
    public void setYear(String year) {
        this.tags.put("year", year);
    }

    /**
     * sets a document's publishing date
     * @param publishingDate a string representing the document's publishing year date
     */
    public void setPublishingDate(String publishingDate) {
        this.tags.put("publishingDate", publishingDate);
    }

    /**
     * a string representing the document's date tag
     * @param publishingDate a Date object representing the document's author tag
     */
    public void setPublishingDate(Date publishingDate) {
        this.tags.put("publishingDate", String.valueOf(publishingDate));
    }

    /**
     * prints a document's tags
     */
    public void printTags() {
        System.out.println("Document " + name + " info:");
        for(Map.Entry<String,String> entry : tags.entrySet()) {
            System.out.println("    " + entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * Abstract method to be implemented in the ro.info.uaic.georgeboghez.CatalogAndDocuments.LocalDocument and ExternalDocument classes
     * It will open the document using the native operating system application
     */
    public abstract void openDocument();

    /**
     * prints the information about a document
     * @return a string which contains the information about a document
     */
    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", tags=" + tags.entrySet().toString() +
                '}';
    }
}
