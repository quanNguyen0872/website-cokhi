package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.Category;
import entity.Customer;

public class App {

	public static void main(String[] args) {
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(OrderDetail.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Customer.class)
				.getMetadataBuilder()
				.build();
		
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			
			
			
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
