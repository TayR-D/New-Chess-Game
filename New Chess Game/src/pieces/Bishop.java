package pieces;

import java.util.ArrayList;

import main.Pieces;
import main.Square;

public class Bishop extends Pieces{
	public Bishop(boolean isWhite) {
		super("Bishop", isWhite);
	}

	@Override
	public ArrayList<Square> checkMovableSquare(Square currentSquare) {
		int current_row = currentSquare.getRow() - 1;
		int current_col = currentSquare.getCol() - 1;
        int n = Grid.length;
        ArrayList<Square> Movable_square = new ArrayList<>();
        
        // Check if given row and column are within bounds
        if (current_row < 0 || current_row >= n || current_col < 0 || current_col >= n) {
            return Movable_square;
        }
        
        // Check Movable_square from top-left to bottom-right
        int i = current_row, j = current_col;
        while (i >= 0 && j >= 0) {
            Movable_square.add(Grid[i][j]);
			if(Grid[i][j].getInnerPiece() != null) break;
            i--;
            j--;
        }
        i = current_row + 1;
        j = current_col + 1;
        while (i < n && j < n) {
            Movable_square.add(Grid[i][j]);
			if(Grid[i][j].getInnerPiece() != null) break;
            i++;
            j++;
        }
        
        // Check Movable_square from bottom-left to top-right
        i = current_row;
        j = current_col;
        while (i < n && j >= 0) {
            Movable_square.add(Grid[i][j]);
			if(Grid[i][j].getInnerPiece() != null) break;
            i++;
            j--;
        }
        i = current_row - 1;
        j = current_col + 1;
        while (i >= 0 && j < n) {
            Movable_square.add(Grid[i][j]);
			if(Grid[i][j].getInnerPiece() != null) break;
            i--;
            j++;
        }
        
        // Return ArrayList containing all movableSquaresly adjacent items
        return Movable_square;
    }
}