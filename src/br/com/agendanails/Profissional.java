package br.com.agendanails;

public class Profissional {
    private int id;
    private String nome;
    private String especialidade;
    private String horario;  
    
    public Profissional(int id, String nome, String especialidade, String horario) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;        
        this.horario = horario;
    }

    public Profissional(String nome, String especialidade, String horario) {
        this(0, nome, especialidade, horario);
    }
     
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
      
    @Override
    public String toString() {
        return nome + " (" + especialidade + " - " + horario + ")"; 
    }
}
