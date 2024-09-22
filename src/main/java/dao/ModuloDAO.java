package dao;

import domain.Aula;
import domain.Modulo;
import persistence.JPAUtil;

import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

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

    public Modulo moduloById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        return jpaUtil.getEntityManager().find(Modulo.class, id);
    }

    public List<Modulo> getAllModulos(){
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager().createNamedQuery("modulo.getAll");
        return query.getResultList();
    }

    public String deleteModulo(Long id){
        var moduloParaExcluir = moduloById(id);
        jpaUtil.getEntityManager().remove(moduloParaExcluir);
        jpaUtil.getEntityManager().getTransaction().commit();
        return moduloParaExcluir.getId().toString().concat(" excluido com sucesso!");
    }

    public String updateAulasEmModulos(Long id, List<Aula> aula){
        var moduloParaAlterar = moduloById(id);
        moduloParaAlterar.setAula(aula);
        jpaUtil.getEntityManager().merge(moduloParaAlterar);
        jpaUtil.getEntityManager().getTransaction().commit();
        return moduloParaAlterar.getId().toString().concat(" alterado com sucesso!");
    }

}
