package dao;

import persistence.JPAUtil;

public class AdministradorDAO {

    private JPAUtil jpaUtil;

    public AdministradorDAO(){
        jpaUtil = new JPAUtil();
    }

    public void save(AdministradorDAO administradorDAO){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(administradorDAO);
        jpaUtil.getEntityManager().getTransaction().commit();
    }
}
