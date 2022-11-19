package br.senac.sp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.sp.connection.ConnectionFactory;
import br.senac.sp.model.Categoria;

public class CategoriaDAO {

    private Connection con;

    public CategoriaDAO() throws SQLException{
        con = ConnectionFactory.getConnection();
    }

    public void inserir(Categoria categoria) throws SQLException{
        var ps = con.prepareStatement("INSERT INTO categorias (nome) VALUES (?)");
        ps.setString(1, categoria.getNome());
        ps.execute();
    }

    public void apagar(Categoria categoria) throws SQLException{
        var ps = con.prepareStatement("DELETE FROM categorias WHERE id=?");
        ps.setInt(1, categoria.getId());
        ps.execute();
    }

    public List<Categoria> listarTodas() throws SQLException{
        List<Categoria> categorias = new ArrayList<>();

        var ps = con.prepareStatement("SELECT * FROM categorias");
        var rs = ps.executeQuery();
        while (rs.next()){
            categorias.add(new Categoria(
                rs.getInt("id"),
                rs.getString("nome")
            ));
        }
        return categorias;
    }
    
}
