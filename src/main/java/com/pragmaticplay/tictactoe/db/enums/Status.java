package com.pragmaticplay.tictactoe.db.enums;

import java.util.stream.Stream;

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
				.orElse(null);
	}

}
