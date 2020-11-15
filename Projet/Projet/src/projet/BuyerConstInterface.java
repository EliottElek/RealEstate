package projet;
/*In this interface will be sotred every constants, such as : 
 -Types of properties
 -number minimum of rooms
 -number maximum of rooms
 -price range
 -proximity to transportation
 */

public interface BuyerConstInterface {

    final String[] typesoflocations = {"All locations", "City","Town", "Suburbs", "Country"};
    final String[] typesofproperties = {"All properties", "Single family detached house", "House", "Appartment", "Commercial Estate", "Industrial Estate", "land", "Agricol Land", "Building Land", "Castle", "Mansion", "Mas", "Ranch", "Farm", "Batide", "Windmill", "Barn"};
    final String[] typesofproximities = {"All", "Far", "Intermediate", "Close", "Very close"};
    final String[] minrooms = {"No min", "1", "2", "3", "4", "5"};
    final String[] maxrooms = {"No max", "1", "2", "3", "4", "5", "6", "6+"};
    final String[] typesrenovation = {"All", "No renovation", "Very little renovation", "Some renovation", "Important renovation", "Complete renovation"};
    final String[] propertystate = {"All", "Brand new", "Recent", "Old", "Very old"};
}
