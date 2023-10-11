package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 공통적으로 사용되는 것들을 모아두는 공간(Container) 초기화
        Container.init();

        new App().run();

        // 공통적으로 사용되는 것들을 모아두는 공간(Container) 자원해제
        Container.close();
    }
}