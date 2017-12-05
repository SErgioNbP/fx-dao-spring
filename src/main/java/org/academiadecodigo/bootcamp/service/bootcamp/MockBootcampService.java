package org.academiadecodigo.bootcamp.service.bootcamp;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * An in-memory mock bootcamp service backed by a Map
 */
public class MockBootcampService implements BootcampService {

    Map<Integer, Bootcamp> bootcamps;

    public MockBootcampService() {
        bootcamps = new HashMap<>();
    }

    public MockBootcampService(Map<Integer, Bootcamp> bootcamps) {
        this.bootcamps = bootcamps;
    }

    @Override
    public String getServiceName() {
        return BootcampService.class.getSimpleName();
    }

    @Override
    public void addBootcamp(Bootcamp bootcamp) {
        bootcamps.put(bootcamp.getId(), bootcamp);
    }

    @Override
    public void addCadet(int id, CodeCadet cadet) {

        for (Integer bootcampId: bootcamps.keySet()) {
            if (bootcamps.get(bootcampId).hasCadet(cadet)) {
                return;
            }
        }

        Bootcamp bootcamp = bootcamps.get(id);
        bootcamp.addCadet(cadet);
        cadet.setBootcamp(bootcamp);
    }

    @Override
    public Bootcamp findById(int id) {
        return bootcamps.get(id);
    }

    @Override
    public List<Bootcamp> findAll() {
        return new LinkedList<>(bootcamps.values());
    }

    @Override
    public List<CodeCadet> listCadets(int id) {
        return new LinkedList<>(bootcamps.get(id).getCadets());
    }
}

