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
        aula1.setTitulo("JavaScript Moderno");
        aula1.setUrl("https://www.youtube.com/watch?v=uzEhd3Lugik&list=PLHz_AreHm4dlsK3Nr9GVvXCbpQyHQl1o1&index=3");

        var aula2 = new Aula();
        aula2.setTitulo("Variaveis e Tipos Primitivos do JS");
        aula2.setUrl("https://www.youtube.com/watch?v=Vbabsye7mWo&list=PLHz_AreHm4dlsK3Nr9GVvXCbpQyHQl1o1&index=9");

        var aulas = new ArrayList<Aula>();
        aulas.add(aula1);
        aulas.add(aula2);

        //var modulo = Modulo.builder().nome("Introdução ao Python").aula(aulas).build();
        //moduloService.save(modulo);

        var aula = Aula.builder()
                .url("https://www.youtube.com/watch?v=Mp0vhMDI7fA&list=PLvE-ZAFRgX8hnECDn1v9HNTI71veL3oW0&index=3")
                .titulo("Introdução a Python")
                .build();
        //aulaService.save(aula);

        //var aulaExistente = aulaService.aulaById(7L);
        //moduloService.addAulas(5l,aulaExistente.getId());

    }
}
