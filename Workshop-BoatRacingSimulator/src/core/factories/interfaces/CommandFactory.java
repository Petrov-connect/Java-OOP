package core.factories.interfaces;
//created by J.M.

import core.commands.interfaces.Command;

public interface CommandFactory {
    Command produce(String type);
}
