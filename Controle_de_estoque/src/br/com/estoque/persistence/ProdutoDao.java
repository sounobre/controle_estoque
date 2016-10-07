package br.com.estoque.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.com.estoque.model.Produto;

public class ProdutoDao {
	
	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;
	
	public void cadastrar(Produto produto)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(produto);
		transaction.commit();
		session.close();
		
	}
	
	public List<Produto> listar()throws Exception {
			session = HibernateUtil.getSessionFactory().openSession();
			criteria = session.createCriteria(Produto.class);
			criteria.addOrder(Order.asc("nome"));
			List<Produto> lista = criteria.list();
			session.close();
		
		return lista;
	}
	
	public void deletar(Produto produto) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(produto);
		transaction.commit();
		session.close();
	}
	
	public void editar(Produto produto) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction =session.beginTransaction();
		session.update(produto);
		transaction.commit();
		session.close();
			
	}
	
	public Produto buscarid(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
		Produto p = (Produto) session.get(Produto.class, id);
		session.close();
		return p;
		
	}
}
