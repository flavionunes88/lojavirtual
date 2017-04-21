package persistencia;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTeste {
    
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.close();
		HibernateUtil.getSessionFactory().close();
	}
	
}
