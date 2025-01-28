package com.github.bruce_mig.multiple_data_sources.subscriber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberDAO extends JpaRepository<Subscriber, Integer> {
}
