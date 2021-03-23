package interfaces;
//created by J.M.

import java.util.Map;

public interface Dump {

    Map<String, Reactor> getDumpRepository();

    void dump(String reactorName,Reactor reactor);

    Reactor restore(String reactorName);

    void destroy(String reactorName);

    String analyze();

}
