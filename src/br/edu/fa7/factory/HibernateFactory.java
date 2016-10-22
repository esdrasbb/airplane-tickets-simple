package br.edu.fa7.factory;

import br.edu.fa7.util.AuditInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

    private static SessionFactory sf;

    public static synchronized Session getHibernateSession() throws Exception {
        if (sf == null) {
            Configuration c = new Configuration();
            c.setInterceptor(new AuditInterceptor());
            sf = c.configure().buildSessionFactory();

        }
        Session s = sf.getCurrentSession();
        return s;
    }
}
