package at.alperen.games.owngame;

import org.newdawn.slick.*;

import static at.alperen.games.owngame.ObjectsGame.FIELD_SIZE;

public class Circle implements Actor {
    private float x, y;
    private float radius = 10;
    private float speed = 0.1f;
    private int[][] field;


    private float boostedSpeed = 0.2f;
    private boolean isBoosted = false;
    private int boostDuration = 0;

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


        int gridX = (int) (x / FIELD_SIZE);
        int gridY = (int) (y / FIELD_SIZE);


        if (gridX >= 0 && gridX < field[0].length && gridY >= 0 && gridY < field.length) {
            if (field[gridY][gridX] == 3) {
                field[gridY][gridX] = 2;
                isBoosted = true;
                boostDuration = 5000;
            }
        }

        if (isBoosted) {
            boostDuration -= delta;
            if (boostDuration <= 0) {
                isBoosted = false;
            }
        }

        float currentSpeed = isBoosted ? boostedSpeed : speed;

        float newX = x + directionX * currentSpeed * delta;
        float newY = y + directionY * currentSpeed * delta;

        boolean onTileX = Math.abs(x % FIELD_SIZE - FIELD_SIZE / 2) < 2;
        boolean onTileY = Math.abs(y % FIELD_SIZE - FIELD_SIZE / 2) < 2;

        if (onTileX && onTileY) {
            if (isValidMove(x + nextDirectionX * FIELD_SIZE, y + nextDirectionY * FIELD_SIZE)) {
                directionX = nextDirectionX;
                directionY = nextDirectionY;
            } else if (!isValidMove(x + directionX * FIELD_SIZE, y + directionY * FIELD_SIZE)) {
                directionX = 0;
                directionY = 0;
            }
        }

        if (gridX >= 0 && gridX < field[0].length && gridY >= 0 && gridY < field.length) {
            if (field[gridY][gridX] == 0) {
                field[gridY][gridX] = 2;
                collectedDots = true;
            } else {
                collectedDots = false;
            }
        }


        if (isValidMove(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    private boolean collectedDots = false;

    public boolean collectedDotsFunction() {
        return collectedDots;
    }

    private boolean isValidMove(float newX, float newY) {
        int gridX = (int) (newX / FIELD_SIZE);
        int gridY = (int) (newY / FIELD_SIZE);
        if (gridX < 0 || gridX >= field[0].length || gridY < 0 || gridY >= field.length) {
            return false;
        }
        return field[gridY][gridX] != 1;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.setColor(Color.yellow);
        graphics.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}