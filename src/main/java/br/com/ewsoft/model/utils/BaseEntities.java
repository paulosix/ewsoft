package br.com.ewsoft.model.utils;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

public abstract class BaseEntities<PK extends Serializable> extends AbstractPersistable<PK> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void setId(PK id){
		super.setId(id);
	}

	@Override
	public boolean equals(Object obj){
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
