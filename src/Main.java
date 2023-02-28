import java.util.ArrayList;

public class Main {
    public static Tile[] all = new Tile[0];
    public static Tile[][] columns = new Tile[4][0];
    public static Tile[][] rows = new Tile[4][0];
    public static boolean gameEnd = false;
    public static boolean mousePressed = false;
    public static long score = 0;
    public static boolean memeMode = false;
    public static void main(String[] args) {
        //building arrays
        for (int i = 0; i < 16; i++) {
            Tile tile = new Tile( new int[]{i % 4, i / 4});
            all = tile.addTo(all);
            columns[i % 4] = tile.addTo(columns[i % 4]);
            rows[i / 4] = tile.addTo(rows[i / 4]);
        }
        //draw
        genNum();
        Board.init();
        //run
        while (!gameEnd) {
            if (StdDraw.isMousePressed() && !mousePressed) {
                mousePressed = true;
                click(StdDraw.mouseX, StdDraw.mouseY);
                Board.init();
                System.out.println(score);
            } else if (!StdDraw.isMousePressed() && mousePressed) {
                mousePressed = false;
            }
        }
    }
    public static void click(double x, double y){
        if (x >= 5 / 12.0 && x <= 7 / 12.0 && y >= 0 && y <= 1 / 6.0) {
            if (down()){
                genNum();
            }
        } else if (y >= 5 / 12.0 && y <= 7 / 12.0 && x >= 0 && x <= 1 / 6.0) {
            if (left()){
                genNum();
            }
        } else if (x >= 5 / 6.0 && x <= 1 && y >= 5 / 12.0 && y <= 7 / 12.0){
            if (right()){
                genNum();
            }
        } else if (y >= 5 / 6.0 && y <= 1 && x >= 5 / 12.0 && x <= 7 / 12.0){
            if (up()){
                genNum();
            }
        }
    }
    public static boolean down(){
        boolean success = false;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 3; j > 0; j--) {
                    if (columns[i][j].content != 0 && columns[i][j - 1].content == 0) {
                        success = true;
                        columns[i][j - 1].content = columns[i][j].content;
                        columns[i][j].content = 0;
                    }
                }
            }
            for (int j = 1; j < 4; j++) {
                if (columns[i][j].content != 0 && columns[i][j - 1].content == columns[i][j].content){
                    success = true;
                    score += columns[i][j - 1].content;
                    columns[i][j - 1].content *= 2;
                    columns[i][j].content = 0;
                    j++;
                }
            }
            for (int k = 0; k < 3; k++) {
                for (int j = 3; j > 0; j--) {
                    if (columns[i][j].content != 0 && columns[i][j - 1].content == 0) {
                        success = true;
                        columns[i][j - 1].content = columns[i][j].content;
                        columns[i][j].content = 0;
                    }
                }
            }
        }
        return success;
    }
    public static boolean left(){
        boolean success = false;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 3; j > 0; j--) {
                    if (rows[i][j].content != 0 && rows[i][j - 1].content == 0) {
                        success = true;
                        rows[i][j - 1].content = rows[i][j].content;
                        rows[i][j].content = 0;
                    }
                }
            }
            for (int j = 1; j < 4; j++) {
                if (rows[i][j].content != 0 && rows[i][j - 1].content == rows[i][j].content){
                    success = true;
                    score += rows[i][j - 1].content;
                    rows[i][j - 1].content *= 2;
                    rows[i][j].content = 0;
                    j++;
                }
            }
            for (int k = 0; k < 3; k++) {
                for (int j = 3; j > 0; j--) {
                    if (rows[i][j].content != 0 && rows[i][j - 1].content == 0) {
                        success = true;
                        rows[i][j - 1].content = rows[i][j].content;
                        rows[i][j].content = 0;
                    }
                }
            }
        }
        return success;
    }
    public static boolean right(){
        boolean success = false;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    if (rows[i][j].content != 0 && rows[i][j + 1].content == 0) {
                        success = true;
                        rows[i][j + 1].content = rows[i][j].content;
                        rows[i][j].content = 0;
                    }
                }
            }
            for (int j = 2; j > -1; j--) {
                if (rows[i][j].content != 0 && rows[i][j + 1].content == rows[i][j].content){
                    success = true;
                    score += rows[i][j + 1].content;
                    rows[i][j + 1].content *= 2;
                    rows[i][j].content = 0;
                    j++;
                }
            }
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    if (rows[i][j].content != 0 && rows[i][j + 1].content == 0) {
                        success = true;
                        rows[i][j + 1].content = rows[i][j].content;
                        rows[i][j].content = 0;
                    }
                }
            }
        }
        return success;
    }
    public static boolean up(){
        boolean success = false;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    if (columns[i][j].content != 0 && columns[i][j + 1].content == 0) {
                        success = true;
                        columns[i][j + 1].content = columns[i][j].content;
                        columns[i][j].content = 0;
                    }
                }
            }
            for (int j = 2; j > -1; j--) {
                if (columns[i][j].content != 0 && columns[i][j + 1].content == columns[i][j].content){
                    success = true;
                    score += columns[i][j + 1].content;
                    columns[i][j + 1].content *= 2;
                    columns[i][j].content = 0;
                    j++;
                }
            }
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    if (columns[i][j].content != 0 && columns[i][j + 1].content == 0) {
                        success = true;
                        columns[i][j + 1].content = columns[i][j].content;
                        columns[i][j].content = 0;
                    }
                }
            }
        }
        return success;
    }
    public static void genNum(){
        ArrayList<Tile> empty = new ArrayList<>();
        for (Tile t: all) {
            if (t.content == 0){
                empty.add(t);
            }
        }
        empty.get((int) (Math.random() * empty.size())).content = (int) Math.pow(2, 1 + (int) (Math.random() * 2));
    }
}