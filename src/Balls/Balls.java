package Balls;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Math;

/**
 * Class Balls avec les méthodes spécifiques
 * @author JEDOUI kacem, FEGUIRI Wael, SHIMOU Yasser
 */
public class Balls {
	private final static int MAX_SPEED = 100;
	private final static int RADIUS = 100;

	private int x;
	private  int y;
	private LinkedList<Point> balls;
	private LinkedList<Point> ballstart;

	/**
	 * Un constructeur de classe Balls
	 */
	public  Balls(){
		this.balls = new LinkedList<Point>();
		this.ballstart= new LinkedList<Point>();
	}

	/**
	 * SetX()
	 * @param x  : abcisse
	 */
	public  void setX(int x){
		this.x=x;
	}

	/**
	 * SetY()
	 * @param y : Ordonnée
 	 */

	public  void setY (int y){
		this.y=y;
	}

	public  int getX(){
			return this.x;
	}
	public int getY(){
		return this.y;
	}
	public Iterator<Point> iterator() {
		return balls.iterator();
	}

	/**
	 * Ajouter un point la liste des balls
	 * @param p : Point
	 */
	public  void addBall(Point p){
		this.balls.add(p);
		this.ballstart.add(new Point(p));
	}

	/**
	 * On affiche une LinkedList liste
	 * @param liste
	 */
	public void afficheListe(LinkedList<Point> liste){
		for (Point p : liste){
			System.out.println(p);
		}
		System.out.println("");
	}

	/**
	 * Translater la liste de balls
	 * @param dx : dếphasage dx
	 * @param dy : déphasage dy
	 */

	public void translate(int dx, int dy) {
		for (Point p : this.balls){
			p.translate(dx,dy);
		}
	}

	public void reInit() {
		Iterator<Point> ballInitIterator = this.ballstart.iterator();
		for(Point b : balls)
			b.setLocation(ballInitIterator.next());
	}
	public void animBalls(int x, int y){
		int xRand;
		int yRand;
		int ourX;
		int ourY;

		for (Point p : this.balls) {
			xRand = (int) (Math.random() * 2 * MAX_SPEED ) - MAX_SPEED  ;
			yRand = (int) (Math.random() * 2 * MAX_SPEED ) - MAX_SPEED ;

			ourX = (int) p.getX() + xRand;
			ourY = (int) p.getY() + yRand;

			if (ourX - RADIUS < 0) {
				ourX = RADIUS;
			}
			if (ourY - RADIUS < 0) {
				ourY = RADIUS;
			}

			if (ourX > x - RADIUS) {
				ourX = x - RADIUS;
			}
			if (ourY > x - RADIUS) {
				ourY = x - RADIUS;
			}

			p.setLocation(ourX, ourY);
		}
	}

    @Override
	public String toString() {
		String str= new String("(");
		Iterator<Point> it = balls.iterator();
		while (it.hasNext()){
			Point p= it.next();
			str +=p;
			str += ", ";
		}
		str += ")";
		return  str;
	}


	/**
	 * Test de la classe Balls
	 * @author JEDOUI kacem, FEGUIRI Wael, SHIMOU Yasser
	 * @see Balls
	 */

	public static class TestBalls {

		public static void main(String[] args) {
			Balls b =new Balls();
			b.addBall(new Point (10,10));
			b.addBall(new Point (15,20));
			b.addBall(new Point (20,30));
			b.addBall(new Point (40,45));
			System.out.println("La liste initiale");
			System.out.println(b.toString());

			b.translate(5,5);
			System.out.println("On translate");
			System.out.println(b.toString());


			System.out.println("Retour case de départ");
			b.reInit();
			System.out.println(b.toString());


		}

	}
}
