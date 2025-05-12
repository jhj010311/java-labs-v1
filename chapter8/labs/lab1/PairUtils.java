package chapter8.labs.lab1;

import java.util.List;

/**
 * Lab 1: 제네릭 유틸리티 클래스
 *
 * 다양한 제네릭 메소드를 포함한 유틸리티 클래스를 구현하세요.
 */
public class PairUtils {
    
    /**
     * 두 객체로 구성된 Pair 객체를 생성하는 정적 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> Pair<K, V> create(K key, V value) {
        return new Pair<K, V>(key, value);
    }
    
    
    /**
     * Pair 객체의 키와 값을 바꾼 새로운 Pair 객체를 반환하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static  <K, V> Pair<V,K> swap(Pair<K, V> pair) {
        return new Pair<>(pair.getValue(), pair.getKey());
    }
    
    
    /**
     * 숫자 타입의 Pair 객체에서 키와 값의 합을 계산하는 메소드
     * Number 또는 그 하위 클래스 타입만 허용
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static double sum(Pair<? extends Number, ? extends Number> pair) {
        return pair.key.doubleValue() + pair.value.doubleValue();
    }


    /**
     * 두 Pair 객체를 비교하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> boolean equals(Pair<K, V> pair, Pair<K, V> pair2) {
        return pair.equals(pair2);
    }


    /**
     * 리스트에서 조건에 맞는 요소로 구성된 Pair 객체를 찾는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> Pair<K, V> get(List<Pair<K, V>> pairs, K key, V value) {
        for (Pair<K, V> pair : pairs) {
            if (pair.getKey().equals(key) && pair.getValue().equals(value)) {
                return pair;
            }
        }

        return null;
    }
    
    
    /**
     * 와일드카드를 사용하여 Pair 객체의 모든 가능한 타입을 처리하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static void info(Pair<?, ?> pair) {
        System.out.println("info 메서드 호출됨");
        System.out.println("매개변수의 key 값 : " + pair.getKey());
        System.out.println("매개변수의 value 값 : " + pair.getValue());
    }
}