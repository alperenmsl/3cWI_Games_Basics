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
        float baseSpeed = 0.1f;
        float speedVariance = 0.05f;
        float speed = (baseSpeed + (random.nextFloat() - 0.5f) * speedVariance) * delta;


        boolean onTile = ((int) x % ObjectsGame.FIELD_SIZE == 0) && ((int) y % ObjectsGame.FIELD_SIZE == 0);

        if (onTile) {
            int currentX = (int)(x / ObjectsGame.FIELD_SIZE);
            int currentY = (int)(y / ObjectsGame.FIELD_SIZE);

            List<Direction> possibleDirs = new ArrayList<>();
            for (Direction dir : Direction.values()) {
                if (canMoveFrom(currentX, currentY, dir)) {
                    possibleDirs.add(dir);
                }
            }

            possibleDirs.remove(direction.getOpposite());

            if (!canMoveFrom(currentX, currentY, direction) || random.nextFloat() < 0.05f) {
                if (!possibleDirs.isEmpty()) {
                    direction = possibleDirs.get(random.nextInt(possibleDirs.size()));
                } else if (canMoveFrom(currentX, currentY, direction.getOpposite())) {
                    direction = direction.getOpposite();
                }
            }
        }

        float nextX = x + direction.dx * speed;
        float nextY = y + direction.dy * speed;

        int nextTileX = (int)(nextX / ObjectsGame.FIELD_SIZE);
        int nextTileY = (int)(nextY / ObjectsGame.FIELD_SIZE);

        if (nextTileY >= 0 && nextTileY < field.length && nextTileX >= 0 && nextTileX < field[0].length) {
            if (field[nextTileY][nextTileX] != 1) {
                x = nextX;
                y = nextY;
            } else {
                direction = direction.getOpposite();
            }
        } else {
            direction = direction.getOpposite();
        }
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
