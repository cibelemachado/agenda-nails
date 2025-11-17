package br.com.agendanails;

import br.com.agendanails.telas.TelaPrincipal;

import br.com.agendanails.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        new TelaPrincipal().setVisible(true);
        
        // Criando serviços
        Servico manicure = new Servico(1, "Manicure", "Limpeza e esmaltação", 50.0, 60);
        Servico pedicure = new Servico(2, "Pedicure", "Cuidado nos pés + esmalte", 70.0, 75);
        
        // Criando profissionais
        Profissional ana = new Profissional(1, "Ana", "Manicure", "08:00 às 17:00");     
        
        Profissional maria = new Profissional(2, "Maria", "Pedicure", "09:00 às 18:00");
           
        // Criando clientes
        Cliente cibele = new Cliente(1, "Cibele Alonso", "19999999999");
        Cliente marta = new Cliente(2, "Marta Silva", "19988888888");
        
        // Lista "in-memory" de agendamentos
        List<Agendamento> agenda = new ArrayList<>();
        
        // Criar um agendamento (protótipo)
        Agendamento a1 = new Agendamento(1, cibele, ana, manicure, LocalDateTime.of(2025, 10, 15, 10, 0));
        agenda.add(a1);
        
        Agendamento a2 = new Agendamento(2, marta, maria, pedicure, LocalDateTime.of(2025, 10, 15, 9,0));
        agenda.add(a2);
        
        // Mostrar agenda (protótipo de visualização)
        System.out.println("=== Agendamentos cadastrados ===");
        for (Agendamento a : agenda ) {
            System.out.print(a);
        }       
    }    
}
