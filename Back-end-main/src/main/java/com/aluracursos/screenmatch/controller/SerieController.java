package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService servicio;

    @Autowired
    private SerieRepository repository;

    @GetMapping()
    public List<SerieDTO> obtenerTotalSeries() {
        return servicio.obtenerTotalSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obtenerTop5() {
        return servicio.obtenerTop5();
    }

    @GetMapping("/lanzamientos")
    public List<SerieDTO> obtenerLazamientosRecientes() {
        return servicio.obtenerLanzamientoRecientes();
    }

    @GetMapping("/{id}")
    public SerieDTO obtenerPorId(@PathVariable Long id) {
        return servicio.ObtenerPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obtenerTemporadas(@PathVariable Long id) {
        return servicio.obtenerTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numeroTemporada}")
    public List<EpisodioDTO> obtenerTemporadasPorNumero(@PathVariable Long id,
                                                        @PathVariable Long numeroTemporada){
        return servicio.obtenerTemporadasPorNumero(id,numeroTemporada);
    }
}
