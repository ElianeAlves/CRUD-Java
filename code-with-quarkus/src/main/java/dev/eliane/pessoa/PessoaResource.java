package dev.eliane.pessoa;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/pessoa")
public class PessoaResource {

    @Inject
    PessoaRepository pessoaRepository;

    @GET
    public Response getTodasPessoas() {
        List<Pessoa> pessoas = pessoaRepository.listAll(); // Agora busca do banco
        return Response.ok(pessoas).build();
    }

    @POST
    @Transactional
    public Response postPessoa(Pessoa pessoa) {
        pessoaRepository.persist(pessoa);
        return Response.ok(pessoa).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletePessoa(@PathParam("id") Long id) {
        boolean deleted = pessoaRepository.deleteById(id);
        if (deleted) {
            return Response.ok("Registro de pessoa removido.").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Pessoa não encontrada").build();
        }
    }
}
