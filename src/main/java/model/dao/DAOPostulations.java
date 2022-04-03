package model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.bo.Postulations;
import model.service.HibernateUtil;

public class DAOPostulations {

	
	public void postuler(Postulations p) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			session.save(p);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
}
