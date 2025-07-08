package ra.edu.ss02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ss02.entity.Schedule;
import ra.edu.ss02.repository.ScheduleRepository;

import java.util.List;

@Service
public class ScheduleService implements IService<Schedule, Long> {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> findByMovieId(Long movieId) {
        return scheduleRepository.findByMovieId(movieId);
    }

    public List<Schedule> findByScreenRoomId(Long roomId) {
        return scheduleRepository.findByScreenRoomId(roomId);
    }

    public List<Schedule> findByMovieIdAndScreenRoomId(Long movieId, Long roomId) {
        return scheduleRepository.findByMovieIdAndScreenRoomId(movieId, roomId);
    }

    @Override
    public Schedule save(Schedule entity) {
        return scheduleRepository.save(entity);
    }

    @Override
    public Schedule findById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    @Override
    public Schedule update(Schedule entity) {
        if (entity.getId() != null && scheduleRepository.existsById(entity.getId())) {
            return scheduleRepository.save(entity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}

