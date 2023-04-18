package my_project.model;

public class Pear extends Fruit{
    protected double offset;
    public Pear(double x, double y, Player[] players, double offset){
        super (x, y, "src/main/resources/graphic/fruits/pear.png", players);

        this.offset = offset;
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        if ((int)timer % 2 == 0) {
            x += offset*dt;
        } else {
            x -= offset*dt;
        }
    }
}