package dao;

import domain.Curso;
import persistence.JPAUtil;

public class CursoDAO {

    private JPAUtil jpaUtil;

    public CursoDAO(Curso curso){
        jpaUtil = new JPAUtil();
    }

    public void save(Curso curso){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(curso);
        jpaUtil.getEntityManager().getTransaction().commit();
    }
}
