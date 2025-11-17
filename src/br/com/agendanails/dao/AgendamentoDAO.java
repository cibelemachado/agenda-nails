package br.com.agendanails.dao;

import br.com.agendanails.Agendamento;
import br.com.agendanails.Cliente;
import br.com.agendanails.Profissional;
import br.com.agendanails.Servico;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {
    
    public List<Agendamento> listarAgendamentos() {
        List<Agendamento> lista = new ArrayList<>();
        
        String sql = "SELECT a.id, a.data_hora, " +
                     "c.id AS c_id, c.nome AS c_nome, c.telefone AS c_telefone, c.whatsapp AS c_whatsapp, " +
                     "p.id AS p_id, p.nome AS p_nome, p.especialidade AS p_esp, p.horario_trabalho AS p_horario, " +
                     "s.id AS s_id, s.nome AS s_nome, s.descricao AS s_desc, s.valor AS s_valor, s.duracao_min AS s_duracao " +
                     "FROM agendamento a " +
                     "LEFT JOIN cliente c ON a.id_cliente = c.id " +
                     "LEFT JOIN profissional p ON a.id_profissional = p.id " +
                     "LEFT JOIN servico s ON a.id_servico = s.id " +
                     "ORDER BY a.data_hora";
                             
        try (Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                
                Cliente cliente = new Cliente(
                        rs.getInt("c_id"),
                        rs.getString("c_nome"),
                        rs.getString("c_telefone")
                );
                cliente.setWhatsapp(rs.getString("c_whatsapp"));
                
                
                Profissional profissional = new Profissional(
                        rs.getInt("p_id"),
                        rs.getString("p_nome"),
                        rs.getString("p_esp"),
                        rs.getString("p_horario")
                );
                
                Servico servico = new Servico(
                        rs.getInt("s_id"),
                        rs.getString("s_nome"),
                        rs.getString("s_desc"),
                        rs.getDouble("s_valor"),
                        rs.getInt("s_duracao")
                );                
                
                LocalDateTime dataHora = rs.getTimestamp("data_hora").toLocalDateTime();
                
                Agendamento ag = new Agendamento(
                        rs.getInt("id"),
                        cliente,
                        profissional,
                        servico,
                        dataHora
                );
                
                lista.add(ag);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;             
    }
    
    
    public void inserir(Agendamento ag) {
        String sql = "INSERT INTO agendamento (id_cliente, id_profissional, id_servico, data_hora) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, ag.getCliente().getId());
            stmt.setInt(2, ag.getProfissional().getId());
            stmt.setInt(3, ag.getServico().getId());
            
            if (ag.getDataHora() != null) {
                stmt.setTimestamp(4, Timestamp.valueOf(ag.getDataHora()));
            } else {
                stmt.setTimestamp(4, null);
            }
            
            stmt.executeUpdate();
            
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    int idGerado = keys.getInt(1);
                    ag.setId(idGerado);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
