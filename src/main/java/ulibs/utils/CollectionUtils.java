package main.java.ulibs.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtils {
	public static <E> List<E> fill(int size, E e) {
		List<E> list = new ArrayList<E>();
		for (int i = 0; i < size; i++) {
			list.add(e);
		}
		
		return list;
	}
	
	public static <E> List<E> copyList(List<E> list) {
		return new ArrayList<E>(list);
	}
	
	public static <E> List<E> unmodifiableCopyList(List<E> list) {
		return unmodifiableList(copyList(list));
	}
	
	public static <E> List<E> unmodifiableList(List<E> list) {
		return Collections.unmodifiableList(list);
	}
}
