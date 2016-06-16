package MainScreen;


import com.google.gson.*;
import weather.CantFindWeatherException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import weather.CantFindWeatherException;
import weather.Channel;
import weather.DegreeUnit;
import weather.YahooWeatherService;

/**
 *
 * @author seeocon
 */
public class Weather {

    // Examples of weather usage
    // getWeather("Toronto").getItem().getCondition().getTemp() // returns the current temp
    // getWeather("Toronto").getItem().getCondition().getDate() // time of last update
    //  getWeather("Toronto").getItem().getTitle()              // the date
    
    /*
     * Get the high/low of the current day
    Calendar c = Calendar.getInstance();                                 // Creates a calander object
    int day = c.get(Calendar.DAY_OF_WEEK);                               // gets the current day of the week
    getWeather("Toronto").getItem().getForecasts().get(day).getHigh(); // gets the high temperature for the day
    getWeather("Toronto").getItem().getForecasts().get(day).getLow();  // gets the low temperature for the day
    getWeather("Toronto").getItem().getForecasts().get(day).getText(); // gets the current temperature (partly cloudy) for the day
    getWeather("Toronto").getImage()                                   // gets the image for the current temperature
    getWeather("Toronto").getItem().getCondition().getText().toLowerCase().contains("rain")  // check for rain
    getWeather("Toronto").getItem().getCondition().getText().toLowerCase().contains("cloud")  // check for cloud
    getWeather("Toronto").getItem().getCondition().getText().toLowerCase().contains("sun")  // check for sun
     */
    
    // The weather paramaters
    private Channel c;
    
    /** 
     * Creates a new weather object to access information
     * @param city the city to look for
     * @throws CantFindWeatherException cannot find the location
     */
    public Weather(String city) throws CantFindWeatherException{
        try {
            this.c = getWeather(city);
        } catch (CantFindWeatherException ex) {
            this.c = getWeather("Toronto");
        }
    }

    /** 
     * Gets the weather object for the specific city using the Yahoo API
     * @param city city name
     * @return the object containing conditions
     * @throws CantFindWeatherException cannot find the town
     */
    public static Channel getWeather(String city) throws CantFindWeatherException {
        try {
            // Querys the Yahoo api which returns the json format with all the information
            String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
            String query = "select woeid from geo.places where text=\"" + city + "\"";
            String fullUrlStr = baseUrl + URLEncoder.encode(query, "UTF-8") + "&format=json";

            URL fullUrl = new URL(fullUrlStr);

            ResultObject resultObject = null;
            ResultArray resultArray = null;

            // Reading through the json
            try (InputStream is = fullUrl.openStream(); InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
                String result = "";
                String read;
                while ((read = br.readLine()) != null) {
                    result += read;
                }

                Gson gson = new Gson();
                try {
                    resultObject = gson.fromJson(result, ResultObject.class);
                } catch (com.google.gson.JsonSyntaxException ex) {
                    resultArray = gson.fromJson(result, ResultArray.class);
                }
            }

            Integer woeid = null;
            if (resultObject != null) {
                if (resultObject.query.results != null) {
                    woeid = resultObject.query.results.place.woeid;
                }
            } else if (resultArray != null) {
                woeid = resultArray.query.results.place[0].woeid;
            }

            // Finding the actual weather in celcius, based on the woeID
            if (woeid != null) {
                YahooWeatherService service = new YahooWeatherService();
                Channel channel = service.getForecast(woeid.toString(),
                        DegreeUnit.CELSIUS);
                return channel;
            } else {
                throw new CantFindWeatherException();
            }
        } catch (IOException | JsonSyntaxException | JAXBException ex) {
            throw new CantFindWeatherException(ex);
        }
    }

    private static class ResultObject {

        public QueryObject query;
    }

    private static class ResultArray {

        public QueryArray query;
    }

    private static class QueryObject {

        public int count;
        public String created;
        public String lang;
        public ResultsObject results;
    }

    private static class QueryArray {

        public int count;
        public String created;
        public String lang;
        public ResultsArray results;
    }

    private static class ResultsObject {

        public Place place;
    }

    private static class ResultsArray {

        public Place[] place;
    }

    private static class Place {

        public int woeid;
    }
}
