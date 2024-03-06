package com.lititi.exams.web.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/3/6 10:15
 *
 * 此注解只能用在方法上（ElementType.METHOD）且在运行时生效（RetentionPolicy.RUNTIME）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Debounce {
}
