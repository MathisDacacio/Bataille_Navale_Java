package go;

import bo.Game;
import bo.Map;
import bo.Ship;

public class Main {
    public static void main(String[] args) {
        int size_x_max = 10;
        int size_y_max = 10;

        Map map = new Map(size_x_max, size_y_max);

        String[][] map_def_j1 = map.create_map();
        String[][] map_atk_j1 = map.create_map();
        String[][] map_def_j2 = map.create_map();
        String[][] map_atk_j2 = map.create_map();

        Ship torpilleur = new Ship(2);
        Ship sous_marin = new Ship(3);
        Ship contre_torpilleur = new Ship(3);
        Ship croiseur = new Ship(4);
        Ship porte_avion = new Ship(5);

        map_def_j1 = torpilleur.random_place(map_def_j1, size_x_max, size_y_max);
        map_def_j1 = sous_marin.random_place(map_def_j1, size_x_max, size_y_max);
        map_def_j1 = contre_torpilleur.random_place(map_def_j1, size_x_max, size_y_max);
        map_def_j1 = croiseur.random_place(map_def_j1, size_x_max, size_y_max);
        map_def_j1 = porte_avion.random_place(map_def_j1, size_x_max, size_y_max);

        map_def_j2 = torpilleur.random_place(map_def_j2, size_x_max, size_y_max);
        map_def_j2 = sous_marin.random_place(map_def_j2, size_x_max, size_y_max);
        map_def_j2 = contre_torpilleur.random_place(map_def_j2, size_x_max, size_y_max);
        map_def_j2 = croiseur.random_place(map_def_j2, size_x_max, size_y_max);
        map_def_j2 = porte_avion.random_place(map_def_j2, size_x_max, size_y_max);

        Game play = new Game();

        play.Game_P1(map, map_def_j1, map_atk_j1, map_def_j2, map_atk_j2);

    }
}
