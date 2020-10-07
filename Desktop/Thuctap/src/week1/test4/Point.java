package week1.test4;


public class Point {
    public int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point){
            Point A = (Point) obj;
            if(this.x == A.x && this.y ==A.y){
                return true;
            }
            else return false;
        }
        return false;
    }
}
