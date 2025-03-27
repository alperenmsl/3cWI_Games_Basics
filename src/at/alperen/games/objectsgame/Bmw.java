package at.alperen.games.objectsgame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bmw implements Actor {
    private Image bmwImage;

    public Bmw() throws SlickException {
        this.bmwImage = new Image("testdata/M4CompBMW.png");
    }

    @Override
    public void render(Graphics graphics) {
        bmwImage.draw(100, 100); 
    }

    @Override
    public void update(int delta) {

    }
}
