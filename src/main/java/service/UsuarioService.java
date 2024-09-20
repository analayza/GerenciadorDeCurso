package service;

import dao.UsuarioDAO;
import domain.Usuario;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(){
        usuarioDAO = new UsuarioDAO();
    }

    public void save(Usuario usuario){
        usuarioDAO.save(usuario);
    }
}
