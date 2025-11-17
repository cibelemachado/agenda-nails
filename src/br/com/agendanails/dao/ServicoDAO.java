package br.com.agendanails.dao;

import br.com.agendanails.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    // LISTAR TODOS
    public List<Servico> listarServicos() {
        List<Servico> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT id, nome, descricao, valor FROM servico ORDER BY nome";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Servico s = new Servico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("valor"),
                        60 
                );

                lista.add(s);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar serviços: " + e.getMessage());
        }

        return lista;
    }

    // INSERIR
    public boolean inserirServico(Servico servico) {
        try (Connection conn = Conexao.getConnection()) {
            String sql = "INSERT INTO servico (nome, descricao, valor) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getPreco());

            stmt.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir serviço: " + e.getMessage());
            return false;
        }
    }

    // ATUALIZAR
    public boolean atualizarServico(Servico servico) {
        try (Connection conn = Conexao.getConnection()) {
            String sql = "UPDATE servico SET nome = ?, descricao = ?, valor = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getPreco());
            stmt.setInt(4, servico.getId());

            stmt.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar serviço: " + e.getMessage());
            return false;
        }
    }

    // EXCLUIR
    public boolean excluirServico(int id) {
        try (Connection conn = Conexao.getConnection()) {
            String sql = "DELETE FROM servico WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir serviço: " + e.getMessage());
            return false;
        }
    }
}
