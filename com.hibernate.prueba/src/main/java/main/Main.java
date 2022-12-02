package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

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
		
		for(Iterator i=animales.iterator();i.hasNext();) {
			Animal a=(Animal)i.next();
			System.out.println(a.getNombre());
		}
		session.close();
		
	}

}
