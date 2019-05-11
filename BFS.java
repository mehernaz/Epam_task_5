import java.util.*;
public class BFS 
{
    static LinkedList<Integer>adj[];
    static int val[];
    static boolean visit[];
    
    static void bfs(int s)
    {
        LinkedList<Integer>qu=new LinkedList<>();
        qu.add(s);
        while(qu.size()!=0)
        {
            s=qu.poll();
            
            Iterator<Integer>it=adj[s].listIterator();
            while(it.hasNext())
            {
                int n=it.next();
                if(visit[n]==false)
                {
                    val[n]=val[s]+6;
                    visit[n]=true;
                    qu.add(n);
                    
                }
            }
        }
        
    }
    public static void main(String[] args) 
    { 
    
        Scanner sc=new Scanner(System.in);
        
        int q=sc.nextInt();
        while(q>0)
        {
            
            int n=sc.nextInt(),m=sc.nextInt();
            adj=new LinkedList[n+1];
            val=new int[n+1];
            visit=new boolean[n+1];
            
            Arrays.fill(visit, false);
            Arrays.fill(val,0);
            for(int i=1;i<=n;i++)
                adj[i]=new LinkedList<Integer>();
            
            for(int i=0;i<m;i++)
            {
                int u=sc.nextInt();
                int v=sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            int s=sc.nextInt();
            val[s]=0;
            bfs(s);
            
            for(int i=1;i<adj.length;i++)
            {
                
                
                //System.out.print(visit[i]+" ");
                if(i!=s&&val[i]==0)
                {
                    System.out.print("-1 " );
                }
                else if(i!=s)
                {
                    System.out.print(val[i]+" ");
                }
            }
            System.out.println();
            q--;
            
        }
    }

}
