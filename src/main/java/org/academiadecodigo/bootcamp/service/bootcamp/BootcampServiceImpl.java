package org.academiadecodigo.bootcamp.service.bootcamp;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.persistence.dao.BootcampDao;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class BootcampServiceImpl implements BootcampService {

    private BootcampDao bootcampDao;

    public BootcampServiceImpl(BootcampDao bootcampDao) {
        this.bootcampDao = bootcampDao;
    }

    @Override
    public String getServiceName() {
        return BootcampService.class.getSimpleName();
    }

    @Override
    public void addBootcamp(Bootcamp bootcamp) {

        bootcampDao.saveOrUpdate(bootcamp);
    }

    @Override
    public void addCadet(int id, CodeCadet cadet) {

        Bootcamp bootcamp = bootcampDao.findById(id);

        if (bootcamp != null && !bootcamp.hasCadet(cadet)) {

            bootcamp.addCadet(cadet);
            bootcampDao.saveOrUpdate(bootcamp);
        }

    }

    @Override
    public Bootcamp findById(int id) {

        Bootcamp bootcamp = null;

        bootcamp = bootcampDao.findById(id);

        return bootcamp;
    }

    @Override
    public List<Bootcamp> findAll() {

        List<Bootcamp> bootcamps = null;


        bootcamps = bootcampDao.findAll();

        return bootcamps;
    }

    @Override
    public List<CodeCadet> listCadets(int id) {

        List<CodeCadet> cadets = null;

        Bootcamp bootcamp = bootcampDao.findById(id);
        
        if (bootcamp != null) {
            cadets = new ArrayList<>(bootcamp.getCadets());
        }

        return cadets;
    }
}
