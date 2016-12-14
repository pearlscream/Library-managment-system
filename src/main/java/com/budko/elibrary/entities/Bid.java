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
    private BookCard bookCard;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Calendar bidDate;

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookCard getBookCard() {
        return bookCard;
    }

    public void setBookCard(BookCard bookCard) {
        this.bookCard = bookCard;
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
                ", book=" + bookCard +
                ", bidDate=" + bidDate +
                '}';
    }
}
