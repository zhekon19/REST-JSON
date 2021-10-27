package testgroup.filmography.dao;

import org.springframework.stereotype.Repository;
import testgroup.filmography.model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl implements FilmDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Film> films = new HashMap<>();

    static {
        Film film1 = new Film();
        film1.setId(AUTO_ID.getAndIncrement());
        film1.setTitle("Inception");
        film1.setYear(2010);
        film1.setGenre("Ski-fi");
        film1.setWatched(true);
        films.put(film1.getId(),film1);

        Film film2 = new Film();
        film2.setId(AUTO_ID.getAndIncrement());
        film2.setTitle("Inception");
        film2.setYear(2010);
        film2.setGenre("Ski-fi");
        film2.setWatched(true);
        films.put(film2.getId(),film2);

        Film film3 = new Film();
        film3.setId(AUTO_ID.getAndIncrement());
        film3.setTitle("Inception");
        film3.setYear(2010);
        film3.setGenre("Ski-fi");
        film3.setWatched(true);
        films.put(film3.getId(),film3);
    }
    @Override
    public List<Film> allFilms() {
        return new ArrayList<>(films.values());
    }

    @Override
    public void add(Film film) {
        film.setId(AUTO_ID.getAndIncrement());
        films.put(film.getId(), film);
    }

    @Override
    public void delete(Film film) {
        films.remove(film.getId());
    }

    @Override
    public void edit(Film film) {
        films.put(film.getId(),film);
    }

    @Override
    public Film getById(int id) {
        return films.get(id);
    }
}
