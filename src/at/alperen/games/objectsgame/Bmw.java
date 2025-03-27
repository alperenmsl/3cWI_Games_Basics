package at.alperen.games.objectsgame;

import org.newdawn.slick.*;

public class Bmw implements Actor {
    private Image bmwImage;
    private float x, y;

    public Bmw() throws SlickException {
        this.bmwImage = new Image("testdata/M4CompBMW.png").getScaledCopy(50,50);
        this.x = 100;
        this.y = 100;
    }

    @Override
    public void render(Graphics graphics) {
        bmwImage.draw(x, y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x++;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y--;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y++;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
