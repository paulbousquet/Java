import java.util.*;
public class PercolationBFS extends PercolationDFSFast {
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }
    @Override
    protected void dfs(int row, int col){
        Queue<int[]> plank = new LinkedList<>();
        myGrid[row][col] = FULL;
        plank.add(new int[]{row,col});
        while(plank.size()!=0){
            int[] i = plank.remove();
            if (inBounds(i[0]+1,i[1])){
                if(isOpen(i[0]+1,i[1])&&(myGrid[i[0]+1][i[1]])!=FULL){
                    myGrid[i[0]+1][i[1]]=FULL;
                    plank.add(new int[]{i[0]+1,i[1]});
                }
            }
            if (inBounds(i[0]-1,i[1])){
                if(isOpen(i[0]-1,i[1])&&(myGrid[i[0]-1][i[1]])!=FULL){
                    myGrid[i[0]-1][i[1]]=FULL;
                    plank.add(new int[]{i[0]-1,i[1]});
                }
            }
            if (inBounds(i[0],i[1]+1)){
                if(isOpen(i[0],i[1]+1)&&(myGrid[i[0]][i[1]+1])!=FULL){
                    myGrid[i[0]][i[1]+1]=FULL;
                    plank.add(new int[]{i[0],i[1]+1});
                }
            }
            if (inBounds(i[0],i[1]-1)) {
                if(isOpen(i[0],i[1]-1)&&(myGrid[i[0]][i[1]-1])!=FULL){
                    myGrid[i[0]][i[1]-1]=FULL;
                    plank.add(new int[]{i[0],i[1]-1});
                }
            }
        }
    }
}
