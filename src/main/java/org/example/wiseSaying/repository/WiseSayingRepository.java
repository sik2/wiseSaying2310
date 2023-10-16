package org.example.wiseSaying.repository;

import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    long lastWiseSayingId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    public long write (String content, String author) {
        long id = lastWiseSayingId + 1;

        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);
        lastWiseSayingId = id;

        return id;
    }
    public void remove (WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }
    public void modify (WiseSaying wiseSaying, String author, String content) {
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);
    }

    public WiseSaying findById (int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id ) {
                return wiseSaying;
            }
        }
        return null;
    }

    public List<WiseSaying> findByAll() {
        return wiseSayings;
    }
}
