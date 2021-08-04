package com.db.spring.demo.solid;

public class OpenClose {

}

class Greeter {
	private Personality personality;

	public Greeter(Personality personality) {
		this.personality = personality;
	}

	public String greet() {
		return this.personality.greet();
	}
}

interface Personality {
	public String greet();
}

class CasualPersonality implements Personality {
	public String greet() {
		return "Sup bro?";
	}
}

class FormalPersonality implements Personality {
	public String greet() {
		return "Good evening, sir.";
	}
}

class IntimatePersonality implements Personality {
	public String greet() {
		return "Hello Darling!";
	}
}
