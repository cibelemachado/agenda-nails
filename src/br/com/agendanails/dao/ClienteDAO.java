package br.com.agendanails.dao;

import br.com.agendanails.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();        
        String sql = "SELECT * FROM cliente";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone")
                );        
                c.setWhatsapp(rs.getString("whatsapp"));
                lista.add(c);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;            
    }
    
    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, telefone, whatsapp) VALUES (?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getWhatsapp());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }            
    }
}

