package dao;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Usuario;
import util.JPAUtil;

public class UsuarioDao {
	public static void salvar(Usuario usuario) {
		if (verificarUsuarioExistente(usuario)) {
			throw new RuntimeException("Já existe um usuário com o mesmo nome e data de nascimento.");
		}
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Usuario usuario) {
		if (verificarUsuarioExistente(usuario)) {
			throw new RuntimeException("Já existe um usuário com o mesmo nome e data de nascimento.");
		}
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
	
	private static boolean verificarUsuarioExistente(Usuario usuario){
		EntityManager em = JPAUtil.criarEntityManager();
        Query q = em.createQuery("select u from Usuario u where u.nome = :nome or u.dataNascimento = :dataNascimento");

		q.setParameter("nome", usuario.getNome());
		q.setParameter("dataNascimento", usuario.getDataNascimento());
		
		List<Usuario> resultados = q.getResultList();
		em.close();
        return !resultados.isEmpty() && (resultados.size() > 1 || !resultados.get(0).getId().equals(usuario.getId()));

	}
}
