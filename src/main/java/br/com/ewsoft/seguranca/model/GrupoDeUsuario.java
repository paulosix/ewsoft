package br.com.ewsoft.seguranca.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.ewsoft.model.utils.BaseEntities;
import br.com.ewsoft.seguranca.model.types.TipoNivelDeGrupo;

@Entity
public class GrupoDeUsuario extends BaseEntities<Long> {

	private static final long serialVersionUID = 1L;

	private Long grupoDeUsuarioId;
	private TipoNivelDeGrupo tipoNivelDeGrupo;
	private GrupoDeUsuario grupoDeUsuarioSuperior;
	private Long grupoDeUsuariosAcessoSimultanios;
	private boolean grupoDeUsuariosExclusivo;
	private Date grupoDeUsuariosInclusao;
	private Date grupoDeUsuariosEdicao;
	private boolean grupoDeUsuariosAtivo;
	private boolean grupoDeUsuarioDeletado;

	@Id
	@SequenceGenerator(name = "grupoDeUsuarioID", sequenceName = "Seguranca.GruposDeUsuarios_grupoDeUsuarioID_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "grupoDeUsuarioID")
	public Long getGrupoDeUsuarioId() {
		return grupoDeUsuarioId;
	}

	public void setGrupoDeUsuarioId(Long grupoDeUsuarioId) {
		this.grupoDeUsuarioId = grupoDeUsuarioId;
	}

	public TipoNivelDeGrupo getTipoNivelDeGrupo() {
		return tipoNivelDeGrupo;
	}

	public void setTipoNivelDeGrupo(TipoNivelDeGrupo tipoNivelDeGrupo) {
		this.tipoNivelDeGrupo = tipoNivelDeGrupo;
	}

	public GrupoDeUsuario getGrupoDeUsuarioSuperior() {
		return grupoDeUsuarioSuperior;
	}

	public void setGrupoDeUsuarioSuperior(GrupoDeUsuario grupoDeUsuarioSuperior) {
		this.grupoDeUsuarioSuperior = grupoDeUsuarioSuperior;
	}

	public Long getGrupoDeUsuariosAcessoSimultanios() {
		return grupoDeUsuariosAcessoSimultanios;
	}

	public void setGrupoDeUsuariosAcessoSimultanios(
			Long grupoDeUsuariosAcessoSimultanios) {
		this.grupoDeUsuariosAcessoSimultanios = grupoDeUsuariosAcessoSimultanios;
	}

	public boolean isGrupoDeUsuariosExclusivo() {
		return grupoDeUsuariosExclusivo;
	}

	public void setGrupoDeUsuariosExclusivo(boolean grupoDeUsuariosExclusivo) {
		this.grupoDeUsuariosExclusivo = grupoDeUsuariosExclusivo;
	}

	public Date getGrupoDeUsuariosInclusao() {
		return grupoDeUsuariosInclusao;
	}

	public void setGrupoDeUsuariosInclusao(Date grupoDeUsuariosInclusao) {
		this.grupoDeUsuariosInclusao = grupoDeUsuariosInclusao;
	}

	public Date getGrupoDeUsuariosEdicao() {
		return grupoDeUsuariosEdicao;
	}

	public void setGrupoDeUsuariosEdicao(Date grupoDeUsuariosEdicao) {
		this.grupoDeUsuariosEdicao = grupoDeUsuariosEdicao;
	}

	public boolean isGrupoDeUsuariosAtivo() {
		return grupoDeUsuariosAtivo;
	}

	public void setGrupoDeUsuariosAtivo(boolean grupoDeUsuariosAtivo) {
		this.grupoDeUsuariosAtivo = grupoDeUsuariosAtivo;
	}

	public boolean isGrupoDeUsuarioDeletado() {
		return grupoDeUsuarioDeletado;
	}

	public void setGrupoDeUsuarioDeletado(boolean grupoDeUsuarioDeletado) {
		this.grupoDeUsuarioDeletado = grupoDeUsuarioDeletado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((grupoDeUsuarioId == null) ? 0 : grupoDeUsuarioId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDeUsuario other = (GrupoDeUsuario) obj;
		if (grupoDeUsuarioId == null) {
			if (other.grupoDeUsuarioId != null)
				return false;
		} else if (!grupoDeUsuarioId.equals(other.grupoDeUsuarioId))
			return false;
		return true;
	}
}
