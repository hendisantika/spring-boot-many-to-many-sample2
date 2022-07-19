package com.hendisantika.repository;

import com.hendisantika.entity.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-many-to-many-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/19/22
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
