# Let's SUP 
#### Aplikacja udostępniajaca aktualna pogodę dla wskazanej miejscowości z możliwościa obejrzenia kamerek na żywo w wybranych lokalizacjach 

## Spis treści 
* [Wprowadzenie](#wprowadzenie)
* [Technologie](#technologie)
* [Zakres funkcjonalności](#zakres-funkcjonalności)
* [Ilustracje](#ilustracje)

## Wprowadzenie 
 
Aplikacja udostępniająca warunki pogodowe przeznaczona dla osób pływających na stand-up paddle board, choć aplikacja jest skierowana szczególnie do tej grupy z powodzeniem z aplikacji mogą korzystać inni wodni sportowcy jak kajakarze, windsuperzy, którzy chcą sprawdzić warunki pogodowe na danym obszarze.<br/>
<br/>
Dzięki aplikacji dowiesz się jaka jest aktualna temperatura, wody, powietrza, prędkość wiatru, stan zachmurzenia nieba, wysokość fal. Dla wielu miejsc nad morzem Bałtyckim (np. molo w Brzeźnie, Motława, molo w Sopocie, Hel) będzie możliwe obejrzeć live stream, który jeszcze bardziej pozwoli się przygotować na sesję treningową. 

**Celem biznesowym** jest stworzenie aplikacji jako funkcjonalnego narzędzia dla społeczności Stand Up Paddleboard, które umożliwi zapoznanie się z dokładnymi warunkami pogodowymi, aby mogli oni odpowiednio dostosować swoja jednostkę treningowa do wymagań jakie panują na wodzie. Natomiast **celem naukowym** jest rozwiniecie umiejętności w technologii Android z wykorzystaniem języka obiektowego Java wraz zastosowanie zewnętrznego API **_nazwaAPI_**. 

## Technologie
**Projekt jest stworzony z wykorzystaniem:**
* Android 11.0
* Java 8
* WheatherAPI
* HTML5

## Zakres funkcjonalności 

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



#### **Pogoda dla wybranej lokalizacji**
    - wyszukanie lokalizacji po nazwie 
    - wyświeltlanie xyz





## Ilustracje

