package chapter2.applePredicate;

import chapter2.Apple;
import chapter2.ApplePredicate;

public class AppleGreenColorPredicat implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
