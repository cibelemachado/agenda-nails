package br.com.agendanails;

public class Servico {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    
    public Servico(int id, String nome, String descricao, double preco, int duracaoMin) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;       
    }

    public Servico(String nome, String descricao, double preco, int duracaoMin) {
        this(0, nome, descricao, preco, duracaoMin);
    }
    
    public Servico(String nome, String descricao, double preco) {
        this(0, nome, descricao, preco, 60);
    }
        
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }   
}
