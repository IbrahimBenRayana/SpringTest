package tn.test.spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.events.Event;
import tn.test.spring.Repository.GRepository;

import java.util.List;

public class GserviceImp<T,ID> implements Gservice<T> {


    @Autowired
    GRepository<T> gRepository;


    @Override
    public void add(T t)    {
        gRepository.save(t);
    }

    @Override
    public void delete(T t) {
        gRepository.delete(t);
    }



    @Override
    public void update(T t) {
        gRepository.save(t);
    }

    @Override
    public List<T> retrieveAll() {
        return  gRepository.findAll();

    }



}

