package br.senac.sp.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.sp.model.Conta;

public class ContaDAO {
    
    private static final String URL = "jdbc:mysql://185.211.7.205/u553405907_fiap";
    private static final String USER = "u553405907_fiap";
    private static final String PASSWORD = "Senac@2022";

    public void inserir(Conta conta) throws SQLException{
        var con = DriverManager.getConnection(URL, USER, PASSWORD);

        var ps = con.prepareStatement("INSERT INTO contas (descricao, valor) VALUES (?, ?)");
        ps.setString(1, conta.getDescricao());
        ps.setDouble(2, conta.getValor());
        ps.execute();

        con.close();
    }

    public void atualizar(Conta conta) throws SQLException{
        var con = DriverManager.getConnection(URL, USER, PASSWORD);

        var ps = con.prepareStatement("UPDATE contas SET descricao=?, valor=? WHERE id=?");
        ps.setString(1, conta.getDescricao());
        ps.setDouble(2, conta.getValor());
        ps.setInt(3, conta.getId());
        ps.execute();

        con.close();
    }

    public List<Conta> listarTodas() throws SQLException {
        List<Conta> contas = new ArrayList<>();

        var con = DriverManager.getConnection(URL, USER, PASSWORD);
        var ps = con.prepareStatement("SELECT * FROM contas");
        var rs = ps.executeQuery();
        while (rs.next()){
            contas.add(new Conta(
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getDouble("valor")
            ));
        }
        con.close();
        return contas;
    }

    public void apagar(Conta conta) throws SQLException {
        var con = DriverManager.getConnection(URL, USER, PASSWORD);

        var ps = con.prepareStatement("DELETE FROM contas WHERE id=?");
        ps.setInt(1, conta.getId());
        ps.execute();

        con.close();
    }

}
