package com.sda.chucknorris;

import java.util.Objects;

public class Joke {
    private Object category;
    private String icon_url;
    private String id;
    private String url;
    private String value;


    public Object getCategory() {
        return category;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke = (Joke) o;
        return Objects.equals(id, joke.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
