package dao;

import domain.Aula;
import domain.Modulo;
import persistence.JPAUtil;

import java.util.List;

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

    public Aula aulaById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        return jpaUtil.getEntityManager().find(Aula.class, id);
    }

    public List<Aula> getAllAulas(){
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager().createNamedQuery("aula.getAll");
        return query.getResultList();
    }

    public String deleteAula(Long id){
        var aulaParaExcluir = aulaById(id);
        jpaUtil.getEntityManager().remove(aulaParaExcluir);
        jpaUtil.getEntityManager().getTransaction().commit();
        return aulaParaExcluir.getId().toString().concat(" excluido com sucesso!");
    }

    public String updateTitulo(Long id, String titulo){
        var aulaParaAlterarTitulo = aulaById(id);
        aulaParaAlterarTitulo.setTitulo(titulo);
        jpaUtil.getEntityManager().merge(aulaParaAlterarTitulo);
        jpaUtil.getEntityManager().getTransaction().commit();
        return aulaParaAlterarTitulo.getId().toString().concat(" alterado com sucesso!");
    }

    public String updateURL(Long id, String url){
        var aulaParaAlterarURL = aulaById(id);
        aulaParaAlterarURL.setUrl(url);
        jpaUtil.getEntityManager().merge(aulaParaAlterarURL);
        jpaUtil.getEntityManager().getTransaction().commit();
        return aulaParaAlterarURL.getId().toString().concat(" alterado com sucesso!");
    }
}
