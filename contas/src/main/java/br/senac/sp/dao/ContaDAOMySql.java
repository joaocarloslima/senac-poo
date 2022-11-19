package br.senac.sp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.sp.connection.ConnectionFactory;
import br.senac.sp.model.Categoria;
import br.senac.sp.model.Conta;

public class ContaDAOMySql implements ContaDaoInterface {

    private Connection con;

    public ContaDAOMySql() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public void inserir(Conta conta) throws SQLException{
        System.out.println(conta);
        var ps = con.prepareStatement(
            "INSERT INTO contas (descricao, valor, categoria_id) VALUES (?, ?, ?)");
        ps.setString(1, conta.getDescricao());
        ps.setDouble(2, conta.getValor());
        ps.setInt(3, conta.getCategoria().getId());
        ps.execute();
    }

    public void atualizar(Conta conta) throws SQLException{
        var ps = con.prepareStatement("UPDATE contas SET descricao=?, valor=?, categoria_id=? WHERE id=?");
        ps.setString(1, conta.getDescricao());
        ps.setDouble(2, conta.getValor());
        ps.setInt(3, conta.getCategoria().getId());
        ps.setInt(4, conta.getId());
        ps.execute();
    }

    public List<Conta> listarTodas() throws SQLException {
        List<Conta> contas = new ArrayList<>();

        var ps = con.prepareStatement(
            "SELECT contas.*, categorias.nome FROM contas INNER JOIN categorias ON contas.categoria_id = categorias.id"
        );
        var rs = ps.executeQuery();
        while (rs.next()){
            var categoria = new Categoria(rs.getInt("categoria_id"), rs.getString("nome"));
            contas.add(new Conta(
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getDouble("valor"),
                categoria
            ));
        }
        return contas;
    }

    public void apagar(Conta conta) throws SQLException {
        var ps = con.prepareStatement("DELETE FROM contas WHERE id=?");
        ps.setInt(1, conta.getId());
        ps.execute();
    }

}
