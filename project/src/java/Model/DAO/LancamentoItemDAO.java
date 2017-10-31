/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.LancamentoItem;
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
public class LancamentoItemDAO {
    public static void save(LancamentoItem l) {
        SessionFactory sf = HibernateInstance.getSessionFactory();
        Session session = sf.openSession();                     
        
        Transaction tx = session.beginTransaction();
        
        session.saveOrUpdate(l);        
        
        tx.commit();
        
        session.flush();
        
        session.close();
    }
    
    public static LancamentoItem getLancamentoItemByID(int id) {
        SessionFactory sf = HibernateInstance.getSessionFactory();
        Session session = sf.openSession();
                
        SQLQuery q = session.createSQLQuery("select * from lancamentoItem where id = :id");
        q.addEntity(LancamentoItem.class);  
        
        q.setParameter("id", id);
        
        List<LancamentoItem> l = q.list();               
        
        session.flush();
        
        session.close();
        
        return l.get(0);
    }
    
    public static List<LancamentoItem> getAllLancamentoItem() {
        SessionFactory sf = HibernateInstance.getSessionFactory();
        Session session = sf.openSession();
                
        SQLQuery q = session.createSQLQuery("select * from lancamentoItem");
        q.addEntity(LancamentoItem.class);                  
        
        List<LancamentoItem> l = q.list();               
        
        session.flush();
        
        session.close();
        
        return l;
    }
    
    public static List<LancamentoItem> getLancamentoItemByLancamentoID(int id) {
        try {
            SessionFactory sf = HibernateInstance.getSessionFactory();
            Session session = sf.openSession();

            SQLQuery q = session.createSQLQuery("select * from lancamentoItem where oid_lancamento = :id");
            q.addEntity(LancamentoItem.class);                  

            q.setParameter("id", id);

            List<LancamentoItem> l = q.list();               

            session.flush();

            session.close();                

            return l;
        } catch(Exception e) {
            return null;
        }
    }
    
    public static void remove(LancamentoItem li) {
        try {
            SessionFactory sf = HibernateInstance.getSessionFactory();
            Session session = sf.openSession();
            
            Transaction tx = session.beginTransaction();
            
            session.delete(li);
                        
            tx.commit();
            
            session.flush();

            session.close();                
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
