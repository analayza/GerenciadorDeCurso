package service;

import dao.AulaDAO;
import dao.ModuloDAO;
import domain.Aula;
import domain.Modulo;
import persistence.JPAUtil;

import java.util.List;

public class ModuloService {

    private Aula aula;
    private ModuloDAO moduloDAO;
    private AulaDAO aulaDAO;

    public ModuloService(){
        moduloDAO = new ModuloDAO();
        aulaDAO = new AulaDAO();
    }


    public void save(Modulo modulo){
        moduloDAO.save(modulo);
    }

    public void deleteModulo(Modulo modulo){
        moduloDAO.deleteModulo(modulo.getId());
    }

    public void upateAulasEmModulos(Long id, List<Aula> aulas){
        moduloDAO.updateAulasEmModulos(id, aulas);
    }

    public Modulo buscarId(Long id){
       return moduloDAO.moduloById(id);
    }

}
