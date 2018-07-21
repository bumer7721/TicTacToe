package com.pragmaticplay.tictactoe.db.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Step extends Id {

	private Long gameId;
	private Integer numberOfStep;
	private Integer x;
	private Integer y;
	
	public Step() {
	}
	
	public Step(Long gameId, Integer numberOfStep, Integer x, Integer y) {
		super();
		this.gameId = gameId;
		this.numberOfStep = numberOfStep;
		this.x = x;
		this.y = y;
	}
	
	public Step(Long id, Long gameId, Integer numberOfStep, Integer x, Integer y) {
		super(id);
		this.gameId = gameId;
		this.numberOfStep = numberOfStep;
		this.x = x;
		this.y = y;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Integer getNumberOfStep() {
		return numberOfStep;
	}

	public void setNumberOfStep(Integer numberOfStep) {
		this.numberOfStep = numberOfStep;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.appendSuper(super.hashCode())
				.append(gameId)
				.append(numberOfStep)
				.append(x)
				.append(y)
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
		Step other = (Step) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj))
				.append(gameId, other.gameId)
				.append(numberOfStep, other.numberOfStep)
				.append(x, other.x)
				.append(y, other.y)
				.build();
	}
}
