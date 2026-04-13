package com.richard.music.music.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richard.music.music.model.Music;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {

    private static final List<Music> musics = new ArrayList<>();
    private static final AtomicLong idSequence = new AtomicLong(4);

    public MusicController() {
        musics.add(new Music(1L, "Bohemian Rhapsody", "Queen", "A Night at the Opera", 1975));
        musics.add(new Music(2L, "Imagine", "John Lennon", "Imagine", 1971));
        musics.add(new Music(3L, "Hotel California", "Eagles", "Hotel California", 1976));
    }

    @GetMapping
    public ResponseEntity<List<Music>> getAllMusics() {
        return ResponseEntity.ok(musics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable Long id) {
        Optional<Music> music = musics.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();

        return music.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Music> createMusic(@RequestBody Music music) {
        music.setId(idSequence.getAndIncrement());
        musics.add(music);
        return ResponseEntity.status(HttpStatus.CREATED).body(music);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable Long id, @RequestBody Music updatedMusic) {
        for (int i = 0; i < musics.size(); i++) {
            if (musics.get(i).getId().equals(id)) {
                updatedMusic.setId(id);
                musics.set(i, updatedMusic);
                return ResponseEntity.ok(updatedMusic);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusic(@PathVariable Long id) {
        boolean removed = musics.removeIf(m -> m.getId().equals(id));
        if (removed) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
