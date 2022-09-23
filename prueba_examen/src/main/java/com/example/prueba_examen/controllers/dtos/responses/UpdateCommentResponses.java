package com.example.prueba_examen.controllers.dtos.responses;

public class UpdateCommentResponses {
    private String user;
    private String comment;
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


