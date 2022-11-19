package br.senac.sp.dao;

import java.util.List;

import br.senac.sp.model.Conta;

public interface ContaDaoInterface {

    public void inserir(Conta conta) throws Exception;

    public void atualizar(Conta conta) throws Exception;

    public List<Conta> listarTodas() throws Exception;

    public void apagar(Conta conta) throws Exception;
    
}
