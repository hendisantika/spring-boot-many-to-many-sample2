package com.hendisantika.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-many-to-many-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/19/22
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
@Data
@Builder
@NoArgsConstructor
public class UserMovieId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer movieId;

    public UserMovieId(Integer userId, Integer movieId) {
        super();
        this.userId = userId;
        this.movieId = movieId;
    }
}
