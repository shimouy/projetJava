package Balls;

public class Balls {

	int x;
	int y;
	int dx;
	int dy;

	public Balls() {
		this.x=0;
		this.y=0;
		this.dx=0;
		this.dy=0;
	}

	public Balls(int x,int y){
		this.x=x;
		this.y=y;
		this.dx=0;
		this.dy=0;

	}

	public void translate(int dx, int dy) {
		this.x+=dx;
		this.y+=dy;
		this.dx+=dx;
		this.dy+=dy;

	}

	public void reInit() {
		this.x-=this.dx;
		this.y-=this.dy;
		this.dx=0;
		this.dy=0;
	}

	int getX(){
		return this.x;
	}

	int getY(){
		return this.y;
	}

	int est_deplace() {
		if ((dx!=0)&&(dy!=0)) return 0;
		return 1;
	}


    @Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}


}
