package com.example.chesstools;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/17/13
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */

public final class FischerRand {
    public static void main(String[] args) {
        FischerRand fischerRand = new FischerRand();
        fischerRand.rand();
        System.out.println(fischerRand);

    }

    private int[] positions = new int[size];

    public int[] getPositions() {
        return positions;
    }

    public String toString() {

        String result = "[";
        for (int i = 0; i < positions.length; i++) {
            result += toFigure(positions[i]) + "         ";
        }
        result += "]";
        return result;
    }

    private String toFigure(int i){
        if(i == 1) return "ROOK";
        if(i == 2) return "KNIGHT";
        if(i == 3) return "BISHOP";
        if(i == 4) return "QUEEN";
        if(i == 5) return "KING";
        return "blya!";
    }

    private final static int size = 8;

    public int getSize() {
        return positions.length;
    }

    FischerRand() {
        for (int i = 0; i < size; i++) {
            positions[i] = 0;
        }

    }

    private void setStartPositions() {
        positions[0] = Figures.ROOK.get();
        positions[7] = Figures.ROOK.get();
        positions[1] = Figures.KNIGHT.get();
        positions[6] = Figures.KNIGHT.get();
        positions[2] = Figures.BISHOP.get();
        positions[5] = Figures.BISHOP.get();
        positions[3] = Figures.QUEEN.get();
        positions[4] = Figures.KING.get();
    }

    public int[] rand() {
        setupBishops();
        setupRooksAndKing();
        setupKnightsAndQueen();
        return positions;
    }

    private boolean isFigure(int i) {
        return positions[i] != 0 ? true : false;
    }

    private int generatePosition(int from, int to) {
        Random random = new Random();
        int position;
        do {
            position = (random.nextInt(size) % (to - from + 1)) + from;
        } while (isFigure(position));
        return position;
    }

    private void setupBishops() {
        Random random = new Random();
        int positionForFirstBishop = (random.nextInt(size) % 4) * 2;
        positions[positionForFirstBishop] = Figures.BISHOP.get();
        int positionForSecondBishop = (random.nextInt(size) % 4) * 2 + 1;
        positions[positionForSecondBishop] = Figures.BISHOP.get();
    }

    private void swap(int first, int second) {
        int temp = second;
        second = first;
        first = temp;
    }

    private void setupRooksAndKing() {
        int positionForFirstRook;
        int positionForSecondRook;
        do {
            positionForFirstRook = generatePosition(0, size - 1);
            positionForSecondRook = generatePosition(0, size - 1);
            if(positionForFirstRook == positionForSecondRook){
                continue;
            }
            if (positionForFirstRook > positionForSecondRook) {
                swap(positionForFirstRook, positionForSecondRook);
            }
        } while (!isFreePositionBetween(positionForFirstRook + 1, positionForSecondRook - 1));
        positions[positionForFirstRook] = Figures.ROOK.get();
        positions[positionForSecondRook] = Figures.ROOK.get();
        int positionForKing = generatePosition(positionForFirstRook, positionForSecondRook);
        positions[positionForKing] = Figures.KING.get();
    }

    private boolean isFreePositionBetween(int from, int to) {
        for (int i = from; i <= to; i++) {
            if (!isFigure(i)) {
                return true;
            }
        }
        return false;
    }

    private void setupKnightsAndQueen() {
        positions[generatePosition(0, positions.length)] = Figures.QUEEN.get();
        for (int i = 0; i < 2; i++) {
            positions[generatePosition(0, positions.length)] = Figures.KNIGHT.get();
        }
    }

}
