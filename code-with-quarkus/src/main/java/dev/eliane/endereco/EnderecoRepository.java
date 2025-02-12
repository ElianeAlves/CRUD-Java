package dev.eliane.endereco;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import dev.eliane.endereco.Endereco;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
}

