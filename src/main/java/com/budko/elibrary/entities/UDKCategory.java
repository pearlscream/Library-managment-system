package com.budko.elibrary.entities;

import javax.persistence.*;

/**
 * @author DBudko.
 */
@Entity
@Table(name = "udk_categories")
public class UDKCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UDK_ID")
    private Integer id;
    @Column(name = "category_name")
    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "UDKCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
