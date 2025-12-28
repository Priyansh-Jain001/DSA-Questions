// Topological Sorting
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         // store the sorted order in ans array
        int [] ans = new int[numCourses]; int k =0;  // help iterate over the answer array

        // if no prerequitis the print 0 to numCourses-1 (i.e any course can be done any time)
        if(prerequisites.length == 0){
            for(int i=0; i<numCourses; i++){
                ans[i] = i;
            }
        }

       
        int [] in_deg = new int[numCourses];
        
        // fills the in_def with 0 initially
        Arrays.fill(in_deg, 0);

        // Finding the indegree of every couse
        for(int i=0; i<prerequisites.length; i++){
            in_deg[prerequisites[i][0]]++;
        }

        for(int i: in_deg){
            System.out.print(i+" ");
        }

        // adding the 0 indegree(non-dependent node) in the queue 
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<in_deg.length; i++){
            if(in_deg[i] == 0){
                q.add(i);
            }
        }

        
        while(!q.isEmpty()){
            int curr = q.remove();
            ans[k] = curr;
            k++;

            for(int i=0; i<prerequisites.length; i++){
                if(prerequisites[i][1] == curr){
                    
                    // neighbour in_deg decrement
                    in_deg[prerequisites[i][0]]--;

                    if(in_deg[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }

        for(int i: in_deg){
            if(i != 0){
                return new int[]{};
            }
        }

        return ans;
    }
}