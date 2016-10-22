package br.edu.fa7.dao;

import br.edu.fa7.model.Cliente;
import br.edu.fa7.model.Passageiro;
import br.edu.fa7.model.Pessoa;


public class PessoaDao extends GenericDao<Pessoa> {

    public PessoaDao() throws Exception {
        super();
    }

    public Cliente getCliente(Integer id) throws Exception {
        String consulta = "from Cliente c where c.id = :id " +
                "and c.estaAtivo = true";
        return (Cliente) super.session.createQuery(consulta).setParameter("id", id).uniqueResult();
    }

    public Passageiro getPassageiro(Integer id) throws Exception {
        String consulta = "from Passageiro p where p.id = :id " +
                "and p.estaAtivo = true";
        return (Passageiro) super.session.createQuery(consulta).setParameter("id", id).uniqueResult();
    }

}
