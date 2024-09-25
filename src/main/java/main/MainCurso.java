package main;

import domain.Curso;
import domain.Modulo;
import domain.Usuario;
import service.CursoService;
import service.ModuloService;
import service.UsuarioService;

import java.util.ArrayList;

public class MainCurso {
    public static void main(String[] args) {

        var cursoService = new CursoService();
        var usuarioService = new UsuarioService();
        var usuario = new Usuario();
        var modulo = new Modulo();
        var moduloService = new ModuloService();

        var curso2 = new Curso().builder()
                .titulo("Python com Flask")
                .build();

        //cursoService.saveCurso(curso2);

        //var cursoExistente = cursoService.buscarPorId(2l);

        //cursoExistente.setTitulo("Python e Flask");

        //cursoService.updateCurso(cursoExistente);

        //System.out.println(cursoService.listAllCurso());

        //cursoService.deleteCurso(2l);

        //var usuarioExistente = usuarioService.buscarPorId(3l);

        //cursoService.addUsuario(1l, usuarioExistente.getId());

        var moduloExistente = moduloService.buscarId(1l);

        cursoService.addModulo(1l, moduloExistente.getId());

    }
}
