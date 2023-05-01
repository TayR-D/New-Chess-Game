package pieces;

import java.util.ArrayList;

import main.Board;
import main.Pieces;
import main.Square;

public class King extends Pieces{
	Square[] MovableSquare = new Square[8];

	public King(boolean isWhite) {
		super("King", isWhite);
	}

	@Override
	public ArrayList<Square> checkMovableSquare(Square currentSquare) {
		Square[][] Grid = Board.getSquareArray();
		ArrayList<Square> Movable_square = new ArrayList<>();
		int current_row = currentSquare.getRow();
		int current_col = currentSquare.getCol();

		Movable_square.add(currentSquare);
		for (Square[] grid_row: Grid){
			for(Square sq: grid_row){
				int sq_row = sq.getRow();
				int sq_col = sq.getCol();
				if (sq_row == current_row - 1 || sq_row == current_row + 1 || sq_row == current_row){
					if (sq_col >= current_col - 1 && sq_col <= current_col + 1){
						Movable_square.add(sq);
					}
				}
			}
		}
		
		return Movable_square;
	}
}