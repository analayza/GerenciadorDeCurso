package dao;

import domain.Usuario;
import persistence.JPAUtil;

import java.util.List;

public class UsuarioDAO {
    private JPAUtil jpaUtil;

    public UsuarioDAO(){
        jpaUtil = new JPAUtil();
    }

    public void save(Usuario usuario){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(usuario);
        jpaUtil.getEntityManager().getTransaction().commit();
    }

    public Usuario findById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        return jpaUtil.getEntityManager().find(Usuario.class, id);
    }

    public List<Usuario> getAllUsuario(){
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager().createNamedQuery("usuarioGetAll");
        return query.getResultList();
    }

    public void updateUsuario(Usuario usuario){
        jpaUtil.getEntityManager().merge(usuario);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public void deleteUsuario(Long id){
        var usuarioParaDeletar = findById(id);
        jpaUtil.getEntityManager().remove(usuarioParaDeletar);
        jpaUtil.getEntityManager().getTransaction().commit();
    }
}
