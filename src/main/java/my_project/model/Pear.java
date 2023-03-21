package my_project.model;

public class Pear extends Fruit{
    private double offset;
    public Pear(double x, double y, Player player, double offset){
        super (x, y, "src/main/resources/graphic/pear.png", player);

        this.offset = offset;
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        if ((int)timer % 2 == 0) {
            x += offset;
        } else {
            x -= offset;
        }
    }
}