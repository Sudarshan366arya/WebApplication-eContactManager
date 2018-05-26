package net.viralpatel.contact.controller;
import net.viralpatel.contact.model.Contact;
import net.viralpatel.contact.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class ContactManager extends HibernateUtil {

	public Contact add(Contact contact) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(contact);
		session.getTransaction().commit();
		return contact;
	}
	public Contact updatedone(Contact contact) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(contact);
		session.getTransaction().commit();
		return contact;
	}
	public Contact delete(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Contact contact = (Contact)session.load(Contact.class, id);
		if(null != contact) {
			session.delete(contact);
		}
		session.getTransaction().commit();
		return contact;
	}
	
	public Contact update(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Contact contact = (Contact)session.load(Contact.class, id);
		if(null != contact) {
			System.out.println("-----------------------First Name "+contact.getFirstname());
			System.out.println("-----------------------Last Name "+contact.getLastname());
			System.out.println("-----------------------Date Of Birth "+contact.getBirthdate());
		}
		session.getTransaction().commit();
		return contact;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> list() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Contact> contacts = null;
		try {
			contacts = (List<Contact>)session.createQuery("from Contact").list();
		    } catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return contacts;
	}
	@SuppressWarnings("unchecked")
	public List<Contact> search(String name,String lastname,String emailId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Contact.class);
        if(name != null){				
        	criteria.add(Restrictions.ilike("firstname", "%"+name+"%"));
        }
		if(lastname!=null){
			criteria.add(Restrictions.ilike("lastname", "%"+lastname+"%"));
		}
       if(emailId!=null){
    	   criteria.add(Restrictions.ilike("emailId", "%"+emailId+"%"));
		}
		List<Contact> contacts = criteria.list();
		if(contacts.size() > 0)
		{
			return contacts;
		}
		else
		{
			return Collections.emptyList();
		}	
	}
}
