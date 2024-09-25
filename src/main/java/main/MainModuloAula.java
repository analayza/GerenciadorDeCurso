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

        var aulas = new ArrayList<Aula>();

        aulas.add(aula1);
        aulas.add(aula2);

        var modulo = Modulo.builder().nome("Modulo HTML e CSS").aula(aulas).build();

        //moduloService.save(modulo);

//        var modulo2 = Modulo.builder().nome("Modulo 1").aula(List.of(
//                Aula.builder().titulo("Aula 1").url("www.catolica.com").build(),
//                Aula.builder().titulo("Aula 2").url("www.catolica.com").build())).build();

        //moduloService.save(modulo2);
    }
}
