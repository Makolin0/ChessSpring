package ChessSpring;

import ChessSpring.pieces.Piece;
import ChessSpring.pieces.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<Integer, Integer> mapa = new HashMap<>();

        mapa.put(1, 3);

        System.out.println(mapa.get(0));
        System.out.println(mapa.get(1));
        System.out.println(mapa.get(2));
        System.out.println(mapa);


        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
        System.out.println(capitalCities.get("USA"));

        Position pos1 = new Position(10); // 2,1
        Position pos2 = new Position(15); // 7,1

        System.out.println(pos1);
        System.out.println(pos2);


        List<Position> posList = new ArrayList<>();
        posList.add(new Position(0));
        posList.add(new Position(1));
        posList.add(new Position(2));
        System.out.println(posList);
        System.out.println(posList.contains(new Position(2)));



    }
}
