/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Lancamento;
import Utils.HibernateInstance;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Matheus Henrique Pitz
 */
public class LancamentoDAO {
    public static void save(Lancamento l) {
        SessionFactory sf = HibernateInstance.getSessionFactory();
        Session session = sf.openSession();                     
        
        Transaction tx = session.beginTransaction();
        
        session.saveOrUpdate(l);        
        
        tx.commit();
        
        session.flush();
        
        session.close();
    }
    
    public static List<Lancamento> getAllLancamentos() {
        try {
            SessionFactory sf = HibernateInstance.getSessionFactory();
            Session session = sf.openSession();

            SQLQuery q = session.createSQLQuery("select * from lancamento");
            q.addEntity(Lancamento.class);        
            List<Lancamento> l = q.list();               

            session.flush();

            session.close();

            return l;
        } catch(Exception e) {
            return null;
        }
    }
    
    public static Lancamento getLancamentoByID(int id) {
        try {
            SessionFactory sf = HibernateInstance.getSessionFactory();
            Session session = sf.openSession();

            SQLQuery q = session.createSQLQuery("select * from lancamento where oid = :id");
            q.addEntity(Lancamento.class);  

            q.setParameter("id", id);

            List<Lancamento> l = q.list();               

            session.flush();

            session.close();

            return l.get(0);
        } catch(Exception e) {
            return null;
        }
    }
}
