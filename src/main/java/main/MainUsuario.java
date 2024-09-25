package main;

import domain.Usuario;
import service.UsuarioService;

public class MainUsuario {
    public static void main(String[] args) {
        var usuarioService = new UsuarioService();
        var usuario = Usuario.builder()
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
                .nome("José")
                .email("jose@gmail.com")
                .senha("4321")
                .tipo("professor")
                .build();

        usuarioService.save(usuario3);

        //System.out.println(usuarioService.buscarPorId(1L));

        //System.out.println(usuarioService.listarUsuarios());

        //var usuarioExistente = usuarioService.buscarPorId(1l);
        //usuarioExistente.setNome("Maria Julia");
        //usuarioService.atualizarUsuario(usuarioExistente);

        //usuarioService.deletarUsuario(2l);
    }
}
