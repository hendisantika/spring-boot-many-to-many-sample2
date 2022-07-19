package com.hendisantika.repository;

import com.hendisantika.entity.UserMovie;
import com.hendisantika.entity.UserMovieId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-many-to-many-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/19/22
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public interface UserMovieRepository extends CrudRepository<UserMovie, UserMovieId> {
}
