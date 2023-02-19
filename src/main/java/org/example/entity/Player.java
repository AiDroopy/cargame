package org.example.entity;

import org.example.GamePanel;
import org.example.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "south";
    }
    public void getPlayerImage() {
        try {
            north1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/car_red_north.png")));
            north2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/car_red_north2.png")));
            south1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/car_red_south.png")));
            south2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/car_red_south2.png")));
            west1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/car_red_west.png")));
            west2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/car_red_west2.png")));
            east1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/car_red_east.png")));
            east2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/car_red_east2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if ( keyHandler.rightPressed || keyHandler.upPressed ||
                keyHandler.leftPressed || keyHandler.downPressed) {

            if(keyHandler.upPressed) {
                direction = "north";
                y -= speed;
            } else if (keyHandler.downPressed) {
                direction = "south";
                y += speed;
            } else if (keyHandler.leftPressed) {
                direction = "west";
                x -= speed;
            } else {
                direction = "east";
                x += speed;
            }

            spriteCounter ++;

            if ( spriteCounter > 10 ) {
                if ( spriteNumber == 1 ) {
                    spriteNumber = 2;
                } else if ( spriteNumber == 2 ) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "north" -> {
                if (spriteNumber == 1) {
                    image = north1;
                }
                if (spriteNumber == 2) {
                    image = north2;
                }
            }
            case "south" -> {
                if (spriteNumber == 1) {
                    image = south1;
                }
                if (spriteNumber == 2) {
                    image = south2;
                }
            }
            case "west" -> {
                if (spriteNumber == 1) {
                    image = west1;
                }
                if (spriteNumber == 2) {
                    image = west2;
                }
            }
            case "east" -> {
                if (spriteNumber == 1) {
                    image = east1;
                }
                if (spriteNumber == 2) {
                    image = east2;
                }
            }
        }


        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
