package annotation;

/**
 * Created by Admin on 2016/9/6.
 */

import java.lang.annotation.*;

/**
 * 水果名称注解
 *
 * @author peida
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
