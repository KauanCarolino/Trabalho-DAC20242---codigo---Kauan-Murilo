package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Usuario;
import util.JPAUtil;

public class UsuarioDao {
	public static void salvar(Usuario usuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Usuario usuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Usuario achar(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Usuario pessoa = em.find(Usuario.class, id);
		em.close();
		return pessoa;
	}
	
	public static void Deletar(Usuario usuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		usuario = em.find(Usuario.class, usuario.getId());
		em.remove(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Usuario> ListarTodos(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select a from Pessoa a");
		List<Usuario> lista = q.getResultList();
		em.close();
		return lista;
		
	}
}