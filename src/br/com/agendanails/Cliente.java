package br.com.agendanails;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String whatsapp;
    
    public Cliente() {
    }
    
    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.whatsapp = "";
    }

    public Cliente(String nome, String telefone, String whatsapp) {
        this.id = 0;
        this.nome = nome;
        this.telefone = telefone;
        this.whatsapp = whatsapp;
    }
    
    public Cliente(String nome, String telefone) {
        this(0, nome, telefone);
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    
    public String getWhatsapp() { return whatsapp; }
    public void setWhatsapp(String whatsapp) { this.whatsapp = whatsapp; }
    
    @Override
    public String toString() {
        return nome + " - " + telefone;
    }       
}
