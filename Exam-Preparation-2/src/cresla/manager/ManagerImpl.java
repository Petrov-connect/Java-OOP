package cresla.manager;
//created by J.M.

import cresla.interfaces.*;
import cresla.modules.CooldownSystem;
import cresla.modules.CryogenRod;
import cresla.modules.HeatProcessor;
import cresla.modules.Modules;
import cresla.reaktors.CryoReactor;
import cresla.reaktors.HeatReactor;

import java.util.*;

public class ManagerImpl implements Manager {

    private static int id = 1;

    private final InputReader reader;
    private final OutputWriter writer;
    private final Map<Integer, Reactor> reactorMap;
    private final Map<Integer, Modules> moduleMap;

    public ManagerImpl(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.reactorMap = new TreeMap<>();
        this.moduleMap = new HashMap<>();
    }

    public void run() {

        while (true) {
            List<String> input = Arrays.asList(reader.readLine().split("\\s+"));
            switch (input.get(0)) {
                case "Reactor":
                    writer.write(reactorCommand(input));
                    break;
                case "Module":
                    writer.write(moduleCommand(input));
                    break;
                case "Report":
                    writer.write(reportCommand(input));
                    break;
                case "Exit":
                    writer.write(exitCommand(input));
                    return;
            }
        }
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor = arguments.get(1).equals("Heat")
                ? new HeatReactor(id, Integer.parseInt(arguments.get(3)), Integer.parseInt(arguments.get(2)))
                : new CryoReactor(id, Integer.parseInt(arguments.get(3)), Integer.parseInt(arguments.get(2)));
        reactorMap.put(id, reactor);
        String output = String.format("Created %s Reactor - %d",
                reactor.getClass().getSimpleName().equals("CryoReactor") ? "Cryo" : "Heat", id);
        id++;
        return output;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        Modules module;
        if (arguments.get(2).equals("CryogenRod")) {
            module = new CryogenRod(id, Integer.parseInt(arguments.get(3)));
            reactorMap.get(Integer.parseInt(arguments.get(1))).addEnergyModule((EnergyModule) module);


        } else if (arguments.get(2).equals("HeatProcessor")) {
            module = new HeatProcessor(id, Integer.parseInt(arguments.get(3)));
            reactorMap.get(Integer.parseInt(arguments.get(1))).addAbsorbingModule((AbsorbingModule) module);
        } else {
            module = new CooldownSystem(id, Integer.parseInt(arguments.get(3)));
            reactorMap.get(Integer.parseInt(arguments.get(1))).addAbsorbingModule((AbsorbingModule) module);
        }
        moduleMap.put(id, module);
        String output = String.format("Added %s - %d to Reactor - %d", module.getClass().getSimpleName(), id, Integer.parseInt(arguments.get(1)));
        id++;
        return output;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        StringBuilder output = new StringBuilder();
        if (reactorMap.containsKey(Integer.parseInt(arguments.get(1)))) {
            output.append(reactorMap.get(Integer.parseInt(arguments.get(1))).toString());
        } else {
            output.append(moduleMap.get(Integer.parseInt(arguments.get(1))).toString());
        }

        return output.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        StringBuilder output = new StringBuilder();

        int cryo = (int) reactorMap.entrySet().stream().filter(r -> r.getValue().getClass().getSimpleName().equals("CryoReactor")).count();
        int heat = reactorMap.size() - cryo;
        int energyModule = (int) moduleMap.entrySet().stream().filter(m -> m.getValue().getClass().getSimpleName().equals("CryogenRod")).count();
        int absorberModule = moduleMap.size() - energyModule;
        long totalEnergy = reactorMap.values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum();
        long totalAbsorbing = reactorMap.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum();

        output.append("Cryo Reactors: ").append(cryo).append(System.lineSeparator());
        output.append("Heat Reactors: ").append(heat).append(System.lineSeparator());
        output.append("Energy Modules: ").append(energyModule).append(System.lineSeparator());
        output.append("Absorbing Modules: ").append(absorberModule).append(System.lineSeparator());
        output.append("Total Energy Output: ").append(totalEnergy).append(System.lineSeparator());
        output.append("Total Heat Absorbing: ").append(totalAbsorbing);

        return output.toString().trim();
    }
}
