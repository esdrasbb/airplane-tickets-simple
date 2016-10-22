package br.edu.fa7.dao;

import br.edu.fa7.model.EmpresaAerea;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class EmpresaAereaDao extends GenericDao<EmpresaAerea> {

    public EmpresaAereaDao() throws Exception {
        super();
    }

    @SuppressWarnings("unchecked")
    public List<EmpresaAerea> getEmpresasAerea(String nome) throws Exception {
        String consulta = "from EmpresaAerea ea where ea.nome like :nome " +
                "and ea.estaAtivo = true";
        return (List<EmpresaAerea>) super.session.createQuery(consulta).setParameter("nome", "%" + nome + "%").list();
    }

    @SuppressWarnings("unchecked")
    public List<EmpresaAerea> getEmpresasAereaCriteria(String nome) throws Exception {
        List<EmpresaAerea> empresaAerea = super.session.createCriteria(EmpresaAerea.class)
                .add(Restrictions.like("nome", "%" + nome + "%"))
                .add(Restrictions.eq("estaAtivo", true)).list();

        return empresaAerea;
    }

}
