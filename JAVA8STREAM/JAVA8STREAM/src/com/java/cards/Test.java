package com.java.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
/*below code is to cards logic */
public class Test {
	
	private static List<Card> populate() {
		
		List<Card> cards=new ArrayList<Card>();
		
		List<String> sizes=new ArrayList<String>(
				Arrays.asList("ace","king","queen","jack","10","9","8","7","6","5","4","3","2")
				);
		List<String> shapes=new ArrayList<String>(
				Arrays.asList("daimond","chidi","redpaan","blackpaan")
				);
		
		for (String shape : shapes) {
			
			for (String size : sizes) {
				
				cards.add(new Card(shape,size));
				
			}
			
		}
		
		System.out.println(cards.size());
		System.out.println(cards);

		return cards;
		
	}
	
	public static void main(String[] args) {
		
		List<Card> cards=populate();
		
		Map<String, List<Card>> map=cards.stream().collect(Collectors.groupingBy(Card::getShape));
		//Map<String,Long> mapa=cards.stream().map(card->card.getSize()).collect(Collectors.groupingBy(Card::getShape,Collectors.counting()));

		System.out.println(map);
		//System.out.println(mapa);

	
	}

}
