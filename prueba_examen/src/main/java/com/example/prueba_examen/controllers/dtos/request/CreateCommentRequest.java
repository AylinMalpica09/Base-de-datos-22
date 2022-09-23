package com.example.prueba_examen.controllers.dtos.request;

public class CreateCommentRequest {
    private String user;
    private String comment;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
