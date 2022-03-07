package ru.job4j.chess;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest extends TestCase {

    @Test
    public void testCorrectMove()
        throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.A1);
        logic.add(bb);
        logic.move(Cell.A1, Cell.C3);
        int expected = 0;
        int result = logic.checkBy(Cell.C3);
        assertEquals(expected, result);
    }

    @Test
    public void testFNFMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        boolean check = false;
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.A1);
        logic.add(bb);
        logic.move(Cell.A1, Cell.C3);
        try {
            int result = logic.checkBy(Cell.A1);
        } catch (FigureNotFoundException e) {
            check = true;
        }
        assertTrue(check);
    }

    @Test
    public void testOCEMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        boolean check = false;
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.A1);
        logic.add(bb);
        BishopBlack bb2 = new BishopBlack(Cell.C3);
        logic.add(bb2);
        try {
            logic.move(Cell.A1, Cell.C3);
        } catch (OccupiedCellException e) {
            check = true;
        }
        assertTrue(check);
    }

    @Test
    public void testIMEMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        boolean check = false;
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.A1);
        logic.add(bb);
        try {
            logic.move(Cell.A1, Cell.C6);
        } catch (ImpossibleMoveException e) {
            check = true;
        }
        assertTrue(check);
    }
}



