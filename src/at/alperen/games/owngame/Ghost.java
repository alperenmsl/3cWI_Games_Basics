package at.alperen.games.owngame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class Ghost implements Actor {
    private float x, y;
    private final Color color;
    private Direction direction;
    private final int[][] field;
    private final Random random = new Random();

    public Ghost(float x, float y, Color color, int[][] field) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.field = field;
        this.direction = getRandomDirection();
    }

    private Direction getRandomDirection() {
        Direction[] directions = Direction.values();
        return directions[random.nextInt(directions.length)];
    }

    private boolean canMove(Direction dir) {
        int nextX = (int)((x + dir.dx * ObjectsGame.FIELD_SIZE) / ObjectsGame.FIELD_SIZE);
        int nextY = (int)((y + dir.dy * ObjectsGame.FIELD_SIZE) / ObjectsGame.FIELD_SIZE);
        if (nextY < 0 || nextY >= field.length || nextX < 0 || nextX >= field[0].length) return false;
        return field[nextY][nextX] != 1;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.setColor(color);
        graphics.fillOval(x, y, ObjectsGame.FIELD_SIZE, ObjectsGame.FIELD_SIZE);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        float speed = 0.1f * delta;

        // Versuch Bewegung
        if (canMove(direction)) {
            x += direction.dx * speed;
            y += direction.dy * speed;
        } else {
            // Richtung ändern, wenn Wand
            direction = getRandomDirection();
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
