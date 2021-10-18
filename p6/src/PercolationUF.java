public class PercolationUF implements IPercolate{
    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    public PercolationUF(IUnionFind finder,int size){
        finder.initialize(size*size+2);
        myFinder = finder;
        myGrid = new boolean[size][size];
        VTOP = size*size;
        VBOTTOM = size*size+1;
        myOpenCount=0;
    }

    @Override
    public void open(int row, int col) {
        if(row<0||row>= myGrid.length || col<0 || col >= myGrid[0].length){
            throw new IndexOutOfBoundsException("Index for row and/or col is out of bounds");
        }
        if(!isOpen(row,col)){
            myGrid[row][col]= true;
            myOpenCount += 1;
            int[] rows = new int[]{-1,1,0,0};
            int[] cols = new int[]{0,0,-1,1};
            if (row==0){
                myFinder.union(row*myGrid.length+col,VTOP);
            }
            if (row==myGrid.length-1){
                myFinder.union(row*myGrid.length+col,VBOTTOM);
            }
            for (int i=0;i<rows.length;i++){
                if (inBounds(row+rows[i],col+cols[i])){
                    if (isOpen(row+rows[i],col+cols[i])){
                        myFinder.union(row*myGrid.length+col,(row+rows[i])*myGrid.length+(col+cols[i]));
                    }
                }
            }
        }
    }

    @Override
    public boolean isOpen(int row, int col) {
        if(row<0||row>= myGrid.length || col<0 || col >= myGrid[0].length){
            throw new IndexOutOfBoundsException("Index for row and/or col is out of bounds");
        }
        else{
            return myGrid[row][col];
        }
    }

    @Override
    public boolean isFull(int row, int col) {
        if(row<0||row>= myGrid.length || col<0 || col >= myGrid[0].length){
            throw new IndexOutOfBoundsException("Index for row and/or col is out of bounds");
        }
        return myFinder.connected(VTOP,row*(myGrid.length)+col);
    }

    @Override
    public boolean percolates() {
        return myFinder.connected(VTOP,VBOTTOM);
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }
    public boolean inBounds(int row, int col){
        if(row<0||row>= myGrid.length || col<0 || col >= myGrid[0].length){
            return false;
        }
        else{
            return true;
        }
    }
}
