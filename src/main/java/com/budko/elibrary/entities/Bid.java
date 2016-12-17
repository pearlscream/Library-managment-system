package com.budko.elibrary.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author DBudko.
 */
@Entity
@Table(name = "bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bid")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viewer_id")
    private User user;
    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private Book book;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Calendar bidDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Calendar getBidDate() {
        return bidDate;
    }

    public void setBidDate(Calendar bidDate) {
        this.bidDate = bidDate;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", bidDate=" + bidDate +
                '}';
    }
}
