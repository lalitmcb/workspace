package com.lalit.ehcache;

import java.io.InputStream;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.lalit.ehcache.model.Student;

public class EhCacheMain {

	public static void main(String[] args) {

		// Read the cache details from ehcache.xml
		String fileName = "ehcache.xml";
		InputStream inputStream = EhCacheMain.class.getClassLoader()
				.getResourceAsStream(fileName);
		CacheManager cacheManager = CacheManager.create(inputStream);

		// Print out all the cache defined
		for (String cacheName : cacheManager.getCacheNames()) {
			Cache cache = cacheManager.getCache(cacheName);
			System.out.println("Cache is: " + cache.getName());
		}

		// Let's get hold of studentsCache
		Cache studentsCache = cacheManager.getCache("studentsCache");

		// Let's make four student object
		Student student1 = new Student(1L, "Ishana");
		Student student2 = new Student(2L, "Ekagra");
		Student student3 = new Student(3L, "Dunnu");
		Student student4 = new Student(4L, "Chukku");

		// Insert two object in cache
		studentsCache.put(new Element(student1.getId(), student1));
		studentsCache.put(new Element(student2.getId(), student2));

		// Check that the cache size is 2
		System.out.println("Cache Size: " + studentsCache.getSize());

		// Let's insert two more students
		studentsCache.put(new Element(student3.getId(), student3));
		studentsCache.put(new Element(student4.getId(), student4));

		// The cache size still remains 2 as we have specified max
		// 2 elements in the cache
		System.out.println("Cache Size: " + studentsCache.getSize());

		// As the policy is FIFO, the first two elements are evicted
		// and last two objects remain in cache
		for (Long key : (List<Long>) studentsCache.getKeys()) {
			System.out.println("Student element: "
					+ ((Student) studentsCache.get(key).getObjectValue())
							.getName());
		}

		// Creating a cache programmatically
		//You can also create a cache object and in the constructor you
		//can provide all the parameters to configure it.
		cacheManager.addCache("anotherStudentsCache");

		// Print out all the cache defined
		for (String cacheName : cacheManager.getCacheNames()) {
			Cache cache = cacheManager.getCache(cacheName);
			System.out.println("Cache is: " + cache.getName());
		}
		
		//Shutdown the cache
		cacheManager.shutdown();
	}

}
