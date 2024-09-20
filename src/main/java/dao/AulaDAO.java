package dao;

import persistence.JPAUtil;

public class AulaDAO {
    private JPAUtil jpaUtil;

    public AulaDAO(){
        jpaUtil = new JPAUtil();
    }

    public void save(AulaDAO aulaDAO){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(aulaDAO);
        jpaUtil.getEntityManager().getTransaction().commit();
    }
}
