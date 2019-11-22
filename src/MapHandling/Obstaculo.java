package MapHandling;

public class Obstaculo {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int width;
    private int height;


    public Obstaculo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        height = y2 - y1;
        width = x2 - x1;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

}
