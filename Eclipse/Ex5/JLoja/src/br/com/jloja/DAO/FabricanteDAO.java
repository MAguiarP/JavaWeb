package br.com.jloja.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.util.HibernateUtil;

public class FabricanteDAO {

	public void adicionar(FabricanteEntity fabricante){
		
		Session sessao  = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
		    transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();
		} catch(Exception ex){
			if(transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

public void editar(FabricanteEntity fabricante){
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	
	try{
		transacao = sessao.beginTransaction();
		sessao.update(fabricante);
		transacao.commit();
	} catch(Exception ex){
		if (transacao != null){
			transacao.rollback();
		}
	} finally {
		sessao.close();
	}
}
	
	public static void main(String[] args) {
		FabricanteEntity fab1 = new FabricanteEntity();
		fab1.setDescricao("Paulo");
		FabricanteDAO fabDAO = new FabricanteDAO();
		fabDAO.adicionar(fab1);
	}
}

