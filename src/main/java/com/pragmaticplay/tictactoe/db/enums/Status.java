package com.pragmaticplay.tictactoe.db.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
	
	IN_PROGRESS("In progress"),
	X_WON("X won"),
	O_WON("O won"),
	DRAW("Draw")
	;
	
	private String title;
	
	private Status(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public static Status valueOfTitle(String title) {
		return Stream.of(values())
				.filter(s->s.title.equals(title))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Can't parse Status title: " + title));
	}

	@JsonCreator
	public static Status fromString(String title) {
		return Status.valueOfTitle(title);
	}

	@JsonValue
	public String getName() {
		return getTitle();
	}
}
