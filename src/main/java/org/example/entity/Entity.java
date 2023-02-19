package org.example.entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;
    public BufferedImage north1, north2, south1, south2, west1, west2, east1, east2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 1;
}
