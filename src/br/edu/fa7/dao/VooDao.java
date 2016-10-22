package br.edu.fa7.dao;

import br.edu.fa7.model.Voo;

import java.util.List;


public class VooDao extends GenericDao<Voo> {

    public VooDao() throws Exception {
        super();
    }

    @SuppressWarnings("unchecked")
    public List<Voo> getVoos(String sigla, String numero) throws Exception {
        String consulta = "from Voo v where v.sigla like :sigla and v.numero like :numero " +
                "and c.estaAtivo = true";
        return (List<Voo>) super.session.createQuery(consulta).setParameter("nome", "%" + numero + "%").setParameter("sigla", "%" + sigla + "%").list();
    }

}
