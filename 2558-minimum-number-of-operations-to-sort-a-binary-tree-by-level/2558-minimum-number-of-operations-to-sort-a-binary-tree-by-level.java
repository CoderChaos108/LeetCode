class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int c=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                list.add(node.val);
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
            }
            List<Integer> sorted=new ArrayList<>(list);
            Collections.sort(sorted);
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<sorted.size();i++)
            hm.put(sorted.get(i),i);
            int i=0;
            while(i<list.size()){
                int j=hm.get(list.get(i));
                if(i==j){
                    i++;
                    continue;
                }
                c++;
                int k=list.get(i);
                list.set(i,list.get(j));
                list.set(j,k);
            }
        }
        return c; 
    }
}
