package com.pragmaticplay.tictactoe.db.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Id {
	
	private Long id;
	
	public Id() {
	}

	public Id(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Id other = (Id) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj))
				.append(id, other.id)
				.build();
	}
}
