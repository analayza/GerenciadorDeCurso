package main;

import domain.Curso;
import service.CursoService;
import service.ModuloService;

import java.math.BigDecimal;

public class MainCurso {
    public static void main(String[] args) {

        var cursoService = new CursoService();
        var moduloService = new ModuloService();

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

        //var usuarioExistente = usuarioService.buscarPorId(3l);

        //cursoService.addUsuario(1l, usuarioExistente.getId());

//        var moduloExistente = moduloService.buscarId(1l);
//
//        cursoService.addModulo(1l, moduloExistente.getId());
//
//        cursoService.deleteCurso(2l);

        System.out.println(cursoService.getMaxValue());


    }
}
