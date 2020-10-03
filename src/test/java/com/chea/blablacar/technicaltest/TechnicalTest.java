package com.chea.blablacar.technicaltest;

import com.chea.blablacar.technicaltest.model.lawn.Lawn;
import com.chea.blablacar.technicaltest.model.mower.Direction;
import com.chea.blablacar.technicaltest.model.mower.Mower;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TechnicalTest {

    @Test
    public void testSingleMower1() throws InterruptedException {

        Lawn lawn = new Lawn(5, 5);
        int maxX = 5;
        int maxY = 5;
        Boolean[][] grid = new Boolean[maxX + 1][maxY + 1];
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                grid[i][j] = false;
            }
        }

        Mower mower = new Mower(1, 2, Direction.N, "LFLFLFLFF", lawn);
        Thread t = new Thread(mower, "Mower");
        t.start();

        Thread.sleep(1000);

        assertEquals(1, mower.getX());
        assertEquals(3, mower.getY());
        assertEquals(Direction.N, mower.getDirection());
    }

    @Test
    public void testSingleMower2() throws InterruptedException {

        Lawn lawn = new Lawn(5, 5);

        int maxX = 5;
        int maxY = 5;
        Boolean[][] grid = new Boolean[maxX + 1][maxY + 1];
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                grid[i][j] = false;
            }
        }

        Mower mower = new Mower(3, 3, Direction.E, "FFRFFRFRRF", lawn);
        Thread t = new Thread(mower, "Mower");
        t.start();

        Thread.sleep(1000);

        assertEquals(1, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Direction.E, mower.getDirection());
    }

    @Test
    public void test() throws InterruptedException {

        Lawn lawn = new Lawn(5, 5);

        int maxX = 5;
        int maxY = 5;
        Boolean[][] grid = new Boolean[maxX + 1][maxY + 1];
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                grid[i][j] = false;
            }
        }

        Mower mower1 = new Mower(1, 2, Direction.N, "LFLFLFLFF", lawn);
        Mower mower2 = new Mower(3, 3, Direction.E, "FFRFFRFRRF", lawn);

        Thread t1 = new Thread(mower1, "Mower1");
        Thread t2 = new Thread(mower2, "Mower2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Thread.sleep(1000);

    }


}
