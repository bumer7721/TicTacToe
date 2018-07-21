package com.pragmaticplay.tictactoe.db.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.pragmaticplay.tictactoe.db.enums.Status;

public class Game extends Id {

	private String name;
	private Status status;
	
	public Game() {
	}
	
	public Game(String name, Status status) {
		super();
		this.name = name;
		this.status = status;
	}
	
	public Game(Long id, String name, Status status) {
		super(id);
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.appendSuper(super.hashCode())
				.append(name)
				.append(status)
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
		Game other = (Game) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj))
				.append(name, other.name)
				.append(status, other.status)
				.build();
	}
}
