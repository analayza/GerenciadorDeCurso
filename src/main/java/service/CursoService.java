package service;

<<<<<<< HEAD
public class CursoService {
=======
import dao.CursoDAO;
import domain.Curso;

public class CursoService {

    private CursoDAO cursoDAO;
    private Curso curso;

    public CursoService(){
        curso = new Curso();
    }

    public void save(Curso curso) {
        cursoDAO.save(curso);
    }
>>>>>>> bruno
}
