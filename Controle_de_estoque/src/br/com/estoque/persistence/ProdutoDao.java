package br.com.estoque.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.estoque.model.Produto;

public class ProdutoDao {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public void cadastrar(Produto p)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();
		
	}
	
	public List<Produto> listar()throws Exception {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Produto> lista = new ArrayList<Produto>();
			query = session.createQuery("from produto");
			session.close();
		
		return lista;
	}

}
