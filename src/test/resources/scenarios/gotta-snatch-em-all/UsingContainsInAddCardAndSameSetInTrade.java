import java.util.HashSet;
import java.util.List;
import java.util.Set;

class UsingContainsInAddCardAndSameSetInTrade {

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

        Set<String> theirSet = new HashSet<>(theirCollection);
        theirSet.removeAll(myCollection);
        myCollection.removeAll(theirCollection);
        return myCollection.size() > 0  && theirSet.size() > 0;

    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> commonCards = collections.get(0);
        for(Set<String> collection : collections) {
            commonCards = commonCards.retainAll(collection);
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