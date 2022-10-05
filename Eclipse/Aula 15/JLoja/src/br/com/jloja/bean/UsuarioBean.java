package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jloja.DAO.UsuarioDAO;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "usuarioMB")
@SessionScoped

public class UsuarioBean {

	public List<UsuarioEntity> listaUsuarios;
	public List<UsuarioEntity> listaUsuariosFiltrados;
	private UsuarioEntity usuarioEntity;
	private Long codigo;
	
	public List<UsuarioEntity> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<UsuarioEntity> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public List<UsuarioEntity> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}
	public void setListaUsuariosFiltrados(List<UsuarioEntity> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
	}
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public UsuarioBean(){
		this.usuarioEntity = new UsuarioEntity();
		
	}
	
	public void listarUsuario() {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			listaUsuarios = usuDAO.listar();
			
		}catch (Exception ex){
			throw ex;
		}
	}
	
	public void adicionarUsuario() {
		try{
			UsuarioDAO usudao = new UsuarioDAO();
			usudao.adicionar(usuarioEntity);
			usuarioEntity = new UsuarioEntity();
			MsgUtil.msgInfo("Usuário gravado com Sucesso!");
		} catch (Exception ex){
			MsgUtil.msgErro("Erro ao gravar usuário: " + ex.getMessage());
		}
	}
	
	public void buscarUsuarioCodigo(Long codigo){
		try{
			UsuarioDAO fabDAO = new UsuarioDAO();
			usuarioEntity = fabDAO.buscarPorCodigo(codigo);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public void editarUsuario() {
		try {
			UsuarioDAO fabdao = new UsuarioDAO();
			fabdao.editar(usuarioEntity);
			usuarioEntity = new UsuarioEntity();
			MsgUtil.msgInfo("Usuario editado com sucesso!");
		}catch (Exception ex) {
			MsgUtil.msgErro("Erro ao tentar editar um usuario: " + ex.getMessage());
		}
	}
	
	public void excluirUsuario() {
		try {
			UsuarioDAO fabdao = new UsuarioDAO();
			fabdao.excluir(usuarioEntity);
			usuarioEntity = new UsuarioEntity();
			MsgUtil.msgInfo("Usuario excluido com Sucesso!");
		} catch (Exception ex) {
			MsgUtil.msgErro("Erro ao tentar excluir usuario: " + ex.getMessage());
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
