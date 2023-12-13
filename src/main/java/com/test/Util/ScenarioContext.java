package com.test.Util;



import io.cucumber.java.Before;

import java.util.HashMap;
import java.util.Map;


public class ScenarioContext { 
	 
    private static ThreadLocal<Map<String, Object>> context = new ThreadLocal<Map<String, Object>>(); 
 
    public static Object get(final String name) { 
    	final Object obj = context.get().get(name); 
        return obj; 
    } 
 
    @SuppressWarnings("unchecked") 
    public static <T> T get(final String name, final Class<T> type) { 
        final Object obj = get(name); 
        return (T) obj; 
    } 
 
    public static void put(final String name, final Object obj) { 
        context.get().put(name, obj); 
    } 
 
    @Before
    public void init() { 
        context.set(new HashMap<String, Object>()); 
    } 
}
