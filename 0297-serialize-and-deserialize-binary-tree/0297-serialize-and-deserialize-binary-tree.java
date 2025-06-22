public class Codec {
    public static String code(int n){
        String sign="+";
        if(n<0)sign="-";
        n=Math.abs(n);
        if(n/10==0)return sign+"000"+n;
        else if(n/100==0)return sign+"00"+n;
        else if(n/1000==0)return sign+"0"+n;
        else return sign+n;
    }

    public String serialize(TreeNode root){
        if(root==null)return "";
        Queue<TreeNode> q=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        q.add(root);
        sb.append(code(root.val));
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                q.add(node.left);
                sb.append(code(node.left.val));
            }else sb.append("null0");
            if(node.right!=null){
                q.add(node.right);
                sb.append(code(node.right.val));
            }else sb.append("null0");
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data){
        if(data.equals(""))return null;
        Queue<TreeNode> q=new ArrayDeque<>();
        int i=0;
        String rootCode=data.substring(i,i+5);
        int rootVal=Integer.parseInt(rootCode);
        TreeNode root=new TreeNode(rootVal);
        q.add(root);
        i+=5;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(i+5<=data.length()){
                String leftCode=data.substring(i,i+5);
                i+=5;
                if(!leftCode.equals("null0")){
                    TreeNode left=new TreeNode(Integer.parseInt(leftCode));
                    curr.left=left;
                    q.add(left);
                }
            }
            if(i+5<=data.length()){
                String rightCode=data.substring(i,i+5);
                i+=5;
                if(!rightCode.equals("null0")){
                    TreeNode right=new TreeNode(Integer.parseInt(rightCode));
                    curr.right=right;
                    q.add(right);
                }
            }
        }
        return root;
    }
}
