import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WrongConstructor {

    static Set<String> newCollection(List<String> cards) {
        HashSet<String> collection = new HashSet<String>();
        collection.addAll(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return true;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        return true;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return null;
    }
}