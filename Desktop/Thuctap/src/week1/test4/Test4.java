package week1.test4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.*;


public class Test4 {
    public static int temp;
    public static Point checker = new Point(0, 0);
    public static Random rd = new Random();
    public static Set<Point> tapHop = new HashSet<>();

    public static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + ((a.y - b.y) * (a.y - b.y)));
    }

    public static void genPoint(Point check, int condition) {
        Point point = new Point(0, 0);
        point.x = rd.nextInt(check.x) + condition;
        point.y = rd.nextInt(check.y) + condition;
        if (distance(point, check) <= condition) {
            tapHop.add(point);
        }
    }

    public static void main(String args[]) {
        List<Point> result = new ArrayList<>();
        Point pointA = new Point(800, 800);
        Point pointB = new Point(4000, 800);
        Point pointC = new Point(2400, 2400);
        while (tapHop.size() < 8000) {
            genPoint(pointA, 400);
        }
        while (tapHop.size() < 18000) {
            genPoint(pointB, 500);
        }
        while (tapHop.size() < 30000) {
            genPoint(pointC, 600);
        }
        try {
            File file = new File("/home/dangtoan/Desktop/Thuctap/src/week1/test4/output4.txt");
            FileWriter writer = new FileWriter(file);
            StringBuilder str = new StringBuilder();

            for (Point i : tapHop) {
                result.add(i);
            }

            Comparator<Point> sortByX = new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    if (p1.x == p2.x) return p1.y - p2.y;
                    return p1.x - p2.x;
                }
            };

            Collections.sort(result, sortByX);

            for (Point i : result) {
                str.append(i.x).append(" - ").append(i.y).append("\n");
            }
            writer.write(str.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
