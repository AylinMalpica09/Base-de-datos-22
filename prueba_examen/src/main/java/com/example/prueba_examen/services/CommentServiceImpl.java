package com.example.prueba_examen.services;

import com.example.prueba_examen.controllers.dtos.request.CreateCommentRequest;
import com.example.prueba_examen.controllers.dtos.request.UpdateCommentRequest;
import com.example.prueba_examen.controllers.dtos.responses.GetCommentResponses;
import com.example.prueba_examen.entities.Comment;
import com.example.prueba_examen.repository.ICommentRepository;
import com.example.prueba_examen.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepository repository;
    @Override
    public GetCommentResponses getComment(Long id) {
        return from(id);
    }
    @Override
    public void deleteComment(Long id) {
        repository.deleteById(id);
    }
    @Override
    public GetCommentResponses createComment(CreateCommentRequest request) {
    Comment comment = from (request);
        return from(repository.save(comment));
    }
    @Override
    public List<GetCommentResponses> getList() {

        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
    @Override
    public GetCommentResponses updateComment(Long id, UpdateCommentRequest request) {
        Comment comment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The comment does not exist"));
        comment = update(comment, request);
        return from(comment);

    }
//metodos privados
    private Comment update(Comment comment, UpdateCommentRequest request) {
        comment.setUser(request.getUser());
        comment.setComment(request.getComment());
        return repository.save(comment);
    }
    private Comment from(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setUser(request.getUser());
        comment.setComment(request.getComment());
        return comment;
    }
    private GetCommentResponses from(Comment comment) {
        GetCommentResponses response = new GetCommentResponses();
        response.setComment(comment.getComment());
        response.setUser(comment.getUser());
        return response;
    }
    private GetCommentResponses from (Long id){
        return repository.findById(id)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("The comment does not exist"));
    }
}
