package tn.test.spring.Services;

import java.util.List;

public interface Gservice<T> {

    void add(T t);
    void delete(T t);
    void update(T t);

    List<T> retrieveAll();



}
