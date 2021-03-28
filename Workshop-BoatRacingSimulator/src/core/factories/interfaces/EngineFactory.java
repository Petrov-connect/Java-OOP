package core.factories.interfaces;
//created by J.M.

import manager.exceptions.ArgumentException;
import models.engines.Engine;

public interface EngineFactory {
    Engine produce(String[] args) throws ArgumentException;
}
