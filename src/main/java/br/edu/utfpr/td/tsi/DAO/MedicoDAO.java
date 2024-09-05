package br.edu.utfpr.td.tsi.DAO;

import java.util.List;

import br.edu.utfpr.td.tsi.MODELO.Medico;

public interface MedicoDAO {
    
    public void inserir(Medico medico);

    public void atualizar(Long id, Medico medico);

    public void remover(Long id);

    public List<Medico> listarTodos();
    
    public Medico procurar(Long id);
    
}
