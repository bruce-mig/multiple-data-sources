package com.github.bruce_mig.multiple_data_sources.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDAO extends JpaRepository<Post, Integer> {
}
