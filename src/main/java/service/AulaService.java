package service;

import dao.AulaDAO;
import domain.Aula;

public class AulaService {

    private AulaDAO aulaDAO;

    public AulaService(){
        aulaDAO = new AulaDAO();
    }

    public void save(Aula aula){
        aulaDAO.save(aula);
    }
}
