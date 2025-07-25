import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WrongConstructor {

    static Set<String> newCollection(List<String> cards) {
        HashSet<String> collection = new HashSet<String>();
        collection.addAll(cards);
        //throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.newCollection() method");
    }

    static boolean addCard(String card, Set<String> collection) {
        return true;
        //throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.addCard() method");
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return true;
        //throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.canTrade() method");
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        return true;
        //throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.commonCards() method");
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return null;
        //throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.allCards() method");
    }
}