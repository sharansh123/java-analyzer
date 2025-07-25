import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WrongAddCard {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        if(collection.contains(card)) {
            collection.add(card);
            return true;
        }
        return false;
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return true;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        return true;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return null;
        //throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.allCards() method");
    }
}