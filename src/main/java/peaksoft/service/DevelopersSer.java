package peaksoft.service;

import peaksoft.model.Developers;

import java.util.List;

public interface DevelopersSer {


    void create();
    void save(Developers developers);
    void findById(Long id);

    List<Developers> getAll();

    void delete (Long id);

    void update(Long id, Developers newDevelopers);








}
