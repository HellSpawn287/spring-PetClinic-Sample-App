package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.map;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            } else {
                throw new RuntimeException("Objects cannot be null");
            }

            map.put(object.getId(), object);
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextID = null;
        try {
            nextID = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            nextID =1L;
        }
        return nextID;
    }
}
