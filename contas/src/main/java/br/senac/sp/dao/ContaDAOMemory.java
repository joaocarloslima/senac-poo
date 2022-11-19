package br.senac.sp.dao;

import java.util.ArrayList;
import java.util.List;

import br.senac.sp.model.Conta;

public class ContaDAOMemory implements ContaDaoInterface{

    private List<Conta> contas = new ArrayList<>();

    @Override
    public void inserir(Conta conta) throws Exception {
        contas.add(conta);
        
    }

    @Override
    public void atualizar(Conta conta) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Conta> listarTodas() throws Exception {
        return contas;
    }

    @Override
    public void apagar(Conta conta) throws Exception {
        contas.remove(conta);
    }
    
}
