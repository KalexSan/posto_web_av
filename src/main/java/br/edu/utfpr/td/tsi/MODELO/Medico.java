package br.edu.utfpr.td.tsi.MODELO;

public class Medico {
    private Long id;
    private String nome;
    private String sobrenome;


    public Medico(Long id, String nome, String sobrenome) {
        super();
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


}
