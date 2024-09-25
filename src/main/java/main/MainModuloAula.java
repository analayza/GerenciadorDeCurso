package main;

import domain.Aula;
import domain.Modulo;
import service.AulaService;
import service.ModuloService;

import java.util.ArrayList;
import java.util.List;

public class MainModuloAula {
    public static void main(String[] args) {

        var moduloService = new ModuloService();

        var aulaService = new AulaService();

        var aula1 = new Aula();
        aula1.setTitulo("Introducao");
        aula1.setUrl("www.alura.com");

        var aula2 = new Aula();
        aula2.setTitulo("HTML e CSS");
        aula2.setUrl("www.alura.com");

        var aula3 = new Aula();
        aula3.setTitulo("JavaScrip");
        aula3.setUrl("www.alura.com");

        //aulaService.save(aula3);

        var aulas = new ArrayList<Aula>();

        aulas.add(aula1);
        aulas.add(aula2);

        var modulo = Modulo.builder().nome("Modulo HTML e CSS").aula(aulas).build();

        var aulaExistente = aulaService.aulaById(6L);

        moduloService.addAulas(1l,aulaExistente.getId());

    }
}
