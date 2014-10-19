package org.nirvana;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface ClassAnno {

	String value();
	
	String metaName() default "DummyAnnoMeta";
	
}
