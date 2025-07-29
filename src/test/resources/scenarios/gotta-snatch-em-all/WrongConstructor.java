import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WrongConstructor {

    static Set<String> newCollection(List<String> cards) {
        HashSet<String> collection = new HashSet<String>();
        collection.addAll(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        Set<String> theirSet = new HashSet<>(theirCollection);
        Set<String> mySet = new HashSet<>(myCollection);
        mySet.removeAll(theirCollection);
        theirSet.removeAll(myCollection);
        return mySet.size() > 0  && theirSet.size() > 0;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> commonCards = collections.get(0);
        for(Set<String> collection : collections) {
            commonCards = commonCards
                    .stream()
                    .filter(collection::contains)
                    .collect(Collectors.toSet());
        }
        return commonCards;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = collections.get(0);
        Iterator<Set<String>> iterator = collections.iterator();
        while(iterator.hasNext()) {
            allCards = Stream.concat(allCards.stream(), iterator.next().stream()).collect(Collectors.toSet());
        }
        return allCards;
    }
}