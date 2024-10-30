package ex1;

import java.util.Optional;

public class ex1 {//인자 전달 방식 공부임,
    int num;

    public ex1(int num) {
        this.num = num;
    }
    static class increase{
        void plus(ex1 e){
            e.num++;
        }
        void minus(int n){
            n++;
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        // Optional 생성
        Optional<String> optionalName = Optional.ofNullable(getName());

        // 값이 있는지 확인하고, 값이 있을 경우에만 출력
        optionalName.ifPresent(name -> System.out.println("이름: " + name));

        // 값이 없을 때 기본값 설정
        String nameOrDefault = optionalName.orElse("기본 이름");
        System.out.println("이름: " + nameOrDefault);

        // 값이 없을 때 예외를 발생시키기
//        String nameOrThrow = optionalName.orElseThrow(() -> new IllegalArgumentException("이름이 없습니다."));
//        System.out.println("이름: " + nameOrThrow);
    }

    // 예시로 null을 반환하는 메서드
    public static String getName() {
        return null;
    }
    }

