package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;



public class BishopBlackTest extends TestCase {

    public void testPosition() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        boolean check = (Cell.A1.equals(bb.position()));
        assertTrue(check);
    }

    public void testCopy() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        Figure f = bb.copy(Cell.A1);
        boolean check = (Cell.A1.equals(f.position()));
        assertTrue(check);
    }

    public void testWay() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] result = bb.way(Cell.G5);
        Cell[] road = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertTrue(Arrays.equals(road, result));
    }

    public void testWrongWay() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        try {
            Cell[] result = bb.way(Cell.G6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
