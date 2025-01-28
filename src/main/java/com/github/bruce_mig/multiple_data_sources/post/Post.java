package com.github.bruce_mig.multiple_data_sources.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Builder
@Entity(name = "posts")
public class Post {
    @Id
    private Integer id;
    private String title;
    private String slug;
    private LocalDate date;
    private int timeToRead;
    private String tags;

    public Post(Integer id, String title, String slug, LocalDate date, int timeToRead, String tags) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.date = date;
        this.timeToRead = timeToRead;
        this.tags = tags;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTimeToRead() {
        return timeToRead;
    }

    public void setTimeToRead(int timeToRead) {
        this.timeToRead = timeToRead;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", date=" + date +
                ", timeToRead=" + timeToRead +
                ", tags='" + tags + '\'' +
                '}';
    }
}
