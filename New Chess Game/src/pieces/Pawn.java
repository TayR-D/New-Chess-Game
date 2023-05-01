package pieces;

import java.util.ArrayList;

import main.Board;
import main.Pieces;
import main.Square;

public class Pawn extends Pieces{
	public Pawn(boolean isWhite) {
		super("Pawn", isWhite);
	}

	@Override
	public ArrayList<Square> checkMovableSquare(Square currentSquare) {
		Square[][] Grid = Board.getSquareArray();
		ArrayList<Square> Movable_square = new ArrayList<>();
		int row_index = currentSquare.getRow() - 1;
		int col_index = currentSquare.getCol() - 1;

		Movable_square.add(currentSquare);

		// specail case if pawn is at the start position
		if (row_index == 6 || row_index == 1){
			if (isWhite && row_index != 1){
				Movable_square.add(Grid[row_index - 2][col_index]);
			}
			else if (!isWhite && row_index != 6){
				Movable_square.add(Grid[row_index + 2][col_index]);
			}
		}
	
		if (isWhite){
			// sq.getRow give an int from 1-8, same as getCol()
			// row_index and col_index here is from 0-7
			for (Square[] sq_row: Grid){
				for (Square sq: sq_row){
					if (sq.getRow() == row_index){
						// check if pawn can move up
						if ((sq.getCol() - 1) == col_index && sq.getInnerPiece() == null)
							Movable_square.add(sq);
						// check for possible take on diagonal square
						if (((sq.getCol() - 1) == col_index + 1 || (sq.getCol() - 1) == col_index - 1) && sq.getInnerPiece() != null)
							Movable_square.add(sq);
					}
				}
			}
		}
		else{ // black pieces
			// sq.getRow give an int from 1-8, same as getCol()
			// row_index and col_index here is from 0-7
			for (Square[] sq_row: Grid){
				for (Square sq: sq_row){	
					if (sq.getRow() - 2 == row_index){
						// System.out.println("Sq: (" + sq.getRow() + "," + sq.getCol() + ") -- " + "(" + row_index + "," + col_index + ")");
						// check if pawn can move down
						if ((sq.getCol() - 1) == col_index && sq.getInnerPiece() == null)
							Movable_square.add(sq);
						// check for possible take on diagonal square
						if (((sq.getCol() - 1) == col_index + 1 || (sq.getCol() - 1) == col_index - 1) && sq.getInnerPiece() != null)
							Movable_square.add(sq);
					}
					
				}
			}
		}
		
		return Movable_square;
	}
}