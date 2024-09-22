package main;

import domain.Usuario;
import service.UsuarioService;

public class Main {
    public static void main(String[] args) {
        var usuarioService = new UsuarioService();
        var usuario = Usuario.builder()
                .nome("Maria")
                .email("maria@gmail.com")
                .senha("1234")
                .tipo("aluno")
                .build();

        //usuarioService.save(usuario);
    }
}
