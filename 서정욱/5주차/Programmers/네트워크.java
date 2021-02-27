class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for(int i=0;i<n;i++)
            if(!visit[i]) {
                answer++;
                solve(n,i,computers);
            }
        
        return answer;
    }
    
    public void solve(int n,int idx,int[][] computers) {
        visit[idx] = true;
        
        for(int i=0;i<n;i++) {
            if(computers[idx][i]==1 && !visit[i])
                solve(n,i,computers);
        }
    }
}