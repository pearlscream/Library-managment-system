package com.budko.elibrary.entities;

import javax.persistence.*;

/**
 * @author DBudko.
 */
@Entity
@Table(name = "book_card")
public class BookCard {
    @Id
    @Column(name = "Card_Id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Book_Id")
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Viewer_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "BookCard{" +
                "id=" + id +
                '}';
    }
}
