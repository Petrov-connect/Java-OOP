package borderControl;
//created by J.M.
public class Robot implements Identifiable{

    private final String model;
    private final String id;

    public
    String getModel () {
        return model;
    }

    public
    Robot (String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public
    String getId () {
        return id;
    }
}
