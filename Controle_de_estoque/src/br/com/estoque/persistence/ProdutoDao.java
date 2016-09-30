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
	
	public void cadastrar(Produto produto)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(produto);
		transaction.commit();
		session.close();
		
	}
	
	public List<Produto> listar()throws Exception {
			session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("select p from produto p order by p.id");
			List<Produto> lista = query.list();
			session.close();
		
		return lista;
	}

}
