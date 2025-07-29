import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LoopForTradingCase {
    static Set<String> newCollection(List<String> cards) {
        List<String> newCards = cards;
        return new HashSet<>(newCards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
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
        Set<String> commonCards = collections.get(0);
        for(Set<String> collection : collections) {
            commonCards = commonCards
                    .stream()
                    .filter(card -> collection.contains(card))
                    .collect(Collectors.toSet());
        }
        return commonCards;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = collections.get(0);
        for(Set<String> collection : collections) {
            allCards.addAll(collection);
        }
        return allCards;
    }
}