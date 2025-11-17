package br.com.agendanails;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {
    private int id;
    private Cliente cliente;
    private Profissional profissional;
    private Servico servico;
    private LocalDateTime dataHora;
    
    public Agendamento(int id, Cliente cliente, Profissional profissional, Servico servico, LocalDateTime dataHora) {
        this.id = id;
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public Agendamento(Cliente cliente, Profissional profissional, Servico servico, LocalDateTime dataHora) {
        this(0, cliente, profissional, servico, dataHora);
    }
    
    public Agendamento(Cliente cliente, Profissional profissional, Servico servico, String dataHoraStr) {
        this.id = 0;
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            this.dataHora = LocalDateTime.parse(dataHoraStr, formatter);
        } catch (Exception e) {
            // caso o formato não seja o ideal, salva o horário atual
            this.dataHora = LocalDateTime.now();
        }
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
     
    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }
    
    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }
    
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Agendamento de " + cliente.getNome() + " com " +
                profissional.getNome() + " para " + servico.getNome() +                
                " em " + dataHora.format(formatter);
    }    
}
