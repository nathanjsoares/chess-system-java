package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int row, int column) {
		if(row < 1 || column <1) {
			throw new BoardException("Error creating board: there must be 1 row 1 colunm");
		}
		this.rows = row;
		this.columns = column;
		pieces = new Piece[row][column];
	}

	public int getRow() {
		return rows;
	}

	public int getColumn() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if(!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position "+position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public boolean positionExists(int row,int column) {
		return row >=0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position positio) {
		return positionExists(positio.getRow(), positio.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
