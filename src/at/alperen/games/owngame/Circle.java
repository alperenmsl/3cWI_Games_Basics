package at.alperen.games.owngame;

import org.newdawn.slick.*;

import static at.alperen.games.owngame.ObjectsGame.FIELD_SIZE;

public class Circle implements Actor {
    private float x, y;
    private float radius = 10;
    private float speed = 0.1f;
    private int[][] field;

    private int directionX = 0;
    private int directionY = 0;

    private int nextDirectionX = 0;
    private int nextDirectionY = 0;


    public Circle(int[][] field) {
        this.field = field;
        this.x = FIELD_SIZE + FIELD_SIZE / 2.0f;
        this.y = FIELD_SIZE + FIELD_SIZE / 2.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        Input input = gameContainer.getInput();

        if (input.isKeyDown(Input.KEY_RIGHT)) {
            nextDirectionX = 1;
            nextDirectionY = 0;
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            nextDirectionX = -1;
            nextDirectionY = 0;
        }
        if (input.isKeyDown(Input.KEY_UP)) {
            nextDirectionX = 0;
            nextDirectionY = -1;
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            nextDirectionX = 0;
            nextDirectionY = 1;
        }

        boolean onTileX = Math.abs(x % FIELD_SIZE - FIELD_SIZE / 2) < 2;
        boolean onTileY = Math.abs(y % FIELD_SIZE - FIELD_SIZE / 2) < 2;

        if (onTileX && onTileY && isValidMove(x + nextDirectionX * FIELD_SIZE, y + nextDirectionY * FIELD_SIZE)) {
            directionX = nextDirectionX;
            directionY = nextDirectionY;
        }

        float newX = x + directionX * speed * delta;
        float newY = y + directionY * speed * delta;

        if (isValidMove(newX, newY)) {
            x = newX;
            y = newY;
        }
    }


    private boolean isValidMove(float newX, float newY) {
        int gridX = (int) ((newX + (directionX == -1 ? -radius : radius)) / FIELD_SIZE);
        int gridY = (int) ((newY + (directionY == -1 ? -radius : radius)) / FIELD_SIZE);

        if (gridX < 0 || gridX >= field[0].length || gridY < 0 || gridY >= field.length) {
            return false;
        }

        return field[gridY][gridX] == 0;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.setColor(Color.yellow);
        graphics.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
