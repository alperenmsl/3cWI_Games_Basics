package at.alperen.games.owngame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.Random;

import java.util.List;
import java.util.ArrayList;


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

        // Ist der Geist auf dem Mittelpunkt eines Tiles?
        boolean onTile = ((int) x % ObjectsGame.FIELD_SIZE == 0) && ((int) y % ObjectsGame.FIELD_SIZE == 0);

        if (onTile) {
            int currentX = (int)(x / ObjectsGame.FIELD_SIZE);
            int currentY = (int)(y / ObjectsGame.FIELD_SIZE);

            // Sammle alle möglichen Richtungen, die NICHT in eine Wand führen
            List<Direction> possibleDirs = new ArrayList<>();
            for (Direction dir : Direction.values()) {
                if (canMoveFrom(currentX, currentY, dir)) {
                    possibleDirs.add(dir);
                }
            }

            // Entferne die entgegengesetzte Richtung zur aktuellen (damit Geist nicht umdreht)
            possibleDirs.remove(direction.getOpposite());

            // Wenn aktuelle Richtung nicht mehr möglich, wähle neue
            if (!canMoveFrom(currentX, currentY, direction) || random.nextFloat() < 0.05f) {
                if (!possibleDirs.isEmpty()) {
                    direction = possibleDirs.get(random.nextInt(possibleDirs.size()));
                } else if (canMoveFrom(currentX, currentY, direction.getOpposite())) {
                    direction = direction.getOpposite(); // als letzte Option
                }
            }
        }

        // Bewege den Geist basierend auf der aktuellen Richtung
        x += direction.dx * speed;
        y += direction.dy * speed;
    }


    private boolean canMoveFrom(int tileX, int tileY, Direction dir) {
        int nextX = tileX + dir.dx;
        int nextY = tileY + dir.dy;
        if (nextY < 0 || nextY >= field.length || nextX < 0 || nextX >= field[0].length) return false;
        return field[nextY][nextX] != 1;
    }



    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


}
