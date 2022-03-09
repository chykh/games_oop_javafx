package ru.job4j.chess;


import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertEquals;

public class LogicTest {

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

    @Test(expected = FigureNotFoundException.class)
    public void testFNFMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        boolean check = false;
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.A1);
        logic.add(bb);
        logic.move(Cell.A1, Cell.C3);
        int result = logic.checkBy(Cell.A1);
    }

    @Test(expected = OccupiedCellException.class)
    public void testOCEMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        boolean check = false;
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.A1);
        logic.add(bb);
        BishopBlack bb2 = new BishopBlack(Cell.C3);
        logic.add(bb2);
        logic.move(Cell.A1, Cell.C3);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testIMEMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        boolean check = false;
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.A1);
        logic.add(bb);
        logic.move(Cell.A1, Cell.C6);
    }
}



