package com.guide.androidguidebot;

import android.app.DownloadManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


    public class PlacesDataBase {
        public static final String DATA_URL = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location=51.503186,-0.126446&radius=5000&type=museum&key=AIzaSyCZ2QPsrCzN8KrTE234GujTFlaRQQjQ5oI";
        public static List<VisitedPlaces> PLACES = new ArrayList<>();
        public static List<TestPlaces> TEST_PLACES = new ArrayList<>();
        public static List<String> PLACES_IDS = new ArrayList<>();

        public static void load() {
            Request request = new Request.Builder()
                    .url(DATA_URL)
                    .build();
            OkHttpClient client = new OkHttpClient();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String data = response.body().string();
                    try {
                        parse(data);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        public static void parse(String data) throws JSONException {
            JSONObject object = new JSONObject(data);
            JSONArray results = object.getJSONArray("results");
            for (int i = 0; i < results.length(); ++i) {
                JSONObject place = results.getJSONObject(i);
                double latitude = place.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
                double longitude = place.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
                String placeId = place.getString("place_id");
                TEST_PLACES.add(new TestPlaces(placeId, latitude, longitude));
            }
        }


//        public static VisitedPlaces[] PLACES = {
//                new VisitedPlaces("Памятник Николаю I", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/%D0%9F%D0%B0%D0%BC%D1%8F%D1%82%D0%BD%D0%B8%D0%BA_%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0%D1%8E_I._%D0%A1%D0%B0%D0%BD%D0%BA%D1%82-%D0%9F%D0%B5%D1%82%D0%B5%D1%80%D0%B1%D1%83%D1%80%D0%B3._%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F.JPG/536px-%D0%9F%D0%B0%D0%BC%D1%8F%D1%82%D0%BD%D0%B8%D0%BA_%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0%D1%8E_I._%D0%A1%D0%B0%D0%BD%D0%BA%D1%82-%D0%9F%D0%B5%D1%82%D0%B5%D1%80%D0%B1%D1%83%D1%80%D0%B3._%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F.JPG",
//                        "Памятник Николаю I установлен на Исаакиевской площади в Санкт-Петербурге. Расположен между Мариинским дворцом и Исаакиевским собором. Памятник начал строиться в 1856 году после смерти императора по проекту архитектора Огюста Монферрана и был открыт 25 июня (7 июля) 1859 года. \n \n Памятник представляет собой 6-метровую конную статую Николая I работы П. К. Клодта, стоящую на пьедестале. Император изображён в парадном мундире Лейб-гвардии Конного полка. Конной натурой послужил любимый жеребец государя Амалатбек."),
//                new VisitedPlaces("Исаакиевский собор", "http://www.visit-petersburg.ru/media/uploads/tourobject/196660/196660_cover.jpg.1050x700_q95_crop_upscale.jpg",
//                        "Исаа́киевский собо́р (официальное название — собор преподо́бного Исаа́кия Далма́тского) — крупнейший православный храм Санкт-Петербурга. Расположен на Исаакиевской площади. Кафедральный собор Санкт-Петербургской епархии с 1858 по 1929 год. С 1928 года имеет статус музея (музейный комплекс «Государственный музей-памятник „Исаакиевский собор“»).\n" +
//                                "\n" +
//                                "Современное здание собора является четвёртым петербургским храмом в честь Исаакия Далматского, возведённым на месте собора, спроектированного Антонио Ринальди. Автором проекта четвёртого собора, которому предназначалось стать главной православной святыней империи, стал архитектор Огюст Монферран. "),
//                new VisitedPlaces("Сад Бенуа", "http://www.benua1890.ru/web/phpthumb/phpThumb.php?src=../files/articles/LqQFzq-DebU.jpg&w=414&h=300&q=100",
//                 "В 1890-х годах территорию от Муринского ручья до окраины Петербурга взял в аренду на 50 лет архитектор Ю. Ю. Бенуа. К 1904 году по его собственным чертежам была построена ферма. Перестроена А. И. Владовским в начале XX века. Главным зданием был деревянный двухэтажный дом с башней, которая служила и украшением, и «пожарной каланчой». На ферме были также коровники, сараи, ветряная водокачка. Имелась собственная лаборатория для обработки молока перед отправкой на молочный завод (главным заказчиком фермы был завод на Моховой улице). Ферма славилась на весь Петербург, считалась образцовой, а её работники зажиточными. Она была удостоена золотой медали на проходившей в 1913 году в Петербурге Всероссийской гигиенической выставке и высшей награды — на Международной выставке. На ферме содержалось более 200 породистых коров."),
//                new VisitedPlaces("ЦНИИ РТК", "https://b2.3ddd.ru/media/cache/sky_gallery_big_resize/gallery_images/562fe65f5adfe.jpeg",
//                       "ЦНИИ робототехники и технической кибернетики (РТК) — один из крупнейших научных центров России. Расположен в Санкт-Петербурге. Направление деятельности — разработка и создание технических средств робототехники и технической кибернетики космического, воздушного, наземного и морского базирования. \n В 1973—1986 годах (архитекторы Артюшин Б. И., Савин С.) было построено здание для института на углу Тихорецкого и Светлановского проспекта, на территории бывшего совхоза Лесное-Бенуа в паре сотен метров от дачи Бенуа. В июне 1981 года ОКБ было преобразовано в Центральный научно-исследовательский институт робототехники и технической кибернетики (ЦНИИ РТК), в июне 1994 года институт получил статус Государственного научного центра Российской Федерации. Доминантой комплекса является 77-метровая башня с антенной, высота вместе с которой почти 105 метров. Башня представляет собой лабораторию для испытания космической техники[2]." )
//        };
    }