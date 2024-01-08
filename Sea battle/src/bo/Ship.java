package bo;

import java.util.Objects;
import java.util.Random;
public class Ship {
    private int size;

    public Ship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String[][] random_place(String[][] map, int sizeXMax, int sizeYMax) {
        String triple_size = "U";
        for(int y = 0; y < sizeYMax - 1; y++) {
            for(int x = 0; x < sizeXMax - 1; x++) {
                if (Objects.equals(map[x][y], "U"))
                    triple_size = "S";
            }
        }
        String myChar = myShip(triple_size);
        Random random = new Random();
        int direction = random.nextInt(2);

        int startX, startY;

        // Boucle tant que la place est pas libre
        do {
            if (direction == 0) {
                int maxX = sizeXMax - size;
                startX = random.nextInt(maxX + 1);
                startY = random.nextInt(sizeYMax);
            } else {
                int maxY = sizeYMax - size;
                startX = random.nextInt(sizeXMax);
                startY = random.nextInt(maxY + 1);
            }
        } while (alreadyABoat(map, startY, startX, sizeXMax, sizeYMax, direction));

        // placer le bateau en partant du point de depart
        if (direction == 0) {
            for (int i = 0; i < size; i++) {
                map[startY][startX + i] = myChar;
            }
        } else {
            for (int i = 0; i < size; i++) {
                map[startY + i][startX] = myChar;
            }
        }
        return map;
    }

    public String myShip(String triple_size) {
        if (size == 2)
            return ("T");
        if (size == 3)
            return (triple_size);
        if (size == 4)
            return ("C");
        if (size == 5)
            return ("P");
        if (size > 5)
            return ("B");
        return ("L");
    }

    public boolean alreadyABoat(String[][] map, int startY, int startX, int sizeXMax, int sizeYMax, int direction) {
        for (int i = 0; i < size; i++) {
            // Ne pas check en dehors de la map
            if (startX + i >= sizeXMax || startY + i >= sizeYMax) {
                return true;
            }

            // Checker si y'a deja un bateau vers la droite et en bas
            if (direction == 0) {
                switch (map[startY][startX + i]) {
                    case TypeNavire.BIG, TypeNavire.LITTLE, TypeNavire.PORTE_AVION,
                            TypeNavire.CROISEUR, TypeNavire.SOUSMARIN, TypeNavire.TORPILLEUR, TypeNavire.CONTRE_TORPILLEUR -> {
                        return true;
                    }
                }
            } else {
                switch (map[startY + i][startX]) {
                    case TypeNavire.BIG, TypeNavire.LITTLE, TypeNavire.PORTE_AVION,
                            TypeNavire.CROISEUR, TypeNavire.SOUSMARIN, TypeNavire.TORPILLEUR, TypeNavire.CONTRE_TORPILLEUR -> {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private static class TypeNavire {
        public static final String BIG = "B";
        public static final String LITTLE = "L";
        public static final String PORTE_AVION = "P";
        public static final String CROISEUR = "C";
        public static final String SOUSMARIN = "S";
        public static final String CONTRE_TORPILLEUR = "U";
        public static final String TORPILLEUR = "T";
    }
}
