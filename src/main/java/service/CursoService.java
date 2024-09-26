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

    public Object getMaxValue(){
        return cursoDAO.getMaxValue();
    }

    public List<Curso> buscarCursoProfessor(String nome){
        return cursoDAO.buscarCursoProfessor(nome);
    }

    public List<Curso> buscarProfessoresModulosAulas(String titulo){
        return cursoDAO.buscarProfessoresModulosAulas(titulo);
    }

    public List<Usuario> buscarAlunosPorCurso(String titulo){
        return cursoDAO.buscarAlunosPorCurso(titulo);
    }

}

