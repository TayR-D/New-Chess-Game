package pieces;

import java.util.ArrayList;

import main.Board;
import main.Pieces;
import main.Square;

public class Horse extends Pieces{
	public Horse(boolean isWhite) {
        super("Horse", isWhite);
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
				if (sq.getRow() - 2 == current_row && sq.getCol() - 1 == current_col)
					Movable_square.add(sq);

				if (sq.getRow() - 1 == current_row && sq.getCol() - 2 == current_col)
					Movable_square.add(sq);

				if (sq.getRow() + 2 == current_row && sq.getCol() + 1 == current_col)
					Movable_square.add(sq);

				if (sq.getRow() + 1 == current_row && sq.getCol() + 2 == current_col)
					Movable_square.add(sq);
				
				if (sq.getRow() - 2 == current_row && sq.getCol() + 1 == current_col)
					Movable_square.add(sq);
				
				if (sq.getRow() - 1 == current_row && sq.getCol() + 2 == current_col)
					Movable_square.add(sq);

				if (sq.getRow() + 2 == current_row && sq.getCol() - 1 == current_col)
					Movable_square.add(sq);

				if (sq.getRow() + 1 == current_row && sq.getCol() - 2 == current_col)
					Movable_square.add(sq);
			}
		}
		
		return Movable_square;
	}
}