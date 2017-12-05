package org.academiadecodigo.bootcamp.service.bootcamp;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.service.Service;

import java.util.List;

public interface BootcampService extends Service {

    void addBootcamp(Bootcamp bootcamp);

    void addCadet(int id, CodeCadet cadet);

    Bootcamp findById(int id);

    List<Bootcamp> findAll();

    List<CodeCadet> listCadets(int id);

}
