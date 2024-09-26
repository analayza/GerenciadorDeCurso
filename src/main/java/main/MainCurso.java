package main;

import dao.CursoDAO;
import domain.Aula;
import domain.Curso;
import domain.Modulo;
import service.AulaService;
import service.CursoService;
import service.ModuloService;
import service.UsuarioService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainCurso {
    public static void main(String[] args) {

        var cursoService = new CursoService();
        var moduloService = new ModuloService();
        var usuarioService = new UsuarioService();
        var aulaService = new AulaService();

        var curso1 = new Curso().builder()
                .titulo("Python")
                .valor(new BigDecimal(300))
                .build();
        var curso2 = new Curso().builder()
                .titulo("JavaScript")
                .valor(new BigDecimal(150))
                .build();

        List<Modulo> modulos = new ArrayList<Modulo>();
        var modulo1 = new Modulo().builder()
                .nome("Modulo 1 - Instalção de Programas")
                .build();
        modulos.add(modulo1);

        var curso = new Curso().builder()
                .modulo(modulos)
                .titulo("Desenvolvimento Web")
                .valor(new BigDecimal(150))
                .build();

        //cursoService.saveCurso(curso);

        //var cursoExistente = cursoService.buscarPorId(5l);
        //cursoExistente.setTitulo("Desenvolvimento WEB");
        //cursoService.updateCurso(cursoExistente);

        //System.out.println(cursoService.listAllCurso());

        //cursoService.deleteCurso(2l);

        //var usuarioExistente = usuarioService.buscarPorId(6l);
        //cursoService.addUsuario(4l, usuarioExistente.getId());

        //var moduloExistente = moduloService.buscarId(4l);
        //cursoService.addModulo(4l, moduloExistente.getId());

        //cursoService.deleteCurso(2l);


        //Querys:
        //System.out.println(cursoService.getMaxValue());

        //System.out.println(cursoService.buscarCursoProfessor("Laura"));

        //System.out.println(cursoService.buscarAlunosPorCurso("Desenvolvimento WEB"));

        //System.out.println(cursoService.buscarProfessoresModulosAulas("JavaScript"));

    }
}
