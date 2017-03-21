package com.cheyipai.platformservice.thirdparty.core.datasource;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSourceSelector {
	
	String value() default "master";
	
}
