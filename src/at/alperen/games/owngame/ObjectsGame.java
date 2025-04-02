package at.alperen.games.owngame;

import at.alperen.games.owngame.Circle;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class ObjectsGame extends BasicGame {
    public static final int FIELD_SIZE=30;

    private List<Actor> actors;
    private int [][] field;


    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        field = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        Circle circle = new Circle(field);
        this.actors.add(circle);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    graphics.setColor(Color.green);
                    graphics.fillRect(i * FIELD_SIZE, j * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE);
                }
            }
        }
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new at.alperen.games.owngame.ObjectsGame("Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
