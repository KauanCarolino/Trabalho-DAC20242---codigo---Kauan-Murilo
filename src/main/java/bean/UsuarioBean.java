package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;
import entidade.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {
    private Usuario usuario = new Usuario();
    private Usuario usuarioSelecionado; 
    private List<Usuario> usuarios;
    private boolean editing = false;
    private long totalUsuarios;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }
    
    public void salvarCad() {
        if (isUsuarioExistente(usuario)) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Já existe um usuário com o mesmo nome e data de nascimento."));
            return;
        }
        UsuarioDao.salvar(usuario);
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuário salvo com sucesso."));
    }
    
    public void salvar() {
        if (usuarioSelecionado == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Nenhum usuário selecionado para editar."));
            return;
        }

        if (isUsuarioExistente(usuarioSelecionado)) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Já existe um usuário com o mesmo nome e data de nascimento."));
            return;
        }

        UsuarioDao.editar(usuarioSelecionado);
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuário atualizado com sucesso."));
        editing = false; // Desativa o modo de edição
        usuarios = UsuarioDao.ListarTodos(); // Atualiza a lista de usuários
    }
    
    public void deletar(Usuario usuario) {
        UsuarioDao.Deletar(usuario);
        usuarios = UsuarioDao.ListarTodos(); // Atualiza a lista de usuários
    }
    
    public void editMode(Usuario usuario) {
        if (isUsuarioExistente(usuarioSelecionado)) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Já existe um usuário com o mesmo nome e data de nascimento."));
            return;
        }
        
        if (editing && usuarioSelecionado != null && usuarioSelecionado.getId().equals(usuario.getId())) {
            salvar(); // Salva as alterações e desativa o modo de edição
        } else {
            this.usuarioSelecionado = usuario;
            this.usuario = usuario; // Populate form with the selected user's data
            this.editing = true; // Ativa o modo de edição
        }
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = UsuarioDao.ListarTodos();
        }
        return usuarios;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    private boolean isUsuarioExistente(Usuario usuario) {
        List<Usuario> usuariosExistentes = UsuarioDao.ListarTodos();
        for (Usuario u : usuariosExistentes) {
            if (u.getNome().equals(usuario.getNome()) && u.getDataNascimento().equals(usuario.getDataNascimento()) && !u.getId().equals(usuario.getId())) {
                return true;
            }
        }
        return false;
    }
    
    public long getTotalUsuarios() {
    	return totalUsuarios;
    }
    
    public void contarUsuarios() {
    	totalUsuarios = UsuarioDao.contarUsuarios();
    }
}
