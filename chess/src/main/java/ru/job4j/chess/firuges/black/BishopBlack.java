package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
         int destX = dest.getX();
         int destY = dest.getY();
         int posX = position().getX();
         int posY = position().getY();
         if (!isDiagonal(position, dest)) {
             throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
             );
         }
         int size = abs(destX - posX);
         Cell[] steps = new Cell[size];
         int deltaX = destX > posX ? 1 : -1;
         int deltaY = destY > posY ? 1 : -1;
         for (int index = 0; index < size; index++) {
             steps[index] = Cell.findBy(posX + deltaX * (index + 1),
                    posY + deltaY * (index + 1));
         }
         return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
         int destX = dest.getX();
         int destY = dest.getY();
         int posX = source.getX();
         int posY = source.getY();
         return (abs(destX - posX) == abs(destY - posY));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
