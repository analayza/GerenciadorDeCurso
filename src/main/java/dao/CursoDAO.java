package dao;

import domain.Curso;
import persistence.JPAUtil;

import java.util.List;

public class CursoDAO {

    private JPAUtil jpaUtil;

    public CursoDAO(){
        jpaUtil = new JPAUtil();
    }
    public void save(Curso curso){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(curso);
        jpaUtil.getEntityManager().getTransaction().commit();
    }

    public void update(Curso curso){
        jpaUtil.getEntityManager().merge(curso);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public Curso getById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        return jpaUtil.getEntityManager().find(Curso.class, id);
    }

    public List<Curso> listAllCurso(){
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager()
                .createNamedQuery("curso.getAll");
        return query.getResultList();
    }

    public String delete(Long id){
        var deleteCurso = getById(id);
        jpaUtil.getEntityManager().remove(deleteCurso);
        jpaUtil.getEntityManager().getTransaction().commit();
        return deleteCurso.getTitulo().concat("Foi removido com sucesso!");
    }
}
