package com.example.prueba_examen.controllers;

import com.example.prueba_examen.controllers.dtos.request.CreateCommentRequest;
import com.example.prueba_examen.controllers.dtos.request.UpdateCommentRequest;
import com.example.prueba_examen.controllers.dtos.responses.GetCommentResponses;
import com.example.prueba_examen.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private ICommentService service;
    @GetMapping
    public List<GetCommentResponses> CommentList ()
    {return service.getList();}

    @PostMapping
    public GetCommentResponses createComment (@RequestBody CreateCommentRequest request)
    {return service.createComment(request);}

    @PutMapping ("{id}")
    public GetCommentResponses updateComment (@PathVariable Long id, @RequestBody UpdateCommentRequest request)
    {return service.updateComment(id, request);}

    @DeleteMapping ("{id}")
    public void deleteComment (@PathVariable Long id)
    { service.deleteComment(id);}

    @GetMapping ("{id}")
    public GetCommentResponses getComment (@PathVariable Long id){
        return service.getComment(id);
    }
}
