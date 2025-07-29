import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WhileAndForEachLoopAddAllCardsCase {

    static Set<String> newCollection(List<String> cards) {
        List<String> newCards = cards;
        return new HashSet<>(newCards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        Set<String> mySet = myCollection.stream()
                .filter(val -> !theirCollection.contains(val))
                .collect(Collectors.toSet());

        Set<String> theirSet = theirCollection.stream()
                .filter(val -> !myCollection.contains(val))
                .collect(Collectors.toSet());

        return mySet.size() > 0  && theirSet.size() > 0;
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
        Set<String> allCards = new HashSet<>();
        collections.forEach(
                collection -> {
                    Iterator<String> iterator = collection.iterator();
                    while (iterator.hasNext()) {
                        allCards.add(iterator.next());
                    }
                }
        );
        return allCards;
    }
}