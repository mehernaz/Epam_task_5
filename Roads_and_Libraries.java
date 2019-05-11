import java.util.*;
public class Roads_and_Libraries 
{
    static boolean visited[];
    static LinkedList<Integer>adj[];
    public static ArrayList<Integer> bfs(int s)
    {
        LinkedList<Integer>q=new LinkedList<>();
        ArrayList<Integer>connect=new ArrayList<Integer>();
        visited[s]=true;
        q.add(s);
        while(q.size()!=0)
        {
            s=q.poll();
            connect.add(s);
              Iterator<Integer> i = adj[s].listIterator(); 
                while (i.hasNext()) 
                { 
                    int n = i.next(); 
                    if (!vis[n]) 
                    { 
                        visited[n] = true; 
                        q.add(n); 
                    } 
                }
            
        }
        return connect;
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
         int q=sc.nextInt();
         while(q>0)
         {
            
         int n=sc.nextInt(),m=sc.nextInt();
         long cl=sc.nextLong(),cr=sc.nextLong();
         adj=new LinkedList[n+1];
         Arrays.fill(adj,null);
         visited=new boolean[n+1];
         List<ArrayList<Integer>>comp=new ArrayList<>();
         Arrays.fill(vis,false);
         for(int i=1;i<=n;i++)
         {
             adj[i]=new LinkedList<Integer>();
         }
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        
        for(int i=1;i<=n;i++)
        {
            if(visited[i]==false)
            {
                comp.add(bfs(i));
            }
        }
        //System.out.println(comp);
        long libcost=n*cl;
        //System.out.println("Lib="+libcost);
        long ccost=0;
        for(int i=0;i<comp.size();i++)
        {
            long l=comp.get(i).size()-1;
            long a=l*cr;
        
            if(l>0)
            ccost+=a+cl;
            else ccost+=cl;
        }
        System.out.println((long)Math.min(ccost,libcost));
        q--;
         }

    }

}
