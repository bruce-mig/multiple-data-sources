package com.github.bruce_mig.multiple_data_sources.subscriber.repository;

import com.github.bruce_mig.multiple_data_sources.subscriber.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberDAO extends JpaRepository<Subscriber, Integer> {
}
