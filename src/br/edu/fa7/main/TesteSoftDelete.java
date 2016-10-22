package br.edu.fa7.main;

import br.edu.fa7.factory.HibernateFactory;
import br.edu.fa7.model.Voo;
import org.hibernate.Session;

public class TesteSoftDelete {
    public static void main(String[] args) throws Exception {

        Session session = HibernateFactory.getHibernateSession();
        session.getTransaction().begin();

        Voo voo = (Voo) session.get(Voo.class, new Integer(2));

        if (voo != null) {
            System.out.println(voo);

            session.delete(voo);
        }

        session.getTransaction().commit();

    }
}
