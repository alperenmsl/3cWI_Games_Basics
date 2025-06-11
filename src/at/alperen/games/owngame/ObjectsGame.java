package at.alperen.games.owngame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.TrueTypeFont;

public class ObjectsGame extends BasicGame {
    public static final int FIELD_SIZE = 31;

    private List<Actor> actors;
    private List<Ghost> ghosts = new ArrayList<>();
    private int[][] field;
    private int score = 0;
    private Player player;
    private GameState gameState = GameState.RUNNING;




    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();


        field = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        ghosts.add(new Ghost(100, 100, new Color(52, 235, 180), field));
        ghosts.add(new Ghost(200, 200, new Color(156, 52, 235), field));
        ghosts.add(new Ghost(300, 300, new Color(217, 22, 22), field));

        player = new Player(field);
        this.actors.add(player);
    }

    private float distance(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public enum GameState {
        RUNNING,
        GAME_OVER,
        GAME_WON
    }

    private boolean allDotsCollected() {
        for (int[] row : field) {
            for (int cell : row) {
                if (cell == 0 || cell == 3) return false;
            }
        }
        return true;
    }



    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
            if (actor instanceof Player) {
                if (((Player) actor).collectedDotsFunction()) {
                    score++;
                }
            }
        }

        if (allDotsCollected()) {
            gameState = GameState.GAME_WON;
            System.out.println("🎉 Du hast gewonnen!");
        }

        for (Ghost ghost : ghosts) {
            ghost.update(gameContainer, delta);

            if (distance(ghost.getX(), ghost.getY(), player.getX(), player.getY()) < 15) {
                System.out.println("💀 Du wurdest gefressen! Der Geist hat dich erwischt.");
                gameState = GameState.GAME_OVER;
                // Game Over noch einbauen
            }


        }

        if (gameState == GameState.GAME_OVER || gameState == GameState.GAME_WON) {
            Input input = gameContainer.getInput();
            if (input.isKeyPressed(Input.KEY_ESCAPE)) {
                gameContainer.exit();
            }
            return;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    graphics.setColor(Color.blue);
                    graphics.fillRect(j * FIELD_SIZE, i * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE);
                } else if (field[i][j] == 0) {
                    graphics.setColor(Color.white);
                    graphics.fillOval(j * FIELD_SIZE + FIELD_SIZE / 2.0f - 2, i * FIELD_SIZE + FIELD_SIZE / 2.0f - 2, 4, 4);
                } else if (field[i][j] == 3) {
                    graphics.setColor(new Color(255, 50, 50));
                    graphics.fillOval(j * FIELD_SIZE + FIELD_SIZE / 2.0f - 6, i * FIELD_SIZE + FIELD_SIZE / 2.0f - 6, 12, 12);
                }
            }
        }

        if (gameState == GameState.GAME_WON) {
            graphics.setColor(new Color(50, 255, 50));
            graphics.setFont(new TrueTypeFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 50), true));
            graphics.drawString("YOU WIN!", 270, 250);
            graphics.setFont(new TrueTypeFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20), true));
            graphics.drawString("Drücke ESC zum Beenden", 270, 320);
            return; // Stoppe weiteres Zeichnen
        }

        if (gameState == GameState.GAME_OVER) {
            graphics.setColor(new Color(178, 34, 34));
            graphics.setFont(new TrueTypeFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 50), true));
            graphics.drawString("GAME OVER", 270, 250);
            graphics.setFont(new TrueTypeFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20), true));
            graphics.drawString("Drücke ESC zum Beenden", 270, 320);
            return;
        }


        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
        for (Ghost ghost : ghosts) {
            ghost.render(graphics);
        }
        graphics.setColor(Color.white);
        graphics.drawString("Score: " + score, 10, 550);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}