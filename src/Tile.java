import java.awt.*;

public class Tile {
    public long content = 0;
    public int[] coords;
    public Tile(int[] c){
        coords = c;
    }
    public void draw(){
        if (content != 0) {
            StdDraw.setPenColor(new Color(128 + (int) (content % 128), 128 + (int) content % 128, 128 + (int) content % 128, 200));
            StdDraw.filledSquare((1.5 + coords[0]) / 6.0, (1.5 + coords[1]) / 6.0, 1 / 12.0);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.setFont(new Font("SansSerif", Font.PLAIN, (content / 100 == 0)? 30: 20 ));
            StdDraw.text((1.5 + coords[0]) / 6, (1.5 + coords[1]) / 6, "" + content);
        }
    }
    public Tile[] addTo(Tile[] target){
        Tile[] temp = new Tile[target.length + 1];
        for (int i = 0; i < target.length; i++) {
            temp[i] = target[i];
        }
        temp[target.length] = this;
        return temp;
    }
}
