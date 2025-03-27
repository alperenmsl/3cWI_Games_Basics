package at.alperen.games.objectsgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    private List<Actor> actors;
    private Bmw bmw;


    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();
        Bmw bmw = new Bmw();
        this.bmw = bmw;



        /*for (int i = 0; i < 10; i++) {
            boolean moveRight = true; // Hier können wir vergeben, ob sie komplett nach rechts gehen sollen oder ob sie random welche nach links andere nach rechts gehen sollen.
                                    // Mit boolean moveRight = random.nextBoolean() wird bestimmt das alle Rechtecke zufällig nach Links andere nach Rechts kommen.
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600), random.nextInt(20) + 5, moveRight);
            actors.add(rectangle);
        }*/

        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
        }

        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse(random.nextInt(800), random.nextInt(600));
            this.actors.add(ellipse);
        }
        this.actors.add(bmw);


    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            System.out.println("shoot");
            Cannonball cb = new Cannonball(this.bmw.getX(), this.bmw.getY());
            this.actors.add(cb);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }


    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }


    }

}
