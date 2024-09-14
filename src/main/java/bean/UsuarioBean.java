package bean;

import javax.faces.bean.ManagedBean;

import dao.UsuarioDao;
import entidade.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void salvar() {
		UsuarioDao.salvar(usuario);
	}
	
	public void editar() {
		UsuarioDao.editar(usuario);
	}
	
	public void carregarUsuario() {
		if (usuario != null) {
			
		}
	}
	
}
