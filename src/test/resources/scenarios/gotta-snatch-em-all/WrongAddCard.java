import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WrongAddCard {

    static Set<String> newCollection(List<String> cards) {
        List<String> newCards = cards;
        return new HashSet<>(newCards);
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
        Set<String> commonCards = collections.get(0);
        for(Set<String> collection : collections) {
            commonCards = commonCards.retainAll(collection);
        }
        return commonCards;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return null;
        //throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.allCards() method");
    }
}