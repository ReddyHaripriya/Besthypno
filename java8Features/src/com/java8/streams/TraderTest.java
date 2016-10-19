package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;;
public class TraderTest {

	public static void main(String[] args) {
		Trader hari=new Trader("hari","new york");
		Trader vindhya=new Trader("vindhya","new york");
		Trader sam=new Trader("sam","connecticut");
		Trader sridhar=new Trader("sridhar","connecticut");
		Trader rishi=new Trader("rishi","boston");
		List<Transaction> transactions = Arrays.asList(new Transaction(hari, 2011, 300),
				new Transaction(vindhya, 2012, 1000), new Transaction(sam, 2011, 400),
				new Transaction(sridhar, 2012, 710), new Transaction(rishi, 2012, 700));
		// find all transactions for 2011 and sort them from small to high by
		// value
		List<Transaction> sortedList = transactions.stream().filter((Transaction trans) -> trans.getYear() == 2011)
				.sorted((Transaction a, Transaction b) -> a.getValue().compareTo(b.getValue())).collect(toList());
	System.out.println("the sorted list is:"+sortedList);
	// other way using method reference and comparing method from Comparator
	// interface
	transactions.stream().filter(trans -> trans.getYear() == 2011).sorted(comparing(Transaction::getValue))
			.collect(toList());
	// what are all unique cities where traders work
			List<String> uniqueCities = transactions.stream().map((Transaction trans) -> trans.getTrader().getCity())
					.distinct().collect(toList());
			System.out.println("unique cities " + uniqueCities);

			// find all traders from cambridge and sort them by name

			List<String> cambridgeTraders = transactions.stream()
					.filter((Transaction trans) -> "Cambridge".equals(trans.getTrader().getCity()))
					.map((Transaction trans) -> trans.getTrader().getName()).sorted().collect(toList());
			System.out.println("Cambridge" + cambridgeTraders);

			// other way of doing above one
			transactions.stream().map(Transaction::getTrader).filter(trader -> "Cambridge".equals(trader.getName()))
					.distinct().sorted(comparing(Trader::getName)).collect(toList());

			// return string of all trader names sorted alphabetically

			List<String> traderNames = transactions.stream().map((trans) -> trans.getTrader().getName()).sorted()
					.collect(toList());

			System.out.println("trader names sorted " + traderNames);

			// other way of doing
			String traderNameBySingleLine = transactions.stream().map(trans -> trans.getTrader().getName()).distinct()
					.sorted().reduce(" ", (n1, n2) -> n1 + n2);
			System.out.println("trader names in single line " + traderNameBySingleLine);

			// are any traders based in Milan
			boolean milanTraders = transactions.stream().anyMatch(trans -> trans.getTrader().getCity().equals("Milan"));

			// print all transcation values from traders living in Cambridge

			List<Integer> transValues = transactions.stream()
					.filter(trans -> "Cambridge".equals(trans.getTrader().getCity())).map(trans -> trans.getValue())
					.collect(toList());

			System.out.println("all transaction values of Cambridge traders " + transValues);

			// what is the highest value of all transactions

			int highestTrans = transactions.stream().map(trans -> trans.getValue()).max((a, b) -> a.compareTo(b)).get();
			System.out.println("highest transaction value " + highestTrans);

			// other way of doing
			Optional<Integer> highestTransaction = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
			System.out.println("using method reference to find highest " + highestTransaction.get());

			// find transaction with smallest value

			int smallTrans = transactions.stream().map(trans -> trans.getValue()).max((a, b) -> b.compareTo(a)).get();
			System.out.println("highest transaction value " + smallTrans);

			// more streams using Collectors interface
			List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
			List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

			System.out.println("Filtered List: " + filtered);
			String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
			System.out.println("Merged String: " + mergedString);

	}

}
