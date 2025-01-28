package com.github.bruce_mig.multiple_data_sources.post.repository;

import com.github.bruce_mig.multiple_data_sources.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDAO extends JpaRepository<Post, Integer> {
}
