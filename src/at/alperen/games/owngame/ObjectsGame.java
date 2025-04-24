package at.alperen.games.owngame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class ObjectsGame extends BasicGame {
    public static final int FIELD_SIZE = 30;

    private List<Actor> actors;
    private List<Ghost> ghosts = new ArrayList<>();
    private int[][] field;
    private int score = 0;

    private Circle player;


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

        Circle circle = new Circle(field);
        this.actors.add(circle);

        player = new Circle(field);
        this.actors.add(player);
    }

    private float distance(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }


    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
            if (actor instanceof Circle) {
                if (((Circle) actor).collectedDotsFunction()) {
                    score++;
                }
            }
        }

        for (Ghost ghost : ghosts) {
            ghost.update(gameContainer, delta);

            if (distance(ghost.getX(), ghost.getY(), player.getX(), player.getY()) < 15) {
                System.out.println("💀 Du wurdest gefressen! Der Geist hat dich erwischt.");
                // Game Over noch einbauen
            }
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
