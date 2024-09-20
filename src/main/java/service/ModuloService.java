package service;

import dao.ModuloDAO;
import domain.Modulo;

public class ModuloService {

    private ModuloDAO moduloDAO;

    public ModuloService(){
        moduloDAO = new ModuloDAO();
    }

    public void save(Modulo modulo){
        moduloDAO.save(modulo);
    }
}
