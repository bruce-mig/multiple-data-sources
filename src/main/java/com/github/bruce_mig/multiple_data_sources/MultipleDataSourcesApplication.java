package com.github.bruce_mig.multiple_data_sources;

import com.github.bruce_mig.multiple_data_sources.post.Post;
import com.github.bruce_mig.multiple_data_sources.post.PostDAO;
import com.github.bruce_mig.multiple_data_sources.subscriber.Subscriber;
import com.github.bruce_mig.multiple_data_sources.subscriber.SubscriberDAO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MultipleDataSourcesApplication implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(MultipleDataSourcesApplication.class);

	private  final PostDAO postDAO;
	private final SubscriberDAO subscriberDAO;

    public MultipleDataSourcesApplication(PostDAO postDAO, SubscriberDAO subscriberDAO) {
        this.postDAO = postDAO;
        this.subscriberDAO = subscriberDAO;
    }

    public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourcesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Post post = new Post(1, "Hello, World!", "hello-world", LocalDate.now(), 5, "Spring Boot, Java");
		postDAO.save(post);
		log.info("saved post: {} in MySql DB", post);

		Subscriber example = new Subscriber(1, "example", "example@gmail.com");
		subscriberDAO.save(example);
		log.info("saved Subscriber: {} in Postgres DB", example);
	}
}
