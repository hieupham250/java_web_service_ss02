package ra.edu.ss02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.edu.ss02.entity.Schedule;
import ra.edu.ss02.service.MovieService;
import ra.edu.ss02.service.ScheduleService;
import ra.edu.ss02.service.ScreenRoomService;

import java.util.List;

@Controller
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping
    public String listShowtimes(
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false) Long roomId,
            Model model) {

        List<Schedule> showtimes;

        if (movieId != null && roomId != null) {
            showtimes = scheduleService.findByMovieIdAndScreenRoomId(movieId, roomId);
        }
        else if (movieId != null) {
            showtimes = scheduleService.findByMovieId(movieId);
        } else if (roomId != null) {
            showtimes = scheduleService.findByScreenRoomId(roomId);
        }

        else {
            showtimes = scheduleService.findAll();
        }

        model.addAttribute("showtimes", showtimes);
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("rooms", screenRoomService.findAll());
        model.addAttribute("selectedMovieId", movieId);
        model.addAttribute("selectedRoomId", roomId);
        return "showtime/showtime-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("rooms", screenRoomService.findAll());
        return "showtime/showtime-add";
    }

    @PostMapping("/add")
    public String addShowtime(@ModelAttribute("schedule") Schedule schedule) {
        scheduleService.save(schedule);
        return "redirect:/showtimes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Schedule schedule = scheduleService.findById(id);
        if (schedule == null) return "redirect:/showtimes";

        model.addAttribute("schedule", schedule);
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("rooms", screenRoomService.findAll());
        return "showtime/showtime-edit";
    }

    @PostMapping("/edit/{id}")
    public String updateShowtime(@PathVariable Long id, @ModelAttribute("schedule") Schedule updated) {
        Schedule existing = scheduleService.findById(id);
        if (existing != null) {
            existing.setMovie(updated.getMovie());
            existing.setScreenRoom(updated.getScreenRoom());
            existing.setStartTime(updated.getStartTime());
            existing.setEndTime(updated.getEndTime());
            existing.setNumberSeatEmpty(updated.getNumberSeatEmpty());
            scheduleService.update(existing);
        }
        return "redirect:/showtimes";
    }

    @PostMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        scheduleService.delete(id);
        return "redirect:/showtimes";
    }
}

