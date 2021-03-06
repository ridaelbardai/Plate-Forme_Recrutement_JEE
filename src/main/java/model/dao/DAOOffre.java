package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.UserController;
import model.bo.Offre;
import model.bo.Postulations;
import model.bo.User;
import model.service.HibernateUtil;

public class DAOOffre {
	public void insererOffre(Offre o) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			session.save(o);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}


	public List<Offre> getListOffres() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("FROM Offre WHERE id NOT IN( SELECT offre FROM Postulations WHERE demandeur ="+ UserController.userSession.getId()+")").list();
	}

	public Offre getOffreByID(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		return session.load(Offre.class, id);
	}
	
	
	public void updateOffre(Offre o) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.update(o);
			// commit transaction
			session.flush();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.getMessage();
		}

	}
	
	
	public void supprimerOffre(Offre o) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.delete(o);
			System.out.println("Dans supprimerOffre");
			// commit transaction
			session.flush();
			transaction.commit();
			session.close();
		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
			e.getMessage();
		}
	}


	public List<Offre> getListOffresadmin() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("FROM Offre WHERE createur ="+ UserController.userSession.getId()).list();
	}



}
