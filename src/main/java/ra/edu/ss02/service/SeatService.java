package ra.edu.ss02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ss02.entity.Seat;
import ra.edu.ss02.repository.SeatRepository;

import java.util.List;

@Service
public class SeatService implements IService<Seat, Long> {

    @Autowired
    private SeatRepository seatRepository;

   public List<Seat> findAll() {
       return seatRepository.findAll();
   }

    @Override
    public Seat save(Seat entity) {
        return seatRepository.save(entity);
    }

    @Override
    public Seat findById(Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    @Override
    public Seat update(Seat entity) {
        if (entity.getId() != null && seatRepository.existsById(entity.getId())) {
            return seatRepository.save(entity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        seatRepository.deleteById(id);
    }
}

