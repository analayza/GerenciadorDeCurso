package service;

import dao.AulaDAO;
import domain.Aula;
import domain.Modulo;

import java.util.List;

public class AulaService {

    private AulaDAO aulaDAO;

    public AulaService(){
        aulaDAO = new AulaDAO();
    }

    public void save(Aula aula){
        aulaDAO.save(aula);
    }

    public void deleteAula(Aula aula){
        aulaDAO.deleteAula(aula.getId());
    }

    public void upateTitulo(Long id, String titulo){
        aulaDAO.updateTitulo(id, titulo);
    }

    public void updateURL(Long id, String url){
        aulaDAO.updateURL(id, url);
    }

    public Aula aulaById(Long id){
        return this.aulaDAO.aulaById(id);
    }
}
