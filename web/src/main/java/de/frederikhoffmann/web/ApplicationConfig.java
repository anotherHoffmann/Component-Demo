package de.frederikhoffmann.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("")
public class ApplicationConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> classes = new HashSet<>();
		classes.add(PrimitiveController.class);
		classes.add(PersonController.class);
		return classes;
	}
}
