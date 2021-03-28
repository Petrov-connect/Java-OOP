package cresla.modules;
//created by J.M.

import cresla.interfaces.Module;

public abstract class Modules implements Module {

    protected int id;

    protected Modules(int id) {
        this.id = id;

    }

    @Override
    public int getId() {
        return this.id;
    }
}
