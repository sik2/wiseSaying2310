package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            } else if (command.startsWith("삭제")) {
                //삭제?id=1
                String[] commandBits = command.split("\\?", 2);
                //["삭제", "id=1"]
                String actionCode = commandBits[0];
                //["id=1", "id=2"]
                String[] paramsBits = commandBits[1].split("&");
                //id=1
                Map<String, String> params = new HashMap<>();
                for (String paramStr : paramsBits) {
                    //[id, 1]
                    String[] paramStrBits = paramStr.split("=",2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];

                    params.put(key, value);
                }

                System.out.println("actionCode : " + actionCode);
                System.out.println("params : " + params);

                wiseSayingController.remove();
            }
        }
    }
}
