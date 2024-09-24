package dao;

import domain.Curso;
import domain.Usuario;
import persistence.JPAUtil;

import java.util.List;

public class CursoDAO {

    private JPAUtil jpaUtil;
    private UsuarioDAO usuarioDAO;

    public CursoDAO(){
        jpaUtil = new JPAUtil();
        usuarioDAO = new UsuarioDAO();
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

    public void addUsuarios(Long id_curso, Long id_usuario){
        var idExiste = getById(id_curso);
        var idExisteUsuario = usuarioDAO.findById(id_usuario);
        if(idExiste.getId() != null && idExisteUsuario != null){

            var query = jpaUtil.getEntityManager()
                    .createNativeQuery("INSERT INTO curso_usuario (curso_id, usuario_id) " +
                            "VALUES (:id_curso, :id_usuario)");

            query.setParameter("id_curso", id_curso);
            query.setParameter("id_usuario", id_usuario);

            query.executeUpdate();
            jpaUtil.getEntityManager().getTransaction().commit();

        }
        else{
            System.out.println("O Curso ou o Usuario, não existe");
        }

    }

    public void addModulo(Long id_curso, Long id_modulo){
        var idExiste = getById(id_curso);
        var idExisteModulo = usuarioDAO.findById(id_modulo);
        if(idExiste.getId() != null && idExisteModulo != null){

            var query = jpaUtil.getEntityManager()
                    .createNativeQuery("INSERT INTO curso_modulo (curso_id, modulo_id) " +
                            "VALUES (:id_curso, :id_modulo)");

            query.setParameter("id_curso", id_curso);
            query.setParameter("id_modulo", id_modulo);

            query.executeUpdate();
            jpaUtil.getEntityManager().getTransaction().commit();

        }
        else{
            System.out.println("O Curso ou o Modulo, não existe");
        }

    }

    public String delete(Long id){
        var deleteCurso = getById(id);
        jpaUtil.getEntityManager().remove(deleteCurso);
        jpaUtil.getEntityManager().getTransaction().commit();
        return deleteCurso.getTitulo().concat("Foi removido com sucesso!");
    }
}
