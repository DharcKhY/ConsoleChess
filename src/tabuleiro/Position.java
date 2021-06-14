package tabuleiro;

public class Position {
	
	private int row;
	private int column;
	
	
	
	public Position() {
	}
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	
	
	public int getRow() {
		return this.row;
	}
	public int getColumn() {
		return this.column;
	}
	
	
	
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
	
	public void setValues(int row, int column) {
		this.setRow(row);
		this.setColumn(column);
	}
	
	
	
	@Override
	public String toString() {
		return this.row + ", " + this.column;
	}

	
}
