package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.Request;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;

    public WiseSayingController() {
        wiseSayingService = new WiseSayingService();
    }

    public void write() {
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine().trim();

        // service
        long id = wiseSayingService.write(content, author);

        System.out.printf("%d번 명언이 등록 되었습니다.\n", id);
    }

    public void list() {
        // service
        List<WiseSaying> wiseSayings = wiseSayingService.findByAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    public void remove(Request request) {
        int id = request.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수) 값을 입력해주세요.");
            return;
        }

        // service
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayingService.remove(wiseSaying);

        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    public void modify(Request request) {
        int id = request.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수) 값을 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.printf("기존명언 : %s\n", wiseSaying.getContent());
        System.out.printf("명언 :");
        String content = Container.getScanner().nextLine().trim();

        System.out.printf("기존작가 : %s\n", wiseSaying.getAuthor());
        System.out.printf("작가 :");
        String author = Container.getScanner().nextLine().trim();

        // service
        wiseSayingService.modify(wiseSaying, author, content);

        System.out.println(id + "번 명언이 수정 되었습니다.");
    }

}
