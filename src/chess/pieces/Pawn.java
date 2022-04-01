package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatach;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatach = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {

		boolean mat[][] = new boolean[getBoard().getRow()][getBoard().getColumn()];
		Position p = new Position(0, 0);

		if (this.getColor() == Color.WHITE) {

			p.setValues(position.getRow() - 1, position.getColumn());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {

				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {

				mat[p.getRow()][p.getColumn()] = true;

			}

			p.setValues(position.getRow() - 1, position.getColumn() - 1);

			if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {

				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() + 1);

			if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {

				mat[p.getRow()][p.getColumn()] = true;
			}

			// #special en passant white

			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);

				if (getBoard().positionExists(left) && isThereOpponetPiece(left)
						&& getBoard().piece(left) == chessMatach.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}

				Position right = new Position(position.getRow(), position.getColumn() + 1);

				if (getBoard().positionExists(right) && isThereOpponetPiece(right)
						&& getBoard().piece(right) == chessMatach.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}

			}

		} else {

			p.setValues(position.getRow() + 1, position.getColumn());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {

				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {

				mat[p.getRow()][p.getColumn()] = true;

			}

			p.setValues(position.getRow() + 1, position.getColumn() - 1);

			if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {

				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColumn() + 1);

			if (getBoard().positionExists(p) && isThereOpponetPiece(p)) {

				mat[p.getRow()][p.getColumn()] = true;
			}

			// #special en passant white

			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);

				if (getBoard().positionExists(left) && isThereOpponetPiece(left)
						&& getBoard().piece(left) == chessMatach.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}

				Position right = new Position(position.getRow(), position.getColumn() + 1);

				if (getBoard().positionExists(right) && isThereOpponetPiece(right)
						&& getBoard().piece(right) == chessMatach.getEnPassantVulnerable()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
				}

			}

		}

		return mat;
	}

	@Override
	public String toString() {

		return "P";
	}

}
