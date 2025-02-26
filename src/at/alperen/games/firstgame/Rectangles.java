package at.alperen.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tests.AnimationTest;

import java.awt.*;

public class Rectangles extends BasicGame {

    private float rectX, rectY;
    private float ovaleX, ovaleY;
    private float circleX, circleY;

    private float ovaleSpeed = 0.5f;
    private boolean ovaleMovingRight = true;

    private float circleSpeed = 0.4f;
    private boolean circleMovingDown = true;

    public Rectangles(String title) {
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
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}