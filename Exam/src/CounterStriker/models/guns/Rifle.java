package CounterStriker.models.guns;
//created by J.M.

public class Rifle extends GunImpl{

    private static final int COUNT_OF_SHOOTS = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {

        if (this.getBulletsCount() < COUNT_OF_SHOOTS) {
            return super.fire();
        }
        this.setBulletsCount(getBulletsCount() - COUNT_OF_SHOOTS);
        return COUNT_OF_SHOOTS;
    }
}
