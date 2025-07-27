import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WrongCommonCardCase {
    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
       return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return true;
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
        return null;
        //throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.allCards() method");
    }
}