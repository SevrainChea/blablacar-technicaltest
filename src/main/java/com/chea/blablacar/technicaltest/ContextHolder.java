package com.chea.blablacar.technicaltest;

import com.chea.blablacar.technicaltest.model.MachineThreadWrapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Holds a list of all the thread wrapping our machines implementations/instances.
 */
@Data
@Slf4j
public class ContextHolder {

    private List<MachineThreadWrapper> machineThreadWrappers;

    private ContextHolder(List<MachineThreadWrapper> machineThreadWrappers) {
        this.machineThreadWrappers = machineThreadWrappers;
    }

    public static ContextHolder build(List<MachineThreadWrapper> machineThreadWrappers) {
        return new ContextHolder(machineThreadWrappers);
    }

    public void start() throws InterruptedException {

        machineThreadWrappers.forEach(MachineThreadWrapper::run);
        for (MachineThreadWrapper machineThreadWrapper : machineThreadWrappers) {
            machineThreadWrapper.join();
            log.info(machineThreadWrapper.getMachine().getFinalPosition());
        }

    }

}
