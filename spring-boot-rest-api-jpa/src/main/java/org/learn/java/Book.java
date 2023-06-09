package org.learn.java;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="BOOK")
public class Book implements Serializable {

    private static final long serialVersionUID = -1083052789859161699L;
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="NAME")
    private String name;

    public Book() {
        super();
    }

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
