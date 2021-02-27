class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i,n,computers);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int x, int n,int[][] computers){
        visit[x]=true;
        for(int i=0;i<n; i++){
            if(x==i)continue;
            if(!visit[i] && computers[x][i]==1){
                dfs(i,n,computers);
            }
        }
    }
}