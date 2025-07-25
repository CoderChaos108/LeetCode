class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        Queue<Integer>xq=new LinkedList<>();
        q.add(root);
        xq.add(0);
        List<List<Integer>>n=new ArrayList<>();
        List<List<Integer>>p=new ArrayList<>();

        while(!q.isEmpty()) {
            int size=q.size();
            Map<Integer,List<Integer>>hm=new HashMap<>();

            for(int i=0;i<size;i++) {
                TreeNode node=q.poll();
                int t=xq.poll();
                hm.computeIfAbsent(t,k->new ArrayList<>()).add(node.val);

                if(node.left!=null) {
                    q.add(node.left);
                    xq.add(t-1);
                }

                if(node.right!=null) {
                    q.add(node.right);
                    xq.add(t+1);
                }
            }

            for(Map.Entry<Integer,List<Integer>>e:hm.entrySet()) {
                List<Integer>list=e.getValue();
                Collections.sort(list);
                int t=e.getKey();
                if(t>=0) {
                    while(p.size()<=t) 
                        p.add(new ArrayList<>());
                    p.get(t).addAll(list);
                } else {
                    t=-t-1;
                    while(n.size()<=t) 
                        n.add(new ArrayList<>());
                    n.get(t).addAll(list);
                }
            }
        }

        List<List<Integer>>ans=new ArrayList<>();
        for(int i=n.size()-1;i>=0;i--) 
            ans.add(n.get(i));
        for(int i=0;i<p.size();i++) 
            ans.add(p.get(i));
        return ans;
    }
}
