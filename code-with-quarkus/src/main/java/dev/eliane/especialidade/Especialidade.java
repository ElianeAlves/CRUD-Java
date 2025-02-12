package dev.eliane.especialidade;

public enum Especialidade {
    FRONT_END("Desenvolvedor Front End"),
    BACK_END("Desenvolvedor Back End"),
    FULL_STACK("Desenvolvedor Full Stack");

    private String descricao;

    // Construtor
    Especialidade(String descricao) {
        this.descricao = descricao;
    }

    // Getter
    public String getDescricao() {
        return descricao;
    }
}
