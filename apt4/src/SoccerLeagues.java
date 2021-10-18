public class SoccerLeagues {
    public int[] points(String[] matches) {
        int[] arr = new int[matches.length];
        int tr = -1;
        for (String s:matches){
            tr += 1;
            char[] stor = s.toLowerCase().toCharArray();
            for (int k=0;k<s.length();k++){
                if (stor[k]=='l'){
                    arr[k] += 3;
                }
                if (stor[k]=='d'){
                    arr[k] += 1;
                    arr[tr] += 1;
                }
                if (stor[k]=='w'){
                    arr[tr] += 3;
                }
            }
        }
        return arr;
    }
}