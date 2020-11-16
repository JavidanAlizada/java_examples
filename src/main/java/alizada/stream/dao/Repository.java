package alizada.stream.dao;

import java.util.List;

public interface Repository<T> {

    List<T> getList();

    T create(T t);

    T getObject(String id);
}
