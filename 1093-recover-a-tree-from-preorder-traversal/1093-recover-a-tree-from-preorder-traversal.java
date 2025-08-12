class Solution {
    List<int[]> list=new ArrayList<>();
    HashMap<Integer,List<Integer>> hm=new HashMap<>();
    public TreeNode recoverFromPreorder(String s) {
        int n=0;
        int level=-1;
        s='-'+s;
        int size=1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='-'){
                level++;
                if(i+1<s.length()&&s.charAt(i+1)!='-'){
                    i++;
                    while(i<s.length()&&s.charAt(i)!='-'){
                        n=n*10+(s.charAt(i)-'0');
                        i++;
                    }
                    list.add(new int[]{level,n});
                    n=0;
                    i--;
                    size=Math.max(size,level+1);
                    level=0;
                    continue;
                }
            }
        }
        hm.put(list.get(0)[1],new ArrayList<>());
        TreeNode[] a=new TreeNode[size];
        a[0]=new TreeNode(list.get(0)[1]);
        for(int i=1;i<list.size();i++){
            int l=list.get(i)[0];
            int val=list.get(i)[1];
            a[l]=new TreeNode(val);
            TreeNode parent=a[l-1];
            if(parent.left==null)
            parent.left=a[l];
            else
            parent.right=a[l];
        }

        return a[0];
    }
}
