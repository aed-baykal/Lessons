package ru.geekbrains.JavaTwo.lesson1;

public interface Moveable {
    String getName();
    String getType();
    int getRunMax();
    int getJumpMax();

    default boolean run(int distance) {
        if (distance <= getRunMax()) {
            System.out.printf("%s %s runs for a distance of %d m\n", getType(), getName(), distance);
            return true;
        }
        else {
            System.out.printf("%s %s can't run %d m\n", getType(), getName(), distance);
            return false;
        }
    }

    default boolean jump(int height) {
        if (height <= getJumpMax()) {
            System.out.printf("%s %s jumps for a height of %d sm\n", getType(), getName(), height);
            return true;
        }
        else {
            System.out.printf("%s %s can't jump %d sm\n", getType(), getName(), height);
            return false;
        }
    }

    default boolean passedTheTest(Passable p) {
        if (p.getDistance() > 0) return run(p.getDistance());
        else return jump(p.getHeight());
    }

}
