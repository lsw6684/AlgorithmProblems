/*
Description

n���� ���� ����ġ(�Ÿ�) w�� ���� ������� ������ ����׷�������, �� ����κ��� �ٸ� ��� ��������� �ִܰŸ��� ã�� ���α׷��� �ۼ��Ͻÿ�.

(n�� 100)

(-10�� w�� 100)

(��, ����Ǿ����� ���� ������ w = 99999�� ����ϸ�, ���� ����Ŭ�� �������� �ʴ´�.)


Input
ù ��° �ٿ��� ����� ���� n�� �־�����.

�� ��° �ٺ��� ��� i���� ��� j�� ���ϴ� ������ ����ġ(�Ÿ�) w�� n X n�� 2���� ��� ���·� �־�����.


Output
�� ��� i���� j���� ���� ���� �ִܰŸ��� n X n�� 2���� ��� ���·� ����Ѵ�.

(��, �� ���� ���̴� ����� �����Ѵ�.)


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