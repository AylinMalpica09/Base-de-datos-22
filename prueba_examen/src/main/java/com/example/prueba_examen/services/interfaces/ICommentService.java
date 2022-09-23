package com.example.prueba_examen.services.interfaces;

import com.example.prueba_examen.controllers.dtos.request.CreateCommentRequest;
import com.example.prueba_examen.controllers.dtos.request.UpdateCommentRequest;
import com.example.prueba_examen.controllers.dtos.responses.GetCommentResponses;

import java.util.List;

public interface ICommentService {
    GetCommentResponses createComment (CreateCommentRequest request);
    List<GetCommentResponses> getList(); // metodo de la lista

    GetCommentResponses getComment(Long Id); // metodo para obtener

    GetCommentResponses updateComment (Long id, UpdateCommentRequest request); //metodo para actualizar

    void deleteComment (Long id); // metodo para borrar
}
