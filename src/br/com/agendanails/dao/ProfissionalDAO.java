package br.com.agendanails.dao;

import br.com.agendanails.Profissional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalDAO {

    public void inserir(Profissional p) {
        String sql = "INSERT INTO profissional (nome, especialidade, horario) VALUES (?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEspecialidade());
            stmt.setString(3, p.getHorario());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Profissional p) {
        String sql = "UPDATE profissional SET nome = ?, especialidade = ?, horario = ? WHERE id = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEspecialidade());
            stmt.setString(3, p.getHorario());
            stmt.setInt(4, p.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM profissional WHERE id = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Profissional> listarTodos() {
        List<Profissional> lista = new ArrayList<>();
        String sql = "SELECT * FROM profissional ORDER BY nome";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new Profissional(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especialidade"),
                        rs.getString("horario")
                ));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    public Profissional buscarPorId(int id) {
        String sql = "SELECT * FROM profissional WHERE id = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Profissional(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("especialidade"),
                    rs.getString("horario")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
