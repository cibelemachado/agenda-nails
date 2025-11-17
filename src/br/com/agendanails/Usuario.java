package br.com.agendanails;

public class Usuario {
    private int id;
    private String nome;
    private String senhaHash;
    private String tipo; // "GERENTE" ou "ATENDENTE"
    
    public Usuario(int id, String nome, String senhaHash, String tipo) {
        this.id = id;
        this.nome = nome;
        this.senhaHash = senhaHash;
        this.tipo = tipo;
    }
    
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getSenhaHash() { return senhaHash; }
    public String getTipo() { return tipo; }
    
    public boolean isGerente() { return "GERENTE".equalsIgnoreCase(tipo); }
}
