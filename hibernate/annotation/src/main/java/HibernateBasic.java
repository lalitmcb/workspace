import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lalit.hibernate.annotation.model.Student;

public class HibernateBasic {

	public static void main(String[] args) {

		//Get the session from the Session factory
		Session session = HibernateUtil.getSessionFactory().openSession();		
		Transaction tx= session.beginTransaction();		
		
		//Save one student
		Student student = new Student();
		student.setName("Ishana Bhatt");
		student.setAge(8);
		
		Long studentId = (Long)session.save(student);
		
		//Save another student
		Student student1 = new Student();
		student1.setName("E Bhatt");
		student1.setAge(3);
		Long studentId1 = (Long)session.save(student1);
		
		tx.commit();
		session.close();
		
		//Start another unit of work
		session = HibernateUtil.getSessionFactory().openSession();
		tx= session.beginTransaction();		
		
		//Update Student after fetching it
		Student student2 = (Student)session.get(Student.class, studentId1);		
		student2.setName("Ekagra Bhatt");
		
		tx.commit();
		session.close();		
		
		HibernateUtil.shutdown();
	}
}
