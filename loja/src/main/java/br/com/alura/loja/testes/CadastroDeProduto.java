package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		
		Produto celular = new Produto("Xiaomi", "Legal", new BigDecimal("800"), celulares );
//		celular.setNome();
//		celular.setDescricao();
//		celular.setPreco();

//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("loja");
//		
//		EntityManager em = factory.createEntityManager();

		// conf de acesso ao banco
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);

		// persistindo dados
		em.getTransaction().begin();
//		em.persist(celular);
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
