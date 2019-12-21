package com.ltaocs.draft.jsonDraft;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @Author: Lin Tao
 * @Date: 12/21/2019 9:30 AM
 */
public class ReadJSONExample
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("country.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray countryDetail = (JSONArray) obj;
            //System.out.println(countryDetail);
            Iterator exeiter = countryDetail.iterator();
            while (exeiter.hasNext()) {
                JSONObject exeObj = (JSONObject) exeiter.next();
                String id = exeObj.get("id").toString();
                if (id.equals("ABW")) {
                    System.out.println("true");
                    break;
                }
            }


            //countryDetail.forEach( emp -> parseCountryObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseCountryObject(JSONObject country)
    {
        //Get country object within list
        JSONObject countryObject = (JSONObject) country.get("country");

        //Get country capitalCity
        String capitalCity = (String) countryObject.get("capitalCity");
        System.out.println(capitalCity);

        //Get country region

        String region = (String) countryObject.get("region");
        System.out.println(region);

        //Get country incomeLevel
        String incomeLevel = (String) countryObject.get("incomeLevel");
        System.out.println(incomeLevel);
    }
}
