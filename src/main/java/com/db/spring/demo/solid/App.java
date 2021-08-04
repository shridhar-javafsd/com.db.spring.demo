package com.db.spring.demo.solid;

public class App {

	public static void main(String[] args) {

		// single respo
		Board board = new Board(3);
		BoardPresenter boardPresenter = new BoardPresenter(board);
		boardPresenter.displayBoard();
		BoardShaper boardShaper = new BoardShaper(3);
		System.out.println(boardShaper.rowIndexes());

		Personality personality = new CasualPersonality();
		Greeter greeter = new Greeter(personality);
		System.out.println(greeter.greet());
		
		personality = new FormalPersonality();
		Greeter greeter2 = new Greeter(personality);
		System.out.println(greeter2.greet());
		
		personality = new IntimatePersonality();
		Greeter greeter3 = new Greeter(personality);
		System.out.println(greeter3.greet());

	}

}
