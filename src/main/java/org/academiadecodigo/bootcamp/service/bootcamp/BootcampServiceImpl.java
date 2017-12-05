package org.academiadecodigo.bootcamp.service.bootcamp;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.persistence.dao.BootcampDao;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

public class BootcampServiceImpl implements BootcampService {

    private BootcampDao bootcampDao;
    private TransactionManager tx;

    public BootcampServiceImpl(BootcampDao bootcampDao, TransactionManager tx) {
        this.bootcampDao = bootcampDao;
        this.tx = tx;
    }

    @Override
    public String getServiceName() {
        return BootcampService.class.getSimpleName();
    }

    @Override
    public void addBootcamp(Bootcamp bootcamp) {

        try {

            tx.beginWrite();
            bootcampDao.saveOrUpdate(bootcamp);
            tx.commit();

        } catch (TransactionException ex) {

            tx.rollback();

        }
    }

    @Override
    public void addCadet(int id, CodeCadet cadet) {

        try {

            tx.beginWrite();

            Bootcamp bootcamp = bootcampDao.findById(id);
            if (bootcamp != null && !bootcamp.hasCadet(cadet)) {

                bootcamp.addCadet(cadet);
                bootcampDao.saveOrUpdate(bootcamp);
            }

            tx.commit();

        } catch (HibernateException ex) {

            System.out.println("Error adding code cadet: " + ex.getMessage());
            tx.rollback();
        }

    }

    @Override
    public Bootcamp findById(int id) {

        Bootcamp bootcamp = null;

        try {

            tx.beginRead();

            bootcamp = bootcampDao.findById(id);

            tx.commit();

        } catch (TransactionException ex) {

            System.out.println("Error finding bootcamp by id: " + ex.getMessage());
            tx.rollback();
        }

        return bootcamp;
    }

    @Override
    public List<Bootcamp> findAll() {

        List<Bootcamp> bootcamps = null;

        try {

            tx.beginRead();

            bootcamps = bootcampDao.findAll();

            tx.commit();


        } catch (TransactionException ex) {

            System.out.println("Error listing bootcamps: " + ex.getMessage());
            tx.rollback();
        }

        return bootcamps;
    }

    @Override
    public List<CodeCadet> listCadets(int id) {

        List<CodeCadet> cadets = null;
        try {

            tx.beginRead();

            Bootcamp bootcamp = bootcampDao.findById(id);
            if (bootcamp != null) {
                cadets = new ArrayList<>(bootcamp.getCadets());
            }

            tx.commit();

        } catch (HibernateException ex) {

            System.out.println("Error listing code cadets: " + ex.getMessage());
            tx.rollback();
        }

        return cadets;
    }
}
