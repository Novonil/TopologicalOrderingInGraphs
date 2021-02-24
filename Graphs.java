public class Graphs
{
    //Flag to denote if the graph contains a cycle
    public static boolean cycle = false;

    // Graph DFS Traversal
    public void DFS(int CountOfNodes, int[][] Graph, int[] Stackarray, int top, int[] Visited, int Source)
    {
        // if there is a cycle stop traversal
        if (cycle)
        {
            return;
        }

        //Print the traversed nodes
        System.out.print(Source + " ");

        // Insert into the stack (top)
        Stackarray[top] = Source;
        top++;

        //Update the Visited flag to 0 signifying that the node is in stack and has been visited
        Visited[Source] = 0;

        for (int i = 0;i< CountOfNodes; i++)
        {
            //Check if there is an edge
            if(Graph[Source][i] == 1)
            {
                //Check if the node has been visited but is there in the stack then it is a cycle
                if (Visited[i] == 0)
                {
                    cycle = true;
                    //Console.Write(Source + " ");
                    return;
                }
                //If the node has not been visited perform DFS
                if (Visited[i] == -1)
                {
                    DFS(CountOfNodes, Graph, Stackarray, top, Visited, i);
                }
            }
        }
        //Remove the node from the stack and set visited flaf to 1 denoting that the node has been visited and removed from stack
        top--;
        Visited[Source] = 1;
    }

    public static void main(String[] args)
    {
        //Graph without Cycle
        int NodeCount = 18;
        int[][] Graph = {
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
                            new int[] { 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                            new int[] { 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                        };

        int[] Stackarray = new int[NodeCount];
        int[] Visited = new int[NodeCount];

        for(int i = 0; i<NodeCount; i++)
        {
            Visited[i] = -1;
        }

        System.out.println("GRAPH WITH NO CYCLES");
        for (int i = 0; i < NodeCount; i++)
        {
            for (int j = 0; j < NodeCount; j++)
            {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }

        Graphs t = new Graphs();
        System.out.println();
        System.out.println("Topological Order");
        // For Traversal from Source Node
        t.DFS(NodeCount, Graph, Stackarray, 0, Visited, 0);
        
        // For disconnected Nodes or nodes with no in-degree (All remaining nodes that has not been traversed)
        if (!cycle)
        {
            for (int i = 0; i < NodeCount; i++)
            {
                if (Visited[i] == -1)
                {
                    t.DFS(NodeCount, Graph, Stackarray, 0, Visited, i);
                }
            }
        }
        if(cycle)
        {
            System.out.println();
            System.out.println("The Graph contains a Cycle - Exiting Traversal.");
        }
        System.out.println();
        System.out.println();


        //Graph with Cycle
        cycle = false;
        int NodeCount1 = 18;

        int[][] Graph1 = {
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
                            new int[] { 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                            new int[] { 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                            new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                        };

        int[] Stackarray1 = new int[NodeCount1];
        int[] Visited1 = new int[NodeCount1];

        for (int i = 0; i < NodeCount1; i++)
        {
            Visited1[i] = -1;
        }
        System.out.println("GRAPH WITH CYCLE");
        
        for(int i = 0; i<NodeCount1; i++)
        {
            for(int j = 0; j<NodeCount1; j++)
            {
                System.out.print(Graph1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Topological Order");
        // For Traversal from Source Node
        t.DFS(NodeCount1, Graph1, Stackarray1, 0, Visited1, 0);

        // For disconnected Nodes or nodes with no in-degree (All remaining nodes that has not been traversed)
        if (!cycle)
        {
            for (int i = 0; i < NodeCount1; i++)
            {
                if (Visited1[i] == -1)
                {
                    t.DFS(NodeCount1, Graph1, Stackarray1, 0, Visited1, i);
                }
            }
        }

        if (cycle)
        {
            System.out.println();
            System.out.println("The Graph contains a Cycle - Exiting Traversal.");
        }
    }
}