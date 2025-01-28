package com.github.bruce_mig.multiple_data_sources.subscriber;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Entity(name = "subscribers")
public class Subscriber {
    @Id
    private Integer id;
    private String name;
    private String email;

    public Subscriber(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Subscriber() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
