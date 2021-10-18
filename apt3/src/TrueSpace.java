public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        long sum = 0;
        for (int k=0;k<sizes.length;k++){
            long goof = 0;
            if (sizes[k]<0){
                goof = sizes[k]*(-1);
            }
            else{
                goof = sizes[k];
            }
            long kool = goof/clusterSize;
            long news = 0;
            if (sizes[k]%clusterSize!=0){
                news = clusterSize;
            }
            if (news < 0){
                news = news*(-1);
            }
            if (kool < 0){
                kool = kool*(-1);
            }
            if (clusterSize<0){
                clusterSize = clusterSize*(-1);
            }
            sum = sum + kool*clusterSize+news;
        }
        long o = sum;
        return o;
    }
}