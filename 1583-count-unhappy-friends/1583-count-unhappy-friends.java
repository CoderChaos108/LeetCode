class Solution {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        HashSet<Integer> set=new HashSet<>();

        for(int[] a:pairs){

            int x=a[0];
            int y=a[1];

            for(int[] b:pairs){

                int u=b[0];
                int v=b[1];

                if(x==u && y==v) continue;

                if(func(preferences,x,y,u,v))
                    set.add(x);

                if(func(preferences,x,y,v,u))
                    set.add(x);

                if(func(preferences,y,x,u,v))
                    set.add(y);

                if(func(preferences,y,x,v,u))
                    set.add(y);
            }
        }

        return set.size();
    }

    boolean func(int[][] preferences,int x,int y,int u,int v){

        boolean xUnhappy=false;
        boolean uUnhappy=false;

        for(int i:preferences[x]){
            if(i==y) break;
            if(i==u){
                xUnhappy=true;
                break;
            }
        }

        for(int i:preferences[u]){
            if(i==v) break;
            if(i==x){
                uUnhappy=true;
                break;
            }
        }

        return xUnhappy && uUnhappy;
    }
}