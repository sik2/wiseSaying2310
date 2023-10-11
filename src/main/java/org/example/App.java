package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;
import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }
    public void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController(sc);
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            }
        }
    }
}
