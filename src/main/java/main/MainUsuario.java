package main;

import domain.Usuario;
import service.UsuarioService;

public class MainUsuario {
    public static void main(String[] args) {
        var usuarioService = new UsuarioService();
        var usuario1 = Usuario.builder()
                .nome("Maria")
                .email("maria@gmail.com")
                .senha("1234")
                .tipo("aluno")
                .build();
        var usuario2 = Usuario.builder()
                .nome("José")
                .email("jose@gmail.com")
                .senha("4321")
                .tipo("aluno")
                .build();
        var usuario3 = Usuario.builder()
                .nome("Laura")
                .email("laura@gmail.com")
                .senha("4451")
                .tipo("professor")
                .build();
        var usuario4 = Usuario.builder()
                .nome("Luan")
                .email("luan@gmail.com")
                .senha("5671")
                .tipo("professor")
                .build();

        //usuarioService.save(usuario4);

        //System.out.println(usuarioService.buscarPorId(5L));

        //System.out.println(usuarioService.listarUsuarios());

        //var usuarioExistente = usuarioService.buscarPorId(5l);
        //usuarioExistente.setNome("Maria Julia");
        //usuarioService.atualizarUsuario(usuarioExistente);

        //usuarioService.deletarUsuario(8l);
    }
}
