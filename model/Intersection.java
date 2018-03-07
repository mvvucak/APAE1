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
	
	public int[] getRowIndices()
	{
		int[] rowIndices = new int[rows]; 
		for(int i = 0; i < rowIndices.length; i++)
		{
			rowIndices[i]=i;
		}
		return rowIndices;
	}
	
	public int[] getColIndices()
	{
		int[] colIndices = new int[cols];
		for(int i = 0; i < colIndices.length; i++)
		{
			colIndices[i]=i;
		}
		return colIndices;
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
	
	public Cell[] getHorizontalLane(int lane)
	{
		Cell[] horizontalLane = new Cell[this.getCols()];
		
		for(int i = 0; i<horizontalLane.length; i++)
		{
			horizontalLane[i] = cells[lane][i];
		}
		return horizontalLane;
	}
	
	public Cell[] getVerticalLane(int lane)
	{
		Cell[] verticalLane = new Cell[this.getRows()];
		
		for(int i = 0; i < verticalLane.length; i++)
		{
			verticalLane[i] = cells[i][lane];
		}
		
		return verticalLane;
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
