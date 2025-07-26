class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<numRows;i++){
            // create sublist for every i
            List<Integer> sublist = new ArrayList<>();
            sublist.add(1);

            for(int j= 1; j<i; j++){
                // Compute the value of the current i,j index
               int value = list.get(i-1).get(j) + list.get(i-1).get(j-1);
               sublist.add(value);
            }

            // Add element at last if and onlt if i>0 i.e. only when the size of the     sublist is greater than one
            if(i>0){
               sublist.add(1); 
            }
            
            // Add the sublist into the main list
            list.add(sublist);
        }

        return list;
    }
}