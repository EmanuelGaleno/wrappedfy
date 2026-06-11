package com.duell.wrappedfy.application.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(
        name = "Autenticação",
        description = "Endpoints responsáveis pela autenticação e autorização de usuários"
)
public interface AuthApi {

    @Operation(
            summary = "Iniciar autenticação com Spotify",
            description = "Redireciona o usuário para a tela de autorização do Spotify."
    )
    @ApiResponse(
            responseCode = "302",
            description = "Usuário redirecionado para autenticação no Spotify"
    )
    ResponseEntity<Void> login();

    @Operation(
            summary = "Processar retorno da autenticação Spotify",
            description = "Recebe o código de autorização retornado pelo Spotify após o login do usuário."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Código de autorização recebido com sucesso"
    )
    ResponseEntity<String> callback(
            @RequestParam("code") String code
    );
}