package chapter2;

import chapter2.applePredicate.AppleGreenColorPredicat;
import chapter2.applePredicate.AppleHeavyWeightPredicate;

import java.util.ArrayList;
import java.util.List;
public class FilterApples {
    //1、java8 之前应对此类需求的代码写法 筛选苹果的颜色
    public static List<Apple> filterGreenApple(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory){
            if ("green".equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }
    //但是筛选不同颜色的苹果时，如果沿用上面的方法会造成代码的冗余，不方便维护
    //2、考虑将颜色作为参数传递
    public static List<Apple> filterApplesByColor(List<Apple> inventory,String color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:inventory){
            if (color.equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }
    //需求又可能会要求以一定的重量做为筛选的标准
    public static List<Apple> filterApplesByWeight(List<Apple> inventory,int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:inventory){
            if (weight>100)
                result.add(apple);
        }
        return result;
    }
    //可以发现以上的方法对每一种需求都需要对仓库重复遍历，违反了DRY规则（Don't repeat yourself）
    //3、行为参数化
    //我们可以尝试将苹果的一些属性，抽象成一个接口对选择筛选的标准进行建模
    //接口中定义了一个boolean的方法，以不同方式筛选苹果的行为参数化，作为一个boolean的返回值来判断
    //然后将这个接口作为参数传进去
    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:inventory){
            if (p.test(apple))
                result.add(apple);
        }
        return result;
    }
    //利用这种方式，获取不同属性苹果的方式，只须新建对应的类就行
    public void action(){
        ArrayList<Apple> inventory = new ArrayList<Apple>();
        //获取特定颜色的苹果
        List<Apple> getColorResult = filterApples(inventory,new AppleGreenColorPredicat());
        //获取特定重量的苹果
        List<Apple> getSomeWeightAppleResult = filterApples(inventory, new AppleHeavyWeightPredicate());
        //这样一来多种筛选行为就只使用了同一个test方法，实现了多种行为，一个参数。
    }
    //这里由于使用不同的标准对苹果筛选的时候，就需要额外建立不同的实现类来实现“筛选代码”的传递
    //不过利用java允许建匿名类的机制，只能有效省去声明类的那一行
    public void actionByNoNameClass(){
        ArrayList<Apple> inventory = new ArrayList<Apple>();
        //获取特定颜色的苹果
        List<Apple> getColorResult = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });
        //获取特定重量的苹果
        List<Apple> getSomeWeightAppleResult = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>150;
            }
        });
    }
    //然而使用内部类的表达方式，还是存在很多冗余的代码，这时更简洁，更像参数化的表达方式Lambda就出场了！
    public void actionInLambdaWay(){
        ArrayList<Apple> inventory = new ArrayList<>();
        filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    }
}
