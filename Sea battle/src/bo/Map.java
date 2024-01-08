package bo;

import go.Main;
import bo.Game;
import java.util.Arrays;

public class Map {

    private int size_x_max;

    private int size_y_max;


    public Map(int size_x_max, int size_y_max) {
        this.size_x_max = size_x_max;
        this.size_y_max = size_y_max;
    }

    public int getSize_x_max() {
        return size_x_max;
    }

    public int getSize_y_max() {
        return size_y_max;
    }

    public String[][] create_map() {

        String[][] map = new String[size_y_max][size_x_max];

        for (int i = 0; i < size_y_max; i++) {
            for (int j = 0; j < size_x_max; j++) {
                map[i][j] = ".";
            }
        }
        return map;
    }

    public void printmap_player1(String[][] map_def, String[][] map_atk) {
        System.out.println("Player 1");
        System.out.println();
        for (int i = 0; i < size_y_max; i++) {
            for (int j = 0; j < size_x_max; j++) {
                System.out.print(map_def[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        for (int i = 0; i < size_y_max; i++) {
            for (int j = 0; j < size_x_max; j++) {
                System.out.print(map_atk[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printmap_player2(String[][] map_def, String[][] map_atk) {
        System.out.println("Player 2");
        System.out.println();
        for (int i = 0; i < size_y_max; i++) {
            for (int j = 0; j < size_x_max; j++) {
                System.out.print(map_def[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        for (int i = 0; i < size_y_max; i++) {
            for (int j = 0; j < size_x_max; j++) {
                System.out.print(map_atk[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
