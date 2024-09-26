package dao;

import domain.Aula;
import domain.Curso;
import domain.Modulo;
import domain.Usuario;
import persistence.JPAUtil;

import java.util.List;

public class CursoDAO {

    private JPAUtil jpaUtil;
    private UsuarioDAO usuarioDAO;

    private ModuloDAO moduloDAO;

    public CursoDAO(){
        jpaUtil = new JPAUtil();
        usuarioDAO = new UsuarioDAO();
        moduloDAO =  new ModuloDAO();
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
        var idExisteModulo = moduloDAO.moduloById(id_modulo);
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

    public Object getMaxValue(){
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager()
                .createNamedQuery("curso.getMaxValue");
        return query.getSingleResult();
    }

    public List<Curso> buscarCursoProfessor(String nome){
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager().createNamedQuery("curso.buscarCursoProfessor");
        query.setParameter("nomeProfessor", "%" + nome + "%");
        return query.getResultList();
    }

    public List<Curso> buscarProfessoresModulosAulas(String tituloCurso) {
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager().createNamedQuery("curso.buscarProfessoresModulosAulas", Curso.class);
        query.setParameter("tituloCurso", tituloCurso);
        List<Curso> cursos = query.getResultList();

        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getTitulo());
            System.out.println("Valor: " + curso.getValor());

            System.out.println("\tProfessores:");
            for (Usuario usuario : curso.getUsuario()) {
                if (usuario.getTipo().equals("professor")) {
                    System.out.println("\t\tNome: " + usuario.getNome());
                    System.out.println("\t\tEmail: " + usuario.getEmail());
                }
            }

            System.out.println("\tMódulos:");
            for (Modulo modulo : curso.getModulo()) {
                System.out.println("\t\tMódulo: " + modulo.getNome());

                // Aulas
                System.out.println("\t\t\tAulas:");
                for (Aula aula : modulo.getAula()) {
                    System.out.println("\t\t\t\tTítulo: " + aula.getTitulo());
                    System.out.println("\t\t\t\tURL: " + aula.getUrl());
                }
            }

            System.out.println("---------------------------------------------------");
        }


        return cursos;
    }

    public List<Usuario> buscarAlunosPorCurso(String tituloCurso) {
        jpaUtil.getEntityManager().getTransaction().begin();
        var query = jpaUtil.getEntityManager().createNamedQuery("curso.buscarAlunosPorCurso", Usuario.class);
        query.setParameter("tituloCurso", tituloCurso);
        List<Usuario> alunos = query.getResultList();

        System.out.println("Curso: " + tituloCurso);

        System.out.println("\tAlunos:");
        for (Usuario aluno : alunos) {
            if (aluno.getTipo().equals("aluno")) {
                System.out.println("\t\tNome: " + aluno.getNome());
                System.out.println("\t\tEmail: " + aluno.getEmail());
            }
        }

        System.out.println("---------------------------------------------------");

        return alunos;
    }

}
