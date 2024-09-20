package dao;

import domain.Aula;
import persistence.JPAUtil;

public class AulaDAO {
    private JPAUtil jpaUtil;

    public AulaDAO(){
        jpaUtil = new JPAUtil();
    }

    public void save(Aula aula){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(aula);
        jpaUtil.getEntityManager().getTransaction().commit();
    }
}
