package ru.dreamteam.mockForAngular.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryJson {
    private Long id;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate deliveryDate;

    private String deliveryTime;

    private String carInfo;

    private String driverInfo;

    private String brand;

    private String orderNumber;

    private String deliveryType;

    private String sender;

    private String comment;

    private String shop;

    private String numberOfPlaces;

    private String torgNumber;

    private String invoice;

    public void updateAllFieldsWithoutId(DeliveryJson updatedDelivery) {
        this.deliveryDate = updatedDelivery.getDeliveryDate();
        this.deliveryTime = updatedDelivery.getDeliveryTime();
        this.carInfo = updatedDelivery.getCarInfo();
        this.driverInfo = updatedDelivery.getCarInfo();
        this.brand = updatedDelivery.getBrand();
        this.orderNumber = updatedDelivery.getOrderNumber();
        this.deliveryType = updatedDelivery.getDeliveryType();
        this.sender = updatedDelivery.getSender();
        this.comment = updatedDelivery.getComment();
        this.shop = updatedDelivery.getShop();
        this.numberOfPlaces = updatedDelivery.getNumberOfPlaces();
        this.torgNumber = updatedDelivery.getTorgNumber();
        this.invoice = updatedDelivery.getInvoice();
    }

}
