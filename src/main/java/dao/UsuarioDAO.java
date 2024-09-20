package dao;

import domain.Usuario;
import persistence.JPAUtil;

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
}
