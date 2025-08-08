class Solution {
    public void countSort(List<Integer> list){
        int l=0;
        int n=list.size();
        int s=Integer.MAX_VALUE;
        for(int i:list){
        l=Math.max(l,i);
        s=Math.min(s,i);
        }
        int k=l-s;
        double log2 = Math.log(n) / Math.log(2);
        int temp=(int)log2;
        if(k>n*temp){
            Collections.sort(list);
            return;
        }
        boolean[] a = new boolean[l - s + 1];
            for(int i : list)
                a[i - s] = true;

            int x = 0;
            for(int i = 0; i <= l - s; i++){
                if(a[i]){
                    list.set(x, i + s);
                    x++;
                }
            }

    }
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
            countSort(sorted);
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
