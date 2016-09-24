package com.budko.elibrary.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * @author DBudko.
 */
@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_faculties")
    private Integer id;
    @Column(name = "faculty_name")
    @NotEmpty(message = "Введіть ваш факультет")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
