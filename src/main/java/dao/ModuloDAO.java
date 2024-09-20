package dao;

import domain.Modulo;
import persistence.JPAUtil;

public class ModuloDAO {

    private JPAUtil jpaUtil;

    public ModuloDAO(){
        jpaUtil = new JPAUtil();
    }

    public void save(Modulo modulo){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(modulo);
        jpaUtil.getEntityManager().getTransaction().commit();
    }
}
