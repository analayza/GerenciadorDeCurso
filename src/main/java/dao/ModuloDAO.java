package dao;

import domain.Aula;
import domain.Modulo;
import persistence.JPAUtil;

import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

public class ModuloDAO {

    private JPAUtil jpaUtil;

    private AulaDAO aulaDAO;

    public ModuloDAO(){
        jpaUtil = new JPAUtil();
        this.aulaDAO = new AulaDAO();
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

    public void addAulas(Long id_modulo, Long id_aulas){
        var idExiste = moduloById(id_modulo);
        var idExisteModulo = aulaDAO.aulaById(id_aulas);
        if(idExiste.getId() != null && idExisteModulo != null){

            var query = jpaUtil.getEntityManager()
                    .createNativeQuery("INSERT INTO modulo_aula (modulo_id, aula_id) " +
                            "VALUES (:id_modulo, :id_aulas)");

            query.setParameter("id_modulo", id_modulo);
            query.setParameter("id_aulas", id_aulas);

            query.executeUpdate();
            jpaUtil.getEntityManager().getTransaction().commit();

        }
        else{
            System.out.println("O Modulo ou a Aula, não existe");
        }

    }

}
