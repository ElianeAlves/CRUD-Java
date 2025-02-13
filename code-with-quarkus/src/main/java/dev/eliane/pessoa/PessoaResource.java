package dev.eliane.pessoa;

import dev.eliane.endereco.EnderecoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/pessoa")
public class PessoaResource {

    @Inject
    PessoaRepository pessoaRepository;
    @Inject
    EnderecoRepository enderecoRepository;

    @GET
    public Response getTodasPessoas() {
        List<Pessoa> pessoas = pessoaRepository.listAll();
        return Response.ok(pessoas).build();
    }

    @POST
    @Transactional
    public Response postPessoa(Pessoa pessoa) {
        if (pessoa.getEndereco() != null) {
            enderecoRepository.persist(pessoa.getEndereco());
        }
        pessoaRepository.persist(pessoa);
        return Response.ok(pessoa).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletePessoa(@PathParam("id") Long id) {
        boolean deleted = pessoaRepository.deleteById(id);
        if (deleted) return Response.ok("Registro de pessoa removido.").build();
        else return Response.status(Response.Status.NOT_FOUND).entity("Pessoa não encontrada").build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response putPessoa(@PathParam("id") Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = pessoaRepository.findById(id);

        if (pessoaExistente == null)
            return Response.status(Response.Status.NOT_FOUND).entity("Pessoa não encontrada").build();

        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setIdade(pessoaAtualizada.getIdade());
        pessoaExistente.setSobrenome(pessoaAtualizada.getSobrenome());

        pessoaRepository.persist(pessoaExistente);

        return Response.ok(pessoaExistente).build();
    }
}
