let request = [];
const getValues = (ev)=>{
    ev.preventDefault();  //to stop the form submitting
    let estate = {
        id: Date.now(),
        costMin: document.getElementById('costMin').value,
        costMax: document.getElementById('costMax').value,
        floorMin: document.getElementById('floorMin').value,
        floorMax: document.getElementById('floorMax').value,
        district: document.getElementById('district').value
    }
    request.push(estate);
    document.forms[0].reset(); // to clear the form for the next entries
    //document.querySelector('form').reset();

    localStorage.setItem('estate',JSON.stringify(estate));
    console.log(estate);
    //for display purposes only
    console.warn('added' , {request} );

    fetch("/district", {
        redirect: "follow",
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(estate)
    }).then(res => {

        console.log("Request complete! response:", res);
        $("html").replaceWith("<!DOCTYPE html>\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head>\n" +
            "    <title>Быстрый старт. Размещение интерактивной карты на странице</title>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
            "    <script src=\"https://api-maps.yandex.ru/2.1/?apikey=c785ac7c-4fe3-4a0e-973a-43b96ec1e3a3&lang=ru_RU\"\n" +
            "            type=\"text/javascript\">\n" +
            "    </script>\n" +
            "    <script type=\"text/javascript\">\n" +
            "        ymaps.ready(init);\n" +
            "\n" +
            "        function init() {\n" +
            "            var myMap = new ymaps.Map(\"map\", {\n" +
            "                center: [59.93, 30.33],\n" +
            "                zoom: 11\n" +
            "            });\n" +
            "            // Создаем кластер.\n" +
            "            var clusterer = new ymaps.Clusterer({});\n" +
            "            // Создаём точки\n" +
            "            var placemark_2 = new ymaps.Placemark([59.93026542043342, 30.326776285506025], {\n" +
            "                    balloonContent:\n" +
            "                        '<b><i> Название: </i></b>  ' + '2-к квартира, 55 м²</br>' +\n" +
            "                        '<b><i>Цена: </i></b> ' + '14000000</br>' +\n" +
            "                        '<b><i>Площадь</i></b>:   ' + '49.2</br>' +\n" +
            "                        '<b><i>Этаж</i></b>:  ' + '3</br>' +\n" +
            "                        '<b><i>Адрес:</i></b> ' + 'Санкт-Петербург, Садовая улица дом 28</br>' +\n" +
            "                        '<b><i>Описание:</i></b> ' + 'Арт. 48210565 Срочная продажа квартиры в центре Петербурга. Рядом 5 станций метро. Только наличные средства. Тихий двор. Есть место для парковки во дворе. Квартира правильной прямоугольной формы. Нет несущих стен внутри квартиры - можете делать ремонт с любой перепланировкой под себя. Высота потолков - 3,2 м. Остались вопросы? - звоните, расскажу подробнее.</br>' +\n" +
            "                        '<b><i>Номер телефона:</i></b> ' +\n" +
            "                        + '+79101513151 '\n" +
            "                            + '</br>' +\n" +
            "                        '<b><i>Имя:</i></b> ' + 'Александр</br>' +\n" +
            "                        '<b><i>Ссылка на объявление</i></b>:   ' + '<a href=\"https://spb.domclick.ru/card/sale__flat__1436517577\">Ссылка</a></br>' +\n" +
            "                        '<b><i>Фото:</i></b> </br>'\n" +
            "                        + '<img src=\"https://22.img.avito.st/640x480/8845088222.jpg\" /> </br>'\n" +
            "                        + '<img src=\"https://63.img.avito.st/640x480/8845089163.jpg\" /> </br>'\n" +
            "                        + '<img src=\"https://31.img.avito.st/640x480/8845089631.jpg\" /> </br>'\n" +
            "                    ,\n" +
            "                }\n" +
            "                , {\n" +
            "                    preset: \"islands#blueHomeIcon\",\n" +
            "                    balloonCloseButton: true,\n" +
            "                    hideIconOnBalloonOpen: true\n" +
            "                });\n" +
            "            clusterer.add(placemark_2);\n" +
            "            var placemark_1 = new ymaps.Placemark([59.931, 30.331], {\n" +
            "                    balloonContent:\n" +
            "                        '<b><i> Название: </i></b>  ' + 'Первая точка</br>' +\n" +
            "                        '<b><i>Цена: </i></b> ' + '</br>' +\n" +
            "                        '<b><i>Площадь</i></b>:   ' + '</br>' +\n" +
            "                        '<b><i>Этаж</i></b>:  ' + '</br>' +\n" +
            "                        '<b><i>Адрес:</i></b> ' + '</br>' +\n" +
            "                        '<b><i>Описание:</i></b> ' + '</br>' +\n" +
            "                        '<b><i>Номер телефона:</i></b> ' +\n" +
            "                            + '</br>' +\n" +
            "                        '<b><i>Имя:</i></b> ' + '1</br>' +\n" +
            "                        '<b><i>Ссылка на объявление</i></b>:   ' + '<a href=\"\">Ссылка</a></br>' +\n" +
            "                        '<b><i>Фото:</i></b> </br>'\n" +
            "                        + '<img src=\"https://22.img.avito.st/640x480/8845088222.jpg\" /> </br>'\n" +
            "                        + '<img src=\"https://63.img.avito.st/640x480/8845089163.jpg\" /> </br>'\n" +
            "                        + '<img src=\"https://31.img.avito.st/640x480/8845089631.jpg\" /> </br>'\n" +
            "                    ,\n" +
            "                }\n" +
            "                , {\n" +
            "                    preset: \"islands#blueHomeIcon\",\n" +
            "                    balloonCloseButton: true,\n" +
            "                    hideIconOnBalloonOpen: true\n" +
            "                });\n" +
            "            clusterer.add(placemark_1);\n" +
            "            myMap.geoObjects.add(clusterer);\n" +
            "        }\n" +
            "    </script>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "<div id=\"map\" style=\"width: 1903px; height: 961px;\"></div>\n" +
            "</body>\n" +
            "\n" +
            "</html>");
    });

}
document.addEventListener('DOMContentLoaded', ()=>{
    document.getElementById('btn').addEventListener('click', getValues);
});