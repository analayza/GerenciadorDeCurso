package main;

import domain.Aula;
import domain.Modulo;
import domain.Usuario;
import service.AulaService;
import service.ModuloService;
import service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var usuarioService = new UsuarioService();
        var usuario = Usuario.builder()
                .nome("Maria")
                .email("maria@gmail.com")
                .senha("1234")
                .tipo("aluno")
                .build();

        usuarioService.save(usuario);
    }
}
