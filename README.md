# LET'S SUP 
#### Aplikacja udostępniajaca aktualna pogodę dla wskazanej miejscowości z możliwościa obejrzenia kamerek na żywo w wybranych lokalizacjach 

## Spis treści 
* [Wprowadzenie](#wprowadzenie)
* [Prawa autorskie](#prawa-autorskie)
* [Specyfikacja wymagań](#specyfikacja-wymagań)
* [Architektura systemu i oprogramowania](#architektura-systemu-i-oprogramowania)
* [Zakres wdrożonych funkcjonalności](#zakres-wdrożonych-funkcjonalności)
* [Przykład kodu dla funkcjonalności](#przykład-kodu-dla-funkcjonalności)
* [Testy](#testy)
* [Ilustracje](#ilustracje)
* [Wideo](#wideo)

## Wprowadzenie 
 
Aplikacja udostępniająca warunki pogodowe przeznaczona dla osób pływających na stand-up paddle board, choć aplikacja jest skierowana szczególnie do tej grupy z powodzeniem z aplikacji mogą korzystać inni wodni sportowcy jak kajakarze, windsuperzy, którzy chcą sprawdzić warunki pogodowe na danym obszarze.<br/>
<br/>
Dzięki aplikacji dowiesz się jaka jest aktualna temperatura, wody, powietrza, prędkość wiatru, stan zachmurzenia nieba, wysokość fal. Dla wielu miejsc nad morzem Bałtyckim (np. molo w Brzeźnie, Motława, molo w Sopocie, Hel) będzie możliwe obejrzeć live stream, który jeszcze bardziej pozwoli się przygotować na sesję treningową. 

**Celem biznesowym** jest stworzenie aplikacji jako funkcjonalnego narzędzia dla społeczności Stand Up Paddleboard, które umożliwi zapoznanie się z dokładnymi warunkami pogodowymi, aby mogli oni odpowiednio dostosować swoja jednostkę treningowa do wymagań jakie panują na wodzie. Natomiast **celem naukowym** jest rozwiniecie umiejętności w technologii Android z wykorzystaniem języka obiektowego Java wraz z zastosowaniem zewnętrznego API **OpenWeatherMap**. 

## Prawa autorskie

**Licencja:** CPL (Common Public License)

**Uzasadnienie:** Jako zespół zdecydowałyśmy się na licencję wolnego oprogramowania. Licencja CPL jest podobna do znanej licencji GPL, jednakże zakazuje wykorzystania kodu źródłowego w taki sposób, aby korzystać z niego w sposób komercyjny i czerpać z niego korzyści finansowe. 

**Autorzy:**
1. Daria Łuniewska
2. Natalia Gościnna
3. Paulina Ciach

<p>
    <img src="https://user-images.githubusercontent.com/72083113/119167662-5a53cc00-ba60-11eb-9207-12a067b56f40.png" />
    <br>
    <em>Powyższa formuła dodana została do wszystkich klas i widoków</em>
</p>


## Specyfikacja wymagań
### **Wymagania funkcjonalne**			

**Priorytet:**
* 1- wymagane
* 2-przydatne
* 3-opcjonalne


| Id | Nazwa                       | Opis                                           | Priorytet |
|----|-----------------------------|------------------------------------------------|-----------|
| 1  | Obrazek startowy            | Wyświetla się przez 3s                         | 1         |
| 2  | Okno nr 1                   | Wiget pogodowy, guzik "ZACZYNAMY"              | 1         |
| 3  | Okno nr 1                   | Pogoda dla aktualnej lokalizacji               | 1         |
| 4  | Okno nr 1                   | Zmina tła zależna od pogody                    | 1         |
| 5  | Okno nr 2                   | Guziki "sprawdź pogodę"                        | 1         |
| 6  | Okno nr 2                   | Guziki "kamery na żywo"                        | 1         |
| 7  | Okno nr 3 "kamery na żywo"  | Lista z live streami                           | 1         |
| 8  | Okno nr 3 "kamery na żywo"  | Sekcje z obszarami                             | 1         |
| 9  | Okno nr 3 "kamery na żywo"  | Wyszukiwarka                                   | 1         |
| 10 | Okno nr 3 "kamery na żywo"  | Kliknięcie w lokalizacje wyświetla live stream | 1         |
| 11 | Okno nr 3 "kamery na żywo"  | Wybranie live stream z listy                   | 1         |
| 12 | Okno nr 4  "sprawdź pogodę" | wyszukania pogody w wybranym miejscu           | 1         |
| 13 | Okno nr 4  "sprawdź pogodę" | Temperatura max/min                            | 1         |
| 15 | Okno nr 4  "sprawdź pogodę" | Wiatr                                          | 1         |
| 18 | Okno nr 4  "sprawdź pogodę" | Szczegóły np. chmury, mgła itp.                | 1         |
| 19 | Okno nr 4  "sprawdź pogodę" | Prędkość wiatru                                | 1         |
| 20 | Okno nr 4  "sprawdź pogodę" | Zachmrzenie                                    | 1         |
| 23 | Okno nr 4  "sprawdź pogodę" | Ciśnienie                                      | 1         |
| 14 | Okno nr 4  "sprawdź pogodę" | Widoczność                                     | 2         |
| 16 | Okno nr 4  "sprawdź pogodę" | Temperatura odczuwalna                         | 2         |
| 17 | Okno nr 4  "sprawdź pogodę" | Wilgotność                                     | 2         |
| 21 | Okno nr 4  "sprawdź pogodę" | Indeks UV                                      | 2         |
| 22 | Okno nr 4  "sprawdź pogodę" | Wysokość fal                                   | 2         |
| 24 | Okno nr 4  "sprawdź pogodę" | Ikonki przy warkunkach pogodowych              | 2         |
| 25 | Ikonka powrotu w każdym     | Powrot do poprzedniej strony "custom button"   | 3         |
| 26 | Dziennik z plywania         | Dziennik z pływania                            | 3         |

### **Wymagania niefunkcjonalne**			

| Id | Nazwa              | Opis                                            | Priorytet |
|----|--------------------|-------------------------------------------------|-----------|
| 2  | Adroid             | Aplikacja napisana w Androidzie                 | 1         |
| 5  | Łatwość użycia     | Przyjazny interfejs dla użytkownika             | 1         |
| 7  | Wersja polska      | Wersja polska                                   | 1         |
| 8  | Wielu użytkowników | Wielu użytkowników może korzytsać jednocześnie  | 1         |
| 3  | Google Play        | Aplikacja dostępna w Google Play                | 2         |
| 4  | iOS                | Aplikacja dostępna na iPhona                    | 2         |
| 6  | Wersja angielska   | Wersja angielska                                | 2         |
| 1  | Baza danych        | Baza danych Firebase                            | 3         |

### Architektura systemu i oprogramowania 

**Architektura rozwoju:**
* Android 11.0
* Java 8
* OpenWeatherMap API
* HTML5
* JSON
* biblioteka HTTP Volley

**Architektura uruchomieniowa:**
* Android Studio z narzędziem Android Studio emulator
* Java JDK
* Urządzenie mobilne z oprogramowaniem Android

## Zakres wdrożonych funkcjonalności

### **Kamery na żywo**
* lista lokalizacji z kamerami na żywo podzielona w sekcje np. Trójmiasto zawiera kamery z Gdyni, Spotu, Gdańska
* po wybraniu lokalizacji jest właczany stream z kamery poprzez WebView -> na portalu właściciela
* filtrowanie i wyszukiwanie lokalizacji po nazwie


### **Pogoda dla wybranej lokalizacji**
* wyświetlenie lokalizacji dla wprowadzonego miasta

### **Pogoda dla aktualnej lokalizacji użytkownika**
* pobranie lokalizacji (miasta) urzadzenia do zmiennej w celu załadowania pogody dla aktualnej lokalizacji
* Zmiana tła stosownie do aktualnej pogody
* załadowania pogody dla aktualnej lokalizacji


## Przykład kodu dla funkcjonalności 

### **Kamery na żywo**
* **lista lokalizacji z kamerami na żywo podzielona w sekcje np. Trójmiasto zawiera kamery z Gdyni, Spotu, Gdańska**
 ```java   
 final ArrayList<Item> cameraList = new ArrayList<Item>();
        // Header ex. Gdansk
        cameraList.add(new SectionItem("Trójmiasto"));
        // Camera Name
        cameraList.add(new EntryItem("Molo Brzeźno"));
        cameraList.add(new EntryItem("Molo Sopot"));
        cameraList.add(new EntryItem("Gdynia"));
```
* **po wybraniu lokalizacji jest właczany stream z kamery poprzez WebView -> na portalu właściciela**
```java
Intent intent = new Intent(LiveStreamActivity.this, StreamActivity.class);
                        locationName = cameraList.get(position).getTitle();

                        switch(cameraList.get(position).getTitle()) {
                            case "Molo Brzeźno":
                                sharedValue ="<iframe src=\"https://static.webcamera.pl/player/gdansk_cam_77aeaf-webcamera.html?preroll-wait=true&amp;&amp;block-autoplay=true\" \n" +
                                        "mozallowfullscreen=\"\" webkitallowfullscreen=\"\" allowfullscreen=\"\" scrollbars=\"no\" scrolling=\"no\"></iframe>";
                                break;
                            case "Molo Sopot":
                                sharedValue ="<iframe src=\"https://imageserver.webcamera.pl/umiesc/sopot-molo\" " +
                                            "width=\"800\" height=\"450\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>";
                                break;
```
```java
String v_url = LiveStreamActivity.sharedValue;
setContentView(R.layout.activity_streams);
        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.getSettings().setDomStorageEnabled(true);

        if(v_url.contains("iframe")){
            Matcher matcher = Pattern.compile("src=\"([^\"]+)\"").matcher(v_url);
            matcher.find();
            String src = matcher.group(1);
            v_url=src;
            
            try {
                URL myURL = new URL(src);
                myWebView.loadUrl(src);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else {

            myWebView.loadDataWithBaseURL(null, "<style>img{display: inline;height: auto;max-width: 100%;}</style>"
                    + myWebView, "text/html", "UTF-8", null);}
```

* **filtrowanie i wyszukiwanie lokalizacji po nazwie** 
```java
        protected FilterResults performFiltering(CharSequence constraint) {
        
                    FilterResults results = new FilterResults();
                    ArrayList<Item> filteredArrayList = new ArrayList<Item>();

                    if(originalItem == null || originalItem.size() == 0)
                    {
                        originalItem = new ArrayList<Item>(item);
                    }
                   
                    if(constraint == null && constraint.length() == 0)
                    {
                        results.count = originalItem.size();
                        results.values = originalItem;
                    }
                    else
                    {
                        constraint = constraint.toString().toLowerCase(Locale.ENGLISH);
                        for (int i = 0; i < originalItem.size(); i++)
                        {
                            String title = originalItem.get(i).getTitle().toLowerCase(Locale.ENGLISH);
                            if(title.contains(constraint.toString()))
                            {
                                filteredArrayList.add(originalItem.get(i));
                            }
                        }
                        results.count = filteredArrayList.size();
                        results.values = filteredArrayList;
                    }
                    return results;
                }
            };

```



### **Pogoda dla wybranej lokalizacji**

* **wyświetlenie pogody dla wprowadzonego miasta** 
```java
    public void getWeather(View view) {
        String tempURL = "";
        String city = cityET.getText().toString().trim();
        if(city.equals("")) {
            resultTV.setText("Pole nie może być puste");
        } else {
            tempURL = url + "?q=" + city + "&lang=pl&units=metric&appid=" + apiKey;

            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempURL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Log.d("response", response);
                    String output ="";
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                        JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                        String weather = jsonObjectWeather.getString("main");
                        String description = jsonObjectWeather.getString("description");
                        JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                        double temp = jsonObjectMain.getDouble("temp");
                        double feelslike = jsonObjectMain.getDouble("feels_like");
                        float pressure = jsonObjectMain.getInt("pressure");
                        int humidity = jsonObjectMain.getInt("humidity");
                        JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                        String wind = jsonObjectWind.getString("speed");
                        JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                        String clouds = jsonObjectClouds.getString("all");
                        JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                        String cityName = jsonResponse.getString("name");
                        resultTV.setTextColor(Color.BLACK);
                        output += "Aktualnie pogoda wygląda następująco: "
                                + "\n Temperatura: " + df.format(temp) + "°C"
                                + "\n Odczuwalna: " + df.format(feelslike) + "°C"
                                + "\n Wilgotność: " + humidity + "%"
                                + "\n Szczegóły: " + description
                                + "\n Prędkość wiatru: " + wind + "m/s"
                                + "\n Zachmurzenie: " + clouds + "%"
                                + "\n Ciśnienie: " + pressure + "hPa";
                        resultTV.setText(output);

                    } catch (JSONException e) {;
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
```
### **Pogoda dla aktualnej lokalizacji użytkownika**
* **pobranie lokalizacji (miasta) urzadzenia do zmiennej w celu załadowania pogody dla aktualnej lokalizacji** 
```java
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(GetStartedActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else
            ActivityCompat.requestPermissions(GetStartedActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44
            );

    }
        private void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(GetStartedActivity.this, Locale.getDefault());

                        List<Address> addressList = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1);
                        cityName = addressList.get(0).getLocality().toString();
                        Log.i("To jest miasto", "miasto:" + cityName);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
    
    
```
* **załadowania pogody dla aktualnej lokalizacji** 
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);
        descriptionVal = findViewById(R.id.descriptionVal);
        tempVal = findViewById(R.id.tempVal);
        feelslikeVal = findViewById(R.id.feelslikeVal);
        humidityVal = findViewById(R.id.humidityVal);
        windVal = findViewById(R.id.windVal);
        getStartedCL = findViewById(R.id.getStartedCL);


        checkLocationIsEnabled();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(GetStartedActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else
            ActivityCompat.requestPermissions(GetStartedActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44
            );


        bGetStarted = findViewById(R.id.bGetStarted);

        bGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(GetStartedActivity.this, ChoiceActivity.class);
                startActivity(i);
            }
        });

        String tempURL = "";
        tempURL = url + "?q=" + cityName + "&lang=pl&units=metric&appid=" + apiKey;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, tempURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.d("response", response);
                String output = "";
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                    JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                    String weather = jsonObjectWeather.getString("main");
                    String description = jsonObjectWeather.getString("description");
                    JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                    double temp = jsonObjectMain.getDouble("temp");
                    double feelslike = jsonObjectMain.getDouble("feels_like");
                    float pressure = jsonObjectMain.getInt("pressure");
                    int humidity = jsonObjectMain.getInt("humidity");
                    JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                    String wind = jsonObjectWind.getString("speed");
                    JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                    String clouds = jsonObjectClouds.getString("all");
                    JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                    String cityName = jsonResponse.getString("name");
                    descriptionVal.setText(description);
                    tempVal.setText(temp + "°C");
                    feelslikeVal.setText(feelslike + "°C");
                    humidityVal.setText(humidity + "%");
                    windVal.setText(wind + "m/s");
                  }
               }
            }

```

* **Zmiana tła stosownie do aktualnej pogody** 

```java
switch (weather) {
                        case "Clear":
                            getStartedCL.setBackground(getDrawable(R.drawable.sun));
                            break;
                        case "Clouds":
                            getStartedCL.setBackground(getDrawable(R.drawable.clouds));
                            break;
                        case "Drizzle":
                            getStartedCL.setBackground(getDrawable(R.drawable.rain));
                            break;
                        case "Thunderstorm":
                            getStartedCL.setBackground(getDrawable(R.drawable.thunder));
                            break;
                        case "Snow":
                            getStartedCL.setBackground(getDrawable(R.drawable.snow));
                            break;
                        case "Fog":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Sand":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Dust":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Ash":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Tornado":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        default:
                            getStartedCL.setBackground(getDrawable(R.drawable.flower));
                    }

```
## Testy
**Aby obejrzeć scenariusze i przypadki testowe oraz sprawozdanie z wykonanych scenariuszy należy kliknąć obrazek, aby wyświetlił się w dobrej rozdzielczości.**

### Scenariusze testowe
![image](https://user-images.githubusercontent.com/35393983/119186491-74010d80-ba78-11eb-982d-a12bfbd2189c.png)

### Przypadki testowe
![image](https://user-images.githubusercontent.com/35393983/119186916-e376fd00-ba78-11eb-8dc6-853a286ea6e6.png)

### Sprawozdanie z wykonania scenariuszy testów.

Opis zakresu i sposobu realizacji testów scenariuszowych potwierdzających spełnienie wymagań funkcjonalnych Systemu, z odwołaniem do przypadków testowych ujętych w Scenariuszach Testów.

Opis osiągniętych rezultatów – Tabela wyników testów :


![image](https://user-images.githubusercontent.com/35393983/119191071-78c8c000-ba7e-11eb-9c28-e3a2b83b9e05.png)


## Ilustracje

<p>
    <img src="https://user-images.githubusercontent.com/35393983/115939618-ef35ca80-a49e-11eb-90d1-a5f553c9bfbb.JPG" alt="Splash window"/>
    <br>
    <em>Fig. 1: Widok startowy</em>
</p>
<p>
    <img src="https://user-images.githubusercontent.com/35393983/115952372-cd136b00-a4e5-11eb-8ab4-544bfdba5cc9.png"/>
    <br>
    <em>Fig. 2: Aktualna pogoda dla lokalizacji, w której znajduje się urzadzenie. Grafika zmienia się w zależności od waruknów pogodowych. </em>
</p>
<p>
    <img src="https://user-images.githubusercontent.com/35393983/115952326-90e00a80-a4e5-11eb-8a41-c8c808bd7063.png"/>
    <br>
    <em>Fig. 3: Tła dla Fig. 2 </em>
</p>
<p>
    <img src="https://user-images.githubusercontent.com/35393983/115952435-2e3b3e80-a4e6-11eb-8458-cd4f6d2d34c5.png"/>
    <br>
    <em>Fig. 4: Wybór opcji. </em>
</p>
<p>
    <img src="https://user-images.githubusercontent.com/35393983/115952513-a73a9600-a4e6-11eb-9b15-b114645ddfda.JPG"/>
    <br>
    <em>Fig. 5: Wybieranie pogody dla zadanej lokalizacji.  </em>
</p>
<p>
    <img src="https://user-images.githubusercontent.com/35393983/115939515-9cf4a980-a49e-11eb-869e-21a551619a32.JPG"/>
    <br>
    <em>Fig. 6: Lista z kamerami. Filtrowanie listy. Widok z kamery. </em>
</p>

## Wideo
[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/dZJmSyY4YWs/0.jpg)](https://www.youtube.com/watch?v=dZJmSyY4YWs)



