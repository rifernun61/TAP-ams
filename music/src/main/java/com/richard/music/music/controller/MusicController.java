package com.richard.music.music.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richard.music.music.model.Music;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {

    @GetMapping
    public List<Music> getAllMusics() {
        // returning hardcoded registers for now
        List<Music> musics = new ArrayList<>();
        musics.add(new Music(1L, "Bohemian Rhapsody", "Queen", "A Night at the Opera", 1975));
        musics.add(new Music(2L, "Imagine", "John Lennon", "Imagine", 1971));
        musics.add(new Music(3L, "Hotel California", "Eagles", "Hotel California", 1976));
        return musics;
    }

    @GetMapping("/{id}")
    public Music getMusic(@PathVariable Long id) {
        // returning hardcoded register for now
        return new Music(id, "Bohemian Rhapsody", "Queen", "A Night at the Opera", 1975);
    }
}
