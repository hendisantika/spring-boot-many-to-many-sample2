package com.hendisantika.seeder;

import com.hendisantika.entity.Movie;
import com.hendisantika.entity.User;
import com.hendisantika.entity.UserMovie;
import com.hendisantika.entity.UserMovieId;
import com.hendisantika.repository.MovieRepository;
import com.hendisantika.repository.UserMovieRepository;
import com.hendisantika.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

    private final UserMovieRepository userMovieRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Movie movie1 = new Movie("Movie 1", "Movie 1 description", 2020);
        Movie movie2 = new Movie("Movie 2", "Movie 2 description", 2021);

        Movie createdMovie1 = movieRepository.save(movie1);
        Movie createdMovie2 = movieRepository.save(movie2);

        User user = new User("user@email.com", "John Doe");

        User createdUser = userRepository.save(user);

        UserMovieId userMovieId1 = new UserMovieId(createdUser.getId(), createdMovie1.getId());
        UserMovie userMovie1 = new UserMovie(userMovieId1, 4, "This is a good movie");
        userMovie1.setUser(createdUser);
        userMovie1.setMovie(createdMovie1);

        UserMovieId userMovieId2 = new UserMovieId(createdUser.getId(), createdMovie2.getId());
        UserMovie userMovie2 = new UserMovie(userMovieId2, 5, "This is an awesome movie!");
        userMovie2.setUser(createdUser);
        userMovie2.setMovie(createdMovie2);

        userMovieRepository.save(userMovie1);
        userMovieRepository.save(userMovie2);

        Iterable<UserMovie> userMovieList = userMovieRepository.findAll();

        userMovieList.forEach(um -> {
            System.out.println("The user " + um.getUser().getName() + " gave a rate of " + um.getRate() + " to the movie " + um.getMovie().getName());
        });
    }

}
