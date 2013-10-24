package com.example.chesstools;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/17/13
 * Time: 9:29 PM
 * To change this template use File | Settings | File Templates.
 */

public enum Figures {
    ROOK(1),
    KNIGHT(2),
    BISHOP(3),
    QUEEN(4),
    KING(5);
    private int numb;

    Figures(int numb) {
        this.numb = numb;
    }

    public int get() {
        return this.numb;
    }
    //V.1.1
}
