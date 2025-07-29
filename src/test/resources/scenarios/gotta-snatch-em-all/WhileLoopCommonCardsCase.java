import java.util.*;
import java.util.stream.Collectors;

public class WhileLoopCommonCardsCase {
    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
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
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < collections.size(); i++) {
            Iterator<String> iterator = collections.get(i).iterator();
            while(iterator.hasNext()) {
                String card = iterator.next();
                map.put(card, map.getOrDefault(card, 0) + 1);
            }
        }
        return map.keySet()
                .stream().filter(x -> map.get(x) == collections.size())
                .collect(Collectors.toSet());
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = collections.get(0);
        Iterator<Set<String>> iterator = collections.iterator();
        while(iterator.hasNext()) {
            allCards.addAll(iterator.next());
        }
        return allCards;
    }
}