package br.senac.sp.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.sp.model.Categoria;

public class CategoriaDAO {

    private static final String URL = "jdbc:mysql://185.211.7.205/u553405907_fiap";
    private static final String USER = "u553405907_fiap";
    private static final String PASSWORD = "Senac@2022";

    public void inserir(Categoria categoria) throws SQLException{
        var con = DriverManager.getConnection(URL, USER, PASSWORD);

        var ps = con.prepareStatement("INSERT INTO categorias (nome) VALUES (?)");
        ps.setString(1, categoria.getNome());
        ps.execute();

        con.close();

    }

    public void apagar(Categoria categoria) throws SQLException{
        var con = DriverManager.getConnection(URL, USER, PASSWORD);

        var ps = con.prepareStatement("DELETE FROM categorias WHERE id=?");
        ps.setInt(1, categoria.getId());
        ps.execute();

        con.close();
    }

    public List<Categoria> listarTodas() throws SQLException{
        List<Categoria> categorias = new ArrayList<>();

        var con = DriverManager.getConnection(URL, USER, PASSWORD);
        var ps = con.prepareStatement("SELECT * FROM categorias");
        var rs = ps.executeQuery();
        while (rs.next()){
            categorias.add(new Categoria(
                rs.getInt("id"),
                rs.getString("nome")
            ));
        }
        con.close();
        return categorias;
    }
    
}
