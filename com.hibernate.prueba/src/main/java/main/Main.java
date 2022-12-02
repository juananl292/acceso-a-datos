package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import pojo.Animal;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		
		//Animal a1= new Animal("Yorkshire","Casa",new BigDecimal(1));
		//session.save(a1);
		int id=1;
		Animal ar=(Animal)session.get(Animal.class, id);
		System.out.println(ar.getNombre());
		
		
		List animales= session.createQuery("FROM Animal").getResultList();
		String hql ="FROM Animal WHERE habitat = :habitat";
		Query query= session.createQuery(hql);
		query.setParameter("habitat", "casa");
		List animales1=query.getResultList();
		for(Iterator i=animales1.iterator();i.hasNext();) {
			Animal a=(Animal)i.next();
			System.out.println(a.getNombre());
		}
		session.close();
		
	}

}
