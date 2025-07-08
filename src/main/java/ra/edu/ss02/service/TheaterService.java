package ra.edu.ss02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ss02.entity.Theater;
import ra.edu.ss02.repository.TheaterRepository;

import java.util.List;

@Service
public class TheaterService implements IService<Theater, Long> {

    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> findAll() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater save(Theater entity) {
        return theaterRepository.save(entity);
    }

    @Override
    public Theater findById(Long id) {
        return theaterRepository.findById(id).orElse(null);
    }

    @Override
    public Theater update(Theater entity) {
        if (entity.getId() != null && theaterRepository.existsById(entity.getId())) {
            return theaterRepository.save(entity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        theaterRepository.deleteById(id);
    }
}

