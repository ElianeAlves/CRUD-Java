package dev.eliane.pessoa;

import dev.eliane.endereco.Endereco;
import dev.eliane.especialidade.Especialidade;
import jakarta.persistence.*;

@Entity
@Table(name = "pessoa")  // Nome da tabela no banco de dados
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID gerado automaticamente pelo banco de dados
    private Long id;

    private String nome;
    private String sobrenome;
    private Integer idade;

    @OneToOne
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    // Getters e setters para os atributos
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
