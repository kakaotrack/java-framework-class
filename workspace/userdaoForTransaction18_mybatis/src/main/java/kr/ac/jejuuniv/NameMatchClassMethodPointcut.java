package kr.ac.jejuuniv;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

public class NameMatchClassMethodPointcut extends NameMatchMethodPointcut{
	public void setMappedClassName(final String mappedClassName) {
		this.setClassFilter(new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> clazz) {
				return PatternMatchUtils.simpleMatch(mappedClassName, clazz.getSimpleName());
			}
		});
	}
}
