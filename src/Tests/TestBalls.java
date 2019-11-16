package Tests;
import Balls.*;
public class TestBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Balls b=new Balls(0,0);
		b.translate(1,2);
		System.out.println(b.toString()+"\n");
		b.reInit();
		System.out.println(b.toString()+"\n");
	}

}
