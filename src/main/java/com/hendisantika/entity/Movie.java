package com.hendisantika.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-many-to-many-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/19/22
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "movies")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String name;

    @Lob
    private String description;

    @Column(nullable = false)
    private Integer releaseDate;

    @ManyToMany(mappedBy = "movies")
    @ToString.Exclude
    private Set<User> users;

    public Movie(String name, String description, Integer releaseDate) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
