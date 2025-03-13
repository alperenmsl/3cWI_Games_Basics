package at.alperen.games.objectsgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor{
    private float x,y;
    private float radius;
    private float growing;


    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);

        this.radius = random.nextInt(20) + 10;
        this.growing = 0.05f;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public void update(int delta) {
        this.radius += growing * delta;
    }
}
