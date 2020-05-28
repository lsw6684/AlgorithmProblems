/*
Description

n개의 노드와 가중치(거리) w를 가진 간선들로 구성된 방향그래프에서, 각 점들로부터 다른 모든 점들까지의 최단거리를 찾는 프로그램을 작성하시오.

(n≤ 100)

(-10≤ w≤ 100)

(단, 연결되어있지 않은 간선은 w = 99999로 고려하며, 음수 사이클은 존재하지 않는다.)


Input
첫 번째 줄에는 노드의 개수 n이 주어진다.

두 번째 줄부터 노드 i에서 노드 j로 향하는 간선의 가중치(거리) w가 n X n의 2차원 행렬 형태로 주어진다.


Output
각 노드 i에서 j까지 가기 위한 최단거리를 n X n의 2차원 행렬 형태로 출력한다.

(단, 각 원소 사이는 띄어쓰기로 구분한다.)


Sample Input 1 

5
0 4 2 5 99999
99999 0 1 99999 4
1 3 0 1 2
-2 99999 99999 0 2
99999 -3 3 1 0
Sample Output 1

0 1 2 3 4 
0 0 1 2 3 
-1 -1 0 1 2 
-2 -1 0 0 2 
-3 -3 -2 -1 0 
*/
import java.util.Scanner;
 
public class Main
{
    private int distancematrix[][];
    private int numberofvertices;
    public static final int w = 99999;
 
    public Main(int numberofvertices)
    {
        distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
        this.numberofvertices = numberofvertices;
    }
 
    public void allPairShortestPath(int adjacencymatrix[][])
    {
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                distancematrix[source][destination] = adjacencymatrix[source][destination];
            }
        }
 
        for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
        {
            for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                    if (distancematrix[source][intermediate] + distancematrix[intermediate][destination]
                                         < distancematrix[source][destination])
                        distancematrix[source][destination] = distancematrix[source][intermediate] 
                                         + distancematrix[intermediate][destination];
                }
            }
        }
 
   
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                System.out.print(distancematrix[source][destination] + " ");
            }
            System.out.println();
        }
    }
 
    public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int numberofvertices;

        Scanner scan = new Scanner(System.in);
        numberofvertices = scan.nextInt();
 
        adjacency_matrix = new int[numberofvertices + 1][numberofvertices + 1];
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                adjacency_matrix[source][destination] = scan.nextInt();
                if (source == destination)
                {
                    adjacency_matrix[source][destination] = 0;
                    continue;
                }
                if (adjacency_matrix[source][destination] == 0)
                {
                    adjacency_matrix[source][destination] = w;
                }
            }
        }
 
        Main allPairShortestPath= new Main(numberofvertices);
        allPairShortestPath.allPairShortestPath(adjacency_matrix);
 
        scan.close();
    }
}