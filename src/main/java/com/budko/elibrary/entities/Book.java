package com.budko.elibrary.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * @author DBudko.
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Book_id")
    private Integer bookId;
    @Column(name = "Book_Name")
    private String bookName;
    @Column(name = "Publisher")
    private String publisher;
    @Column(name = "description")
    private String description;
    @Column(name = "Publication")
    private String publication;
    @Column(name = "Publish_Year")
    private Integer publishYear;
    @Column(name = "Pages_count")
    private Integer pagesCount;
    @Column(name = "image_link")
    private String imageLink;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "authors_book",
            joinColumns = @JoinColumn(name = "id_Book",referencedColumnName = "Book_Id"),
            inverseJoinColumns = @JoinColumn(name = "id_Author",referencedColumnName = "id_Authors"))
    private Set<Author> authors;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UDK_Number")
    private UDKCategory udkCategory;
    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    private Set<BookCard> bookCards;

    public Integer getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public UDKCategory getUdkCategory() {
        return udkCategory;
    }

    public void setUdkCategory(UDKCategory udkCategory) {
        this.udkCategory = udkCategory;
    }

    public Set<BookCard> getBookCards() {
        return bookCards;
    }

    public void setBookCards(Set<BookCard> bookCards) {
        this.bookCards = bookCards;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", publication='" + publication + '\'' +
                ", publishYear=" + publishYear +
                ", pagesCount=" + pagesCount +
                ", imageLink='" + imageLink + '\'' +
                ", authors=" + authors +
                ", udkCategory=" + udkCategory +
                ", bookCards=" + bookCards +
                '}';
    }
}
