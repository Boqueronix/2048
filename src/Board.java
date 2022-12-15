import java.awt.*;

public class Board {
    public static void init(){
        StdDraw.clear();
        //base
        StdDraw.setPenColor(Color.BLACK);
        for (int i = 1; i < 6; i++) {
            StdDraw.line(i / 6.0, 1 / 6.0, i / 6.0, 5 / 6.0 );
            StdDraw.line(1 / 6.0, i / 6.0, 5 / 6.0, i / 6.0 );
        }
        //buttons
        StdDraw.square(11 / 12.0, 0.5, 1 / 12.0);
        StdDraw.square(0.5, 11 / 12.0, 1 / 12.0);
        StdDraw.square(1 / 12.0, 0.5, 1 / 12.0);
        StdDraw.square(0.5, 1 / 12.0, 1 / 12.0);
        //tiles
        for (Tile t: Main.all) {
            t.draw();
        }
    }
}
