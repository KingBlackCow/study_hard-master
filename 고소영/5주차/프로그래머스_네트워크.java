class 프로그래머스_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(computers[i][j] == 1){
                    answer++;
                    dfs(computers,i, j, n);
                }
            }
        }
        
        return answer;
    }
    
    public static void dfs(int arr[][],int r, int c , int n){
        arr[r][c] = 0;
        
            for (int j = 0; j < n; j++){
                if(arr[c][j] == 1)
                dfs(arr, c, j, n);
            }
        }
    }