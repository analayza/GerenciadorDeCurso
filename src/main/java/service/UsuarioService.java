package service;

import dao.UsuarioDAO;
import domain.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(){
        usuarioDAO = new UsuarioDAO();
    }

    public void save(Usuario usuario){
        usuarioDAO.save(usuario);
    }

    public Usuario buscarPorId(Long id){
       return usuarioDAO.findById(id);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioDAO.getAllUsuario();
    }

    public void atualizarUsuario(Usuario usuario){
        usuarioDAO.updateUsuario(usuario);
    }

    public void deletarUsuario(Long id){
        usuarioDAO.deleteUsuario(id);
    }
}
