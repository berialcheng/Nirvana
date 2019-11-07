package com.example.kafkademo.spring;

public class User {

    private String name;
    private String message;

    private User(Builder builder) {
        setName(builder.name);
        setMessage(builder.message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static final class Builder {
        private String name;
        private String message;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
