package org.project.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Contact {
    private String name;
    private String email;
    private String subject;
    private String message;
    private String uploadFilePath;

    public Contact() {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

    public static class Builder {
        private Contact contact;

        public Builder() {
            contact = new Contact();
        }

        public Builder name(String name) {
            contact.name = name;
            return this;
        }

        public Builder email(String email) {
            contact.email = email;
            return this;
        }

        public Builder subject(String subject) {
            contact.subject = subject;
            return this;
        }

        public Builder message(String message) {
            contact.message = message;
            return this;
        }

        public Builder uploadFilePath(String uploadFilePath) {
            contact.uploadFilePath = uploadFilePath;
            return this;
        }

        public Contact build() {
            return contact;
        }
    }
}