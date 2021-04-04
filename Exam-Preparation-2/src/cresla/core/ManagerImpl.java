package cresla.core;
//created by J.M.

import cresla.entities.modules.*;
import cresla.entities.reactors.*;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.*;

public class ManagerImpl implements Manager {

    private static int id = 0;

    private final Map<Integer, Reactor> reactorMap;
    private final Map<Integer, Module> moduleMap;

    public ManagerImpl() {

        this.reactorMap = new HashMap<>();
        this.moduleMap = new HashMap<>();
    }


    @Override
    public String reactorCommand(List<String> arguments) {

        String reactorType = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));

        Reactor reactor = reactorType.equals("Heat")
                ? new HeatReactor(Id.newId(), moduleCapacity, additionalParameter)
                : new CryoReactor(Id.newId(), moduleCapacity, additionalParameter);

        reactorMap.put(id, reactor);

        return String.format("Created %s Reactor - %d", reactorType, id);
    }

    @Override
    public String moduleCommand(List<String> arguments) {

        int reactorId = Integer.parseInt(arguments.get(0));
        int additionalParameter = Integer.parseInt(arguments.get(2));
        String moduleType = arguments.get(1);
        Module module;

        if (moduleType.equals("CryogenRod")) {

            module = new CryogenRod(Id.newId(), additionalParameter);

            reactorMap.get(reactorId).addEnergyModule((EnergyModule) module);

        } else {

            module = moduleType.equals("HeatProcessor")

                    ? new HeatProcessor(Id.newId(), additionalParameter)
                    : new CooldownSystem(Id.newId(), additionalParameter);

            reactorMap.get(reactorId).addAbsorbingModule((AbsorbingModule) module);
        }
        moduleMap.put(id, module);
        return String.format("Added %s - %d to Reactor - %d", moduleType, id, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {

        int wantedId = Integer.parseInt(arguments.get(0));
        StringBuilder output = new StringBuilder();

        if (reactorMap.containsKey(wantedId)) {
            output.append(reactorMap.get(wantedId).toString());
        } else {
            output.append(moduleMap.get(wantedId).toString());
        }

        return output.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {

        StringBuilder output = new StringBuilder();

        int cryo = (int) reactorMap.entrySet().stream()
                .filter(r -> r.getValue().getClass().getSimpleName().equals("CryoReactor")).count();

        int heat = reactorMap.size() - cryo;

        int energyModule = (int) moduleMap.entrySet().stream()
                .filter(m -> m.getValue().getClass().getSimpleName().equals("CryogenRod")).count();

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

    private static class Id{
        static int newId(){
            return ++id;
        }
    }
}
