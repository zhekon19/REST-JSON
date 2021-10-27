package testgroup.filmography.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;
import testgroup.filmography.service.FilmServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;



//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public ModelAndView editPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editPage");
//        return modelAndView;
//    }

    @GetMapping
    public String allFilms(Model model) {
        List<Film> films = filmService.allFilms();

        model.addAttribute("filmsList", films);

        return "films";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        Film film = filmService.getById(id);
        model.addAttribute("film", film);
        return "editPage";
    }
    @PostMapping("/edit")
    public String editFilm(@ModelAttribute("film") Film film){
        filmService.edit(film);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addPage(){
        return "editPage";
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute("film") Film film){
        filmService.add(film);
        return "redirect:/";
    }
    @GetMapping(value="/delete/{id}")
    public String deleteFilm(@PathVariable("id") int id) {
        Film film = filmService.getById(id);
        filmService.delete(film);
        return "redirect:/";
    }

}
