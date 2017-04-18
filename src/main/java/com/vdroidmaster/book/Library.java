package com.vdroidmaster.book;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

	private List<Book> library = new ArrayList<Book>();

	public void addBook(Book book) {
		library.add(book);
	}

	public List<Book> findBooks(Date from, Date to) {

		Calendar end = Calendar.getInstance();
		end.setTime(to);
		end.roll(Calendar.YEAR, 1);

		return library.stream().filter(book -> {
			return from.before(book.getPublished()) && end.getTime().after(book.getPublished());
		}).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
	}
}
