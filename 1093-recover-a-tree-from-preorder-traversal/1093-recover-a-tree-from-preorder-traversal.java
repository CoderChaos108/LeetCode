class Solution {
    public TreeNode recoverFromPreorder(String s) {
        List<TreeNode> list=new ArrayList<>();
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
                    if(list.size()<=level)
                    list.add(new TreeNode(n));
                    else
                    list.set(level,new TreeNode(n));
                    TreeNode node=list.get(level);
                    if(level!=0){
                        TreeNode parent=list.get(level-1);
                        if(parent.left==null)
                        parent.left=node;
                        else
                        parent.right=node;
                    }
                    n=0;
                    i--;
                    level=0;
                    continue;
                }
            }
        }
        return list.get(0);
    }
}
