package ChessSpring.pieces;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPositionInt(){
        return 8*y + x;
    }
    public Integer[] getPositionArray(){
        return new Integer[]{x, y};
    }

    public void changePosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void changePosition(Integer[] position){
        this.x = position[0];
        this.y = position[1];
    }
    public void changePosition(int position){
        this.x = position % 8;
        this.y = position / 8;
    }

    @Override
    public String toString() {
        return "{" + x + " , " + y + "}";
    }
}
