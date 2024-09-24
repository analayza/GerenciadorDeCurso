package service;


import dao.CursoDAO;
import domain.Curso;
import domain.Usuario;

import java.util.List;

public class CursoService {

    private CursoDAO cursoDAO;
    private Curso curso;

    public CursoService(){
        curso = new Curso();
        cursoDAO = new CursoDAO();
    }

    public void saveCurso(Curso curso) {
        this.cursoDAO.save(curso);
    }

    public Curso buscarPorId(Long id){
       return this.cursoDAO.getById(id);
    }

    public void updateCurso(Curso curso){
        this.cursoDAO.update(curso);
    }

    public List<Curso> listAllCurso(){
        return this.cursoDAO.listAllCurso();
    }

    public String deleteCurso(Long id){
        return this.cursoDAO.delete(id);
    }

    public void addUsuario(Long id_curso, Long id_usuario){
        this.cursoDAO.addUsuarios(id_curso, id_usuario);
    }

    public void addModulo(Long id_curso, Long id_modulo){
        this.cursoDAO.addModulo(id_curso, id_modulo);
    }
}
