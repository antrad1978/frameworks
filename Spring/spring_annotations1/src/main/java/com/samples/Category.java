package com.samples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("category")
public class Category {
    private long id;
    @Value("N/A")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
