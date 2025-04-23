package at.alperen.games.owngame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import static at.alperen.games.owngame.ObjectsGame.FIELD_SIZE;

public class Ghost implements Actor {
    private float x, y;
    private float speed = 0.1f;
    private Color color;
    private int[][] field;


    public Ghost(float x, float y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        int size = FIELD_SIZE / 2;
        g.fillOval((int) x, (int) y, size, size);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

    }



    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setField(int[][] field) {
        this.field = field;
    }

    private boolean isValidMove(float newX, float newY) {
        int tileX = (int) (newX / FIELD_SIZE);
        int tileY = (int) (newY / FIELD_SIZE);

        if (tileY >= 0 && tileY < field.length && tileX >= 0 && tileX < field[0].length) {
            return field[tileY][tileX] == 0;
        }
        return false;
    }

    private void moveTowardsPlayer(int delta, float playerX, float playerY) {
        float dx = playerX - x;
        float dy = playerY - y;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);

        if (distance > 0) {
            float newX = x + (dx / distance) * speed * delta;
            float newY = y + (dy / distance) * speed * delta;

            if (isValidMove(newX, newY)) {
                x = newX;
                y = newY;
            }
        }
    }



}
