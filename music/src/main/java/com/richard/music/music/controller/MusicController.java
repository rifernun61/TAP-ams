package com.richard.music.music.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
        musics.add(new Music(1L, "Bohemian Rhapsody", "Queen"));
        musics.add(new Music(2L, "Imagine", "John Lennon"));
        musics.add(new Music(3L, "Hotel California", "Eagles"));
        return musics;
    }
}
