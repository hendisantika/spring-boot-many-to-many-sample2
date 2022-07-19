package com.hendisantika.seeder;

import com.hendisantika.entity.Movie;
import com.hendisantika.entity.User;
import com.hendisantika.repository.MovieRepository;
import com.hendisantika.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-many-to-many-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/19/22
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final UserRepository userRepository;

    private final MovieRepository movieRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Movie movie1 = new Movie("Movie 1", "Movie 1 description", 2020);
        Movie movie2 = new Movie("Movie 2", "Movie 2 description", 2021);

        Movie createdMovie1 = movieRepository.save(movie1);
        Movie createdMovie2 = movieRepository.save(movie2);

        User user = new User("user@email.com", "John Doe");

        Set<Movie> movies = new HashSet<>();
        movies.add(createdMovie1);
        movies.add(createdMovie2);

        user.setMovies(movies);

        User createdUser = userRepository.save(user);

        createdUser.getMovies().forEach(System.out::println);
    }

}
