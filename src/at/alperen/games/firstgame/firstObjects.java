package at.alperen.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

public class firstObjects extends BasicGame {

    private float rectX, rectY;
    private float ovaleX, ovaleY;
    private float circleX, circleY;

    private float ovaleSpeed = 0.5f;
    private boolean ovaleMovingRight = true;

    private float circleSpeed = 0.4f;
    private boolean circleMovingDown = true;

    private int direction = 1; // 1 right, 2 down, 3 left


    public firstObjects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        rectX = 200;
        rectY = 200;
        circleX = 50;
        circleY = 100;
        ovaleX = 500;
        ovaleY = 100;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        float move = ovaleSpeed * delta;
        float circleMove = circleSpeed * delta;
        float rectMove = 0.3f * delta;


        if (ovaleMovingRight) {
            ovaleX += move;
            if (ovaleX >= 700) ovaleMovingRight = false;
        } else {
            ovaleX -= move;
            if (ovaleX <= 40) ovaleMovingRight = true;
        }

        if (circleMovingDown) {
            circleY += move;
            if (circleY >= 500) circleMovingDown = false;
        } else {
            circleY -= move;
            if (circleY <= 100) circleMovingDown = true;
        }

        if (direction == 1) {
            rectX += rectMove;
            if (rectX >= 500) direction = 2;
        } else if (direction == 2) {
            rectY += rectMove;
            if (rectY >= 400) direction = 3;
        } else if (direction == 3) {
            rectX -= rectMove;
            if (rectX <= 200) direction = 4;
        } else if (direction == 4) {
            rectY -= rectMove;
            if (rectY <= 200) direction = 1;
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(rectX, rectY, 100, 100);
        graphics.drawOval(ovaleX, ovaleY, 100, 50);
        graphics.drawOval(circleX, circleY, 80, 80);
        graphics.drawString("Hello Player!", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new firstObjects("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}