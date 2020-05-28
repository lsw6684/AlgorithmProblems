/*
Closest Pair (hard)
Description

��� �־��� ���鿡 ���Ͽ�, ���� ������ �Ÿ��� �ּ� ���� ���϶�.


Input
ù ��° �ٿ��� ��ü ���� ������ �־����ϴ�.

�� ��° �ٺ��� �� ������ x��ǥ, y��ǥ�� �־�����, �� �� ���ڴ� ��ǥ�� ���� �� ĭ���� ���е˴ϴ�.


Output
���� ������ �Ÿ��� �� ���� ª�� �Ÿ��� ���� �Ҽ��� ���� 6�ڸ��� ��Ÿ���ÿ�.


Sample Input 1 

1000
971239, 121876
463918, 254404
547547, 744402
859997, 729153
115418, 603248
261717, 147646
408682, 217164
...
Sample Output 1

123.456789
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        List<Point> arr = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine(), ", ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x, y));
        }

        // x ��ǥ ���� ����
        Collections.sort(arr, new xComparator());

        // ���� ���
        System.out.println(String.format("%.6f", closest(arr, 0, N - 1)));
    }

    static double closest(List<Point> arr, int left, int right)
    {
        int sectionSize = right - left + 1;
        // ���ҵ� x��ǥ�� ũ�Ⱑ 3�����̸�
        if (sectionSize <= 3)
        {
            // ���� ����� ���� �Ÿ��� ���մϴ�.
            return bruteForce(arr, left, right);
        }

        int mid = (left + right) / 2;
        double leftSectionDistance = closest(arr, left, mid);
        double rightSectionDistance = closest(arr, mid + 1, right);

        // Left Side�� Right Side���� ���� �ּ� �Ÿ� �� �� ���� ���� ��ü ���� �� �ּ� �Ÿ��� �ӽ� ����
        double answer = Math.min(leftSectionDistance, rightSectionDistance);

        List<Point> middleSection = new ArrayList<>(); // ���ʰ� ������ ������ ������ ������ List

        for (int i = left; i <= right; i++)
        {
            // �߾��� �������� �Ÿ��� �� (�����ϱ� ������ ������ ���ǹ�)
            int xDist = arr.get(i).x - arr.get(mid).x;
            // x ��ǥ�� �Ÿ��� ���� �ּ� �Ÿ� d ���� ���� ��츸 ���
            if (xDist * xDist < answer)
            {
                middleSection.add(arr.get(i));
            }
        }

        // y ��ǥ �������� ���� (���� x��ǥ ������ ���ǹ�)
        Collections.sort(middleSection, new yComparator());
        int candidateSize = middleSection.size();
        for (int i = 0; i < candidateSize - 1; i++)
        {
            for (int j = i + 1; j < candidateSize; j++)
            {
                int yDist = middleSection.get(j).y - middleSection.get(i).y;
                if (yDist * yDist < answer)
                {
                    double dist = findDistance(middleSection.get(i), middleSection.get(j));
                    if (dist < answer)
                    {
                        answer = dist;
                    }
                }
                // y��ǥ ���� �������� �����߱� ������ �������� ���� ����� ��ǥ�� answer���� �ָ�
                // ���� ��ǥ�� �񱳴� ���ǹ� �ϹǷ� break�� ��, �ٸ� ��ǥ�� �������� �ؼ� �ݺ�
                else
                {
                    break;
                }
            }
        }
        return answer;
    }

    // ���� Ž������ ���� ����� �Ÿ� ã��
    static double bruteForce(List<Point> arr, int left, int right)
    {
        double answer = Double.MAX_VALUE;
        for (int i = left; i < right; i++)
        {
            for (int j = i + 1; j <= right; j++)
            {
                double temp = findDistance(arr.get(i), arr.get(j));
                if (answer > temp)
                {
                    answer = temp;
                }
            }
        }
        return answer;
    }

    // Euclidean Distance�� ����
    static double findDistance(Point p1, Point p2)
    {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}

class xComparator implements Comparator<Point>
{
    // x ��ǥ ���� ����
    @Override
    public int compare(Point p1, Point p2)
    {
        return p1.x - p2.x;
    }

}

class yComparator implements Comparator<Point>
{
    // y ��ǥ ���� ����
    @Override
    public int compare(Point p1, Point p2)
    {
        return p1.y - p2.y;
    }

}

class Point
{
    int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}