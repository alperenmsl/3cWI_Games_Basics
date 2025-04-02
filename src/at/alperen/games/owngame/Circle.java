package at.alperen.games.owngame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import static at.alperen.games.owngame.ObjectsGame.FIELD_SIZE;

public class Circle implements Actor {
    private float x, y;
    private float radius;
    private float speed;

    private int[][] field;

    private int directionX = 0;
    private int directionY = 0;

    public Circle(int [][] field) {
        this.x = 1;
        this.y = 1;
        this.radius = 10;
        this.speed = 0.005f;
        this.field = field;
    }


    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            directionX = 1;
            directionY = 0;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            directionX = -1;
            directionY = 0;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            directionX = 0;
            directionY = -1;

        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            directionX = 0;
            directionY = 1;
        }

        float newX = x + directionX * speed * delta;
        float newY = y + directionY * speed * delta;

        if (isValidMove(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    private boolean isValidMove(float newX, float newY) {
        int gridX = (int) newX;
        int gridY = (int) newY;

        if (gridX < 0 || gridX >= field.length || gridY < 0 || gridY >= field[0].length) {
            return false;
        }

        return field[gridX][gridY] == 0;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillOval(x * FIELD_SIZE - radius + FIELD_SIZE/2.0f, y * FIELD_SIZE - radius + FIELD_SIZE/2.0f, radius * 2, radius * 2);
    }
}
