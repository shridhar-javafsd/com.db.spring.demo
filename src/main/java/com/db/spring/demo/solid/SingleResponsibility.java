package com.db.spring.demo.solid;

import java.util.ArrayList;

public class SingleResponsibility {

}

class Board {
	int size;
	ArrayList<String> spots;

	public Board(int size) {
		this.size = size;
		this.spots = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			this.spots.add(String.valueOf(3 * i));
			this.spots.add(String.valueOf(3 * i + 1));
			this.spots.add(String.valueOf(3 * i + 2));
		}
	}

	public ArrayList<String> valuesAt(ArrayList<Integer> indexes) {
		ArrayList<String> values = new ArrayList<String>();

		for (int index : indexes) {
			values.add(this.spots.get(index));
		}

		return values;
	}
}

class BoardPresenter {
	Board board;

	public BoardPresenter(Board board) {
		this.board = board;
	}

	public void displayBoard() {
		String formattedBoard = "";
		for (int i = 0; i < this.board.size * this.board.size; i++) {
			String borderOrNewline = "";
			if ((i + 1) % board.size == 0) {
				borderOrNewline += "\n";
			} else {
				borderOrNewline += "|";
			}
			formattedBoard += board.spots.get(i);
			formattedBoard += borderOrNewline;
		}
		System.out.print(formattedBoard);
	}
}

//class BoardShaper {
//	int size;
//
//	public BoardShaper(int size) {
//		this.size = size;
//	}
//
//	public ArrayList<ArrayList<Integer>> rowIndexes() {
//		ArrayList<ArrayList<Integer>> rowIndexes = new ArrayList<ArrayList<Integer>>();
//
//		for (int i = 0; i < this.size; i++) {
//			ArrayList<Integer> row = new ArrayList<Integer>();
//			for (int j = 0; j < this.size; j++) {
//				row.add((i * size) + (j));
//			}
//			rowIndexes.add(row);
//		}
//
//		return rowIndexes;
//	}
//}

class BoardShaper {
	int size;

	public BoardShaper(int size) {
		this.size = size;
	}

	public ArrayList<ArrayList<Integer>> rowIndexes() {
		ArrayList<ArrayList<Integer>> rowIndexes = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < this.size; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < this.size; j++) {
				row.add((i * size) + (j));
			}
			rowIndexes.add(row);
		}

		return rowIndexes;
	}
}
