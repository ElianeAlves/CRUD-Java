package dev.eliane.pessoa;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {


    public void postPessoa(Pessoa pessoa) {
        this.persist(pessoa);
    }
}
