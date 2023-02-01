package peaksoft.service;

import peaksoft.Dao.DevelopersDao;
import peaksoft.Dao.DevelopersImpl;
import peaksoft.model.Developers;

import java.util.List;

public class DevelopersSerImpl implements DevelopersSer {

    DevelopersDao developersDao = new DevelopersImpl();

    @Override
    public void create() {
        developersDao.create();
    }

    @Override
    public void save(Developers developers) {
        developersDao.save(developers);
    }

    @Override
    public void findById(Long id) {
        developersDao.findById(id);
    }

    @Override
    public List<Developers> getAll() {
        return developersDao.getAll();
    }

    @Override
    public void delete(Long id) {
        developersDao.delete(id);
    }

    @Override
    public void update(Long id, Developers newDevelopers) {
        developersDao.update(id,newDevelopers);
    }


}
