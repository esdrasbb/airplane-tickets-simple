package br.edu.fa7.main;

import br.edu.fa7.factory.HibernateFactory;
import org.hibernate.Session;


public class TesteCache {

    public static void main(String[] args) throws Exception {

        String consulta = "from Faculdade f where f.nome like :nome " +
                "and f.estaAtivo = true";

        Session session = HibernateFactory.getHibernateSession();
        session.getTransaction().begin();

        session.createQuery(consulta).setParameter("nome", "%fa7%").setCacheable(true).list();

        session.getTransaction().commit();

        Session session2 = HibernateFactory.getHibernateSession();

        session2.getTransaction().begin();

        session2.createQuery(consulta).setParameter("nome", "%fa7%").setCacheable(true).list();

        session2.getTransaction().commit();

    }
}
