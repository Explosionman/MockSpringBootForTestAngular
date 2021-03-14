package ru.dreamteam.mockForAngular.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.dreamteam.mockForAngular.domain.DeliveryJson;
import ru.dreamteam.mockForAngular.domain.DeliveryTime;
import ru.dreamteam.mockForAngular.domain.DeliveryType;
import ru.dreamteam.mockForAngular.mockDao.DeliveryDao;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class DataInit implements CommandLineRunner {

    public final DeliveryDao deliveryDao;

    public static DeliveryJson delivery1 = new DeliveryJson();
    public static DeliveryJson delivery2 = new DeliveryJson();
    public static DeliveryJson delivery3 = new DeliveryJson();

    public DataInit(DeliveryDao deliveryDao) {
        this.deliveryDao = deliveryDao;
    }

    static {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        delivery1.setId(1L);
        delivery1.setDeliveryDate(LocalDate.parse("11.11.2011", formatter));
        delivery1.setDeliveryTime("Вторая половина дня");
        delivery1.setCarInfo("Nissan А123АА 777");
        delivery1.setDriverInfo("Иванов Иван Иванович");
        delivery1.setBrand("ckh");
        delivery1.setOrderNumber("CKH1300045-2021");
        delivery1.setDeliveryType("Кросс-докинг");
        delivery1.setSender("ООО Какая-то там компания");
        delivery1.setComment("Комментарий");
        delivery1.setShop("");
        delivery1.setNumberOfPlaces("57");
        delivery1.setTorgNumber("516");
        delivery1.setInvoice("516");

        //---------------------------------------------------------------------------------------

        delivery2.setId(2L);
        delivery2.setDeliveryDate(LocalDate.parse("11.11.2011", formatter));
        delivery2.setDeliveryTime("Первая половина дня");
        delivery2.setCarInfo("Nissan А123АА 777");
        delivery2.setDriverInfo("Иванов Иван Иванович");
        delivery2.setBrand("ckh");
        delivery2.setOrderNumber("CKH1300045-2021");
        delivery2.setDeliveryType("Кросс-докинг");
        delivery2.setSender("ООО Какая-то там компания");
        delivery2.setComment("Комментарий");
        delivery2.setShop("");
        delivery2.setNumberOfPlaces("57");
        delivery2.setTorgNumber("516");
        delivery2.setInvoice("516");

        //---------------------------------------------------------------------------------------

        delivery3.setId(3L);
        delivery3.setDeliveryDate(LocalDate.parse("11.11.2011", formatter));
        delivery3.setDeliveryTime("Первая половина дня");
        delivery3.setCarInfo("ВАЗ А788АА 777");
        delivery3.setDriverInfo("Петров Олег Иванович");
        delivery3.setBrand("ckh");
        delivery3.setOrderNumber("CKH1300075-2021");
        delivery3.setDeliveryType("Кросс-докинг");
        delivery3.setSender("ООО НГЕ");
        delivery3.setComment("Комментарий");
        delivery3.setShop("");
        delivery3.setNumberOfPlaces("7");
        delivery3.setTorgNumber("П-00000000599");
        delivery3.setInvoice("599");
    }

    public static void init(DeliveryDao deliveryDao) {
        deliveryDao.save(delivery1);
        deliveryDao.save(delivery2);
        deliveryDao.save(delivery3);
    }

    @Override
    public void run(String... args) throws Exception {
        init(deliveryDao);
    }
}
