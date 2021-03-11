package com.java.practice.basic;

// Tower A B C
//1. Move Disc from A to B using C
//2. Move Disc from A to C
//3. Move Disc from B to C using A

public class TowerOfHonoi {

    public static void main(String[] args) {
        new TowerOfHonoi().TOH(3, 'A', 'B', 'C');
    }

    private void TOH(int discs, char Source, char Auxillary, char Destination) {
        if (discs > 0) {
            TOH(discs - 1, Source, Destination, Auxillary);
            System.out.println("Move Disc from " + Source + " to " + Destination);
            TOH(discs - 1, Auxillary, Source, Destination);
        }
    }
}

