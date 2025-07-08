package ra.edu.ss02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ss02.entity.ScreenRoom;
import ra.edu.ss02.repository.ScreenRoomRepository;

import java.util.List;

@Service
public class ScreenRoomService implements IService<ScreenRoom, Long> {

    @Autowired
    private ScreenRoomRepository screenRoomRepository;

    public List<ScreenRoom> findAll() {
        return screenRoomRepository.findAll();
    }

    @Override
    public ScreenRoom save(ScreenRoom entity) {
        return screenRoomRepository.save(entity);
    }

    @Override
    public ScreenRoom findById(Long id) {
        return screenRoomRepository.findById(id).orElse(null);
    }

    @Override
    public ScreenRoom update(ScreenRoom entity) {
        if (entity.getId() != null && screenRoomRepository.existsById(entity.getId())) {
            return screenRoomRepository.save(entity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        screenRoomRepository.deleteById(id);
    }
}

