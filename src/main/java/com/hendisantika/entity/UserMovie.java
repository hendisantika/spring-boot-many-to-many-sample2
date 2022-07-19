package com.hendisantika.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-many-to-many-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/19/22
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "users_movies")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserMovie {
    @EmbeddedId
    private UserMovieId id = new UserMovieId();

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("movieId")
    private Movie movie;

    @Column(nullable = false)
    private int rate;

    @Lob
    private String review;

    @CreationTimestamp
    @Column(name = "added_at", nullable = false)
    private Date addedAt = new Date();

    public UserMovie(UserMovieId id, int rate, String review) {
        this.id = id;
        this.rate = rate;
        this.review = review;
    }

    public UserMovie(UserMovieId id, int rate, String review, Date addedAt) {
        this.id = id;
        this.rate = rate;
        this.review = review;
        this.addedAt = addedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserMovie userMovie = (UserMovie) o;
        return id != null && Objects.equals(id, userMovie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
