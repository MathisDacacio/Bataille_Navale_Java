package bo;

import java.util.Scanner;

public class Game {

    public Game() {
    }
    public void Game_P1(Map map, String[][] map_def_J1, String[][] map_atk_J1, String[][] map_def_J2, String[][] map_atk_J2) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Player 1 entrez la ligne de votre tir : ");
            int tir_y = scanner.nextInt() - 1;

            System.out.println("Player 1 entrez la colonne de votre tir : ");
            int tir_x = scanner.nextInt() - 1;

            if (tir_y < 0 || tir_y >= map_atk_J1.length || tir_x < 0 || tir_x >= map_atk_J1[0].length) {
                System.out.println("Invalid input, pls try again.");
                continue;
            }

            if (map_def_J2[tir_y][tir_x] == "B" || map_def_J2[tir_y][tir_x] == "L" || map_def_J2[tir_y][tir_x] == "P" || map_def_J2[tir_y][tir_x] == "C" || map_def_J2[tir_y][tir_x] == "S" || map_def_J2[tir_y][tir_x] == "U" || map_def_J2[tir_y][tir_x] == "T") {
                String my_lettre = ".";
                System.out.println("Nice shot!");
                map_atk_J1[tir_y][tir_x] = "X";
                if (map_def_J2[tir_y][tir_x] == "B") {
                    map_def_J2[tir_y][tir_x] = "b";
                    my_lettre = "B";
                } else if (map_def_J2[tir_y][tir_x] == "L") {
                    map_def_J2[tir_y][tir_x] = "l";
                    my_lettre = "L";
                } else if (map_def_J2[tir_y][tir_x] == "P") {
                    map_def_J2[tir_y][tir_x] = "p";
                    my_lettre = "P";
                } else if (map_def_J2[tir_y][tir_x] == "C") {
                    map_def_J2[tir_y][tir_x] = "c";
                    my_lettre = "C";
                } else if (map_def_J2[tir_y][tir_x] == "S") {
                    map_def_J2[tir_y][tir_x] = "s";
                    my_lettre = "S";
                } else if (map_def_J2[tir_y][tir_x] == "U") {
                    map_def_J2[tir_y][tir_x] = "u";
                    my_lettre = "U";
                } else if (map_def_J2[tir_y][tir_x] == "T") {
                    map_def_J2[tir_y][tir_x] = "t";
                    my_lettre = "T";
                }
                if (Couler(map_def_J2, my_lettre))
                    map_atk_J1[tir_y][tir_x] = "C";
            } else {
                System.out.println("You miss...");
                map_atk_J1[tir_y][tir_x] = "W";
                map_def_J2[tir_y][tir_x] = "o";
            }

            if (!Navire_alive(map_def_J2)) {
                map.printmap_player1(map_def_J1, map_atk_J1);
                System.out.println("Player 1 Win !");
                System.exit(0);
            }

            map.printmap_player1(map_def_J1, map_atk_J1);

            Game_P2(map, map_def_J1, map_atk_J1, map_def_J2, map_atk_J2);
        }
    }

    public void Game_P2(Map map, String[][] map_def_J1, String[][] map_atk_J1, String[][] map_def_J2, String[][] map_atk_J2) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Player 2 entrez la ligne de votre tir : ");
            int tir_y = scanner.nextInt() - 1;
            System.out.println("Player 2 entrez la colonne de votre tir : ");
            int tir_x = scanner.nextInt() - 1;

            if (tir_y < 0 || tir_y >= map_atk_J1.length || tir_x < 0 || tir_x >= map_atk_J1[0].length) {
                System.out.println("Invalid input, pls try again.");
                continue;
            }

            if (map_def_J1[tir_y][tir_x] == "B" || map_def_J1[tir_y][tir_x] == "L" || map_def_J1[tir_y][tir_x] == "P" || map_def_J1[tir_y][tir_x] == "C" || map_def_J2[tir_y][tir_x] == "S" || map_def_J1[tir_y][tir_x] == "U" || map_def_J1[tir_y][tir_x] == "T") {
                String my_lettre = ".";
                System.out.println("Nice shot!");
                map_atk_J2[tir_y][tir_x] = "T";
                if (map_def_J1[tir_y][tir_x] == "B") {
                    map_def_J1[tir_y][tir_x] = "b";
                    my_lettre = "B";
                } else if (map_def_J1[tir_y][tir_x] == "L") {
                    map_def_J1[tir_y][tir_x] = "l";
                    my_lettre = "L";
                } else if (map_def_J1[tir_y][tir_x] == "P") {
                    map_def_J1[tir_y][tir_x] = "p";
                    my_lettre = "P";
                } else if (map_def_J1[tir_y][tir_x] == "C") {
                    map_def_J1[tir_y][tir_x] = "c";
                    my_lettre = "C";
                } else if (map_def_J1[tir_y][tir_x] == "S") {
                    map_def_J1[tir_y][tir_x] = "s";
                    my_lettre = "S";
                } else if (map_def_J1[tir_y][tir_x] == "U") {
                    map_def_J1[tir_y][tir_x] = "u";
                    my_lettre = "U";
                } else if (map_def_J1[tir_y][tir_x] == "T") {
                    map_def_J1[tir_y][tir_x] = "t";
                    my_lettre = "T";
                }
                if (Couler(map_def_J1, my_lettre))
                    map_atk_J2[tir_y][tir_x] = "C";
            } else {
                System.out.println("You miss...");
                map_atk_J2[tir_y][tir_x] = "W";
                map_def_J1[tir_y][tir_x] = "o";
            }

            if (!Navire_alive(map_def_J1)) {
                map.printmap_player2(map_def_J2, map_atk_J2);
                System.out.println("Player 2 Win !");
                System.exit(0);
            }

            map.printmap_player2(map_def_J2, map_atk_J2);

            Game_P1(map, map_def_J1, map_atk_J1, map_def_J2, map_atk_J2);
        }
    }

    public boolean Navire_alive(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case "B", "L", "P", "C", "S", "U", "T" -> {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean Couler(String[][] map, String my_lettre) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == my_lettre)
                    return false;
            }
        }
        return true;
    }
}