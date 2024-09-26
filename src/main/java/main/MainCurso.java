package main;

import dao.CursoDAO;
import domain.Curso;
import domain.Modulo;
import service.CursoService;
import service.ModuloService;
import service.UsuarioService;

import java.math.BigDecimal;
import java.util.List;

public class MainCurso {
    public static void main(String[] args) {

        var cursoService = new CursoService();
        var moduloService = new ModuloService();
        var usuarioService = new UsuarioService();

        var curso2 = new Curso().builder()
                .titulo("Python")
                .valor(new BigDecimal(300))
                .build();

        //cursoService.saveCurso(curso2);

        //var cursoExistente = cursoService.buscarPorId(2l);

        //cursoExistente.setTitulo("Python e Flask");

        //cursoService.updateCurso(cursoExistente);

        //System.out.println(cursoService.listAllCurso());


        //cursoService.deleteCurso(2l);

        //var usuarioExistente = usuarioService.buscarPorId(5l);

        //cursoService.addUsuario(1l, usuarioExistente.getId());

//        var moduloExistente = moduloService.buscarId(1l);
//
//        cursoService.addModulo(1l, moduloExistente.getId());
//
//        cursoService.deleteCurso(2l);

        //System.out.println(cursoService.getMaxValue());

        //cursoService.addUsuario(1l, 3l);

        //System.out.println(cursoService.buscarCursoProfessor("José"));

        //System.out.println(cursoService.professorModuloAula("Python"));

        System.out.println(cursoService.buscarAlunosPorCurso("Python com Flask"));

        //System.out.println(cursoService.buscarProfessoresModulosAulas("Python com Flask"));


    }
}
