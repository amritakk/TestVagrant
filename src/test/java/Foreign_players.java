import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Foreign_players {
    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        int count=0;

        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader("src/test/java/Team.json"));
            JSONObject jsonObject =  (JSONObject) obj;
            String name = (String) jsonObject.get("name");
            String location = (String) jsonObject.get("location");
            JSONArray players = (JSONArray) jsonObject.get("player");
            for(Object c:players){
                JSONObject player = (JSONObject) c;
                String playerName=(String)player.get("name");
                 String country=(String)player.get("country");
                String role=(String)player.get("role");
                String priceInCrores=(String)player.get("price-in-crores");
                if(country.equalsIgnoreCase("India")){
                    count++;
                }
           }
            if(count==7){
                System.out.println("Team has four foreign players");
            }
            else{
                System.out.println("Team has more than or less than four foreign players");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    }
