package com.hendisantika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.util.Date;

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
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Date addedAt;

    public UserMovie(UserMovieId id, int rate, String review) {
        this.id = id;
        this.rate = rate;
        this.review = review;
    }

}
