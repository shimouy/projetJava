package Tests;
import  Balls.Balls;
import java.awt.Point;

public class TestBalls {
    public static void main(String[] args) {
        Balls balls = new Balls();
        balls.addBall(new Point(30,20));
        balls.addBall(new Point(100,100));
        balls.addBall(new Point(200,280));
        balls.addBall(new Point(250,200));
        balls.addBall(new Point(180,300));
        System.out.println("Notre liste de ballons");
        System.out.println(balls.toString());
        System.out.println("On translate de (+5 , +10)");
        balls.translate(5, 10);
        System.out.println(balls.toString());
        System.out.println("On translate de (+25 , -10)");
        balls.translate(25, -10);
        System.out.println(balls.toString());
        System.out.println("Retour au début");
        balls.reInit();
        System.out.println(balls.toString());

    }
}
