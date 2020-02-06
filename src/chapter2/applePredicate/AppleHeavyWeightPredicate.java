package chapter2.applePredicate;

import chapter2.Apple;
import chapter2.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}
