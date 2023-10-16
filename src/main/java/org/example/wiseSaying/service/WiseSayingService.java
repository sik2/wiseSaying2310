package org.example.wiseSaying.service;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public long write (String content, String author) {
        long id = wiseSayingRepository.write(content, author);
        return id;
    }

    public void remove (WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }

    public void modify (WiseSaying wiseSaying, String author, String content) {
        wiseSayingRepository.modify(wiseSaying, author, content);
    }

    public WiseSaying findById (int id) {
        return wiseSayingRepository.findById(id);
    }

    public List<WiseSaying> findByAll() {
        List<WiseSaying> wiseSayings = wiseSayingRepository.findByAll();
        return wiseSayings;
    }
}
