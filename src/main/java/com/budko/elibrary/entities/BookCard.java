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
    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "bookCard")
    private Bid bid;

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

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

    @Override
    public String toString() {
        return "BookCard{" +
                "id=" + id +
                '}';
    }
}
