package model;

public final class Intersection {
	
	private static Intersection theInstance;
	private Cell[][] cells;
	private int rows, cols;
	
	private Intersection(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		cells = new Cell[this.rows][this.cols];
		for(int r = 0; r < rows; r++)
		{
			for(int c = 0; c < cols; c++)
			{
				cells[r][c] = new Cell();
			}
		}
	}
	
	public static Intersection getInstance(int rows, int cols)
	{
		if(theInstance == null)
		{
			theInstance = new Intersection(rows, cols);
		}
		return theInstance;
	}
	public static Intersection getInstance()
	{
		if(theInstance == null)
		{
			theInstance = new Intersection(1, 1);
		}
		return theInstance;
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public String getPrintOut()
	{
		String printOut = "";
		for(int r = 0; r < this.rows; r++)
		{
			for(int c = 0; c < this.cols; c++)
			{
				printOut += this.cells[r][c].getPrintOut();
			}
			printOut += "\n";
		}
		
		return printOut;
	}
	
	public Cell getSpecificCell(int row, int col)
	{
		return cells[row][col];
	}

}
