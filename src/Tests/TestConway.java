package Tests;
import Automates.Conway;
public class TestConway {
    private static void toad(Conway life, int x, int y) {
        life.add(x - 1, y);
        life.add(x - 2, y);
        life.add(x - 3, y);

        life.add(x, y - 1);
        life.add(x - 1, y - 1);
        life.add(x - 2, y - 1);

    }
    public static int mod (int a, int b) {
        int res = a % b;
        if (res<0 && b>0) {
            res += b;
        }
        return res;
    }
    public static void main(String[] args) {
       /*
        Conway conway = new Conway(6, 6);
        conway.add(4, 5);
        conway.add(3, 5);
        conway.add(2, 5);
        conway.add(5, 4);
        conway.add(4, 4);
        conway.add(3, 4);

        */

       System.out.println(mod(-1,20));
                //System.out.println("is alive["+i+"]["+j+"]="+conway.numberOfNeighborsAlive(i,j,6,6));

    }
}

