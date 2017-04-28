package annotation;

/**
 * Created by Admin on 2016/9/6.
 */
public class Apple {

    @FruitName("Apple")
    public String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    public String appleColor;

}
