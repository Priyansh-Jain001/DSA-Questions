class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0 ) return true;

        int [] in_deg = new int[numCourses];
        Arrays.fill(in_deg, 0); 

        for(int i=0; i<prerequisites.length; i++){
            in_deg[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<in_deg.length; i++){
            if(in_deg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();

            for(int i=0; i<prerequisites.length; i++){
                if(prerequisites[i][1] == curr){

                    in_deg[prerequisites[i][0]]--;

                    if(in_deg[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }

        for(int i: in_deg){
            if(i != 0)
            return false;
        }

        return true;
    }
}