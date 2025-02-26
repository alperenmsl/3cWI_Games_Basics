package at.alperen.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tests.AnimationTest;

import java.awt.*;

public class Rectangles extends BasicGame {

    private int x;
    private int y;


    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 100;
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        this.x++;
        this.y++;
        if (this.x > 800){
            this.x = 0;
            this.y = 0;
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x, this.y, 100, 100);
        graphics.drawString("Hello Player!", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
