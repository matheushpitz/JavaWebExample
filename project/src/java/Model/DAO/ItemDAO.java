/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Item;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Utils.HibernateInstance;
import org.hibernate.Transaction;

/**
 *
 * @author Matheus Henrique Pitz
 */
public class ItemDAO {
    public static void save(Item i) {
        SessionFactory sf = HibernateInstance.getSessionFactory();
        Session session = sf.openSession();                     
        
        Transaction tx = session.beginTransaction();
        
        session.saveOrUpdate(i);        
        
        tx.commit();
        
        session.flush();
        
        session.close();
    }
    
    public static List<Item> getAllItems() {
        try {
            SessionFactory sf = HibernateInstance.getSessionFactory();
            Session session = sf.openSession();

            SQLQuery q = session.createSQLQuery("select * from item");
            q.addEntity(Item.class);        
            List<Item> i = q.list();               

            session.flush();

            session.close();

            return i;
        } catch(Exception e) {
            return null;
        }
    }
    
    public static Item getItemByID(int id) {
        try {
            SessionFactory sf = HibernateInstance.getSessionFactory();
            Session session = sf.openSession();

            SQLQuery q = session.createSQLQuery("select * from item where oid = :id");
            q.addEntity(Item.class);  

            q.setParameter("id", id);

            List<Item> i = q.list();               

            session.flush();

            session.close();

            return i.get(0);
        } catch(Exception e) {
            return null;
        }
    }
}
