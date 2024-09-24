package main;

import domain.Curso;
import service.CursoService;

public class MainCurso {
    public static void main(String[] args) {

        var cursoService = new CursoService();

        var curso2 = new Curso().builder()
                .titulo("Python com Flask")
                .build();

        //cursoService.saveCurso(curso2);

        //var cursoExistente = cursoService.buscarPorId(2l);

        //cursoExistente.setTitulo("Python e Flask");

        //cursoService.updateCurso(cursoExistente);

        //System.out.println(cursoService.listAllCurso());

        //cursoService.deleteCurso(2l);

    }
}
