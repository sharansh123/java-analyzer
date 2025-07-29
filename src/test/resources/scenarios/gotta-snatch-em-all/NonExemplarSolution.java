import java.util.*;
import java.util.stream.Collectors;

public class NonExemplarSolution {

    static Set<String> newCollection(List<String> cards) {
        HashSet<String> collection = new HashSet<String>();
        collection.addAll(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        if(collection.contains(card)) {
            collection.add(card);
            return true;
        }
        return false;
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        Set<String> cards = new HashSet<>(myCollection);
        for (String card : theirCollection) {
            myCollection.remove(card);
        }
        Iterator<String> myIterator = cards.iterator();
        while (myIterator.hasNext()) {
            theirCollection.remove(myIterator.next());
        }
        return myCollection.size() > 0 && theirCollection.size() > 0;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        HashMap<String, Integer> map = new HashMap<>();
        for(Set<String> collection : collections) {
            for(String card : collection) {
                map.put(card, map.getOrDefault(card, 0) + 1);
            }
        }
        return map.keySet()
                .stream().filter(x -> map.get(x) == collections.size())
                .collect(Collectors.toSet());
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = new HashSet<>();
        for(Set<String> collection : collections) {
            for(String card : collection) {
                allCards.add(card);
            }
        }
        return allCards;
    }
}