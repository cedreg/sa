package mondial;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hib.Test;
import util.HibernateUtil;


class CountriesAndCities {
    public static void main( String args[] ) throws Exception {
    // Get the session factory we can use for persistence
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	Query query = session.createQuery( "from test" );
	
	Test t = new Test("cedric", "regenass");
	
	
	
	/*
	List<Country> countries = query.list();
	
	for( Country c: countries){
		System.out.format( "%-40s %-20s%n", c.getName(), c.getCapital());
		System.out.print("  Cities: ");
		for( City city: c.getCities()){
			System.out.format( "%s ", city.getId().getName());			
		}
		System.out.println();
	} */
	tx.commit();
	//System.out.format("%nTOTAL: %d%n", countries.size());
	session.close();	
    }
}
