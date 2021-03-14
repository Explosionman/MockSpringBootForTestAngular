package ru.dreamteam.mockForAngular.mockDao;

import org.springframework.stereotype.Service;
import ru.dreamteam.mockForAngular.domain.DeliveryJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryDao {
    private List<DeliveryJson> deliveryDaoList = new ArrayList<>();

    public List<DeliveryJson> findAll() {
        return deliveryDaoList;
    }

    public Optional<DeliveryJson> findById(Long id) {

        for (DeliveryJson deliveryJson : deliveryDaoList) {
            if (deliveryJson.getId().equals(id)) {
                return Optional.of(deliveryJson);
            }
        }
        return Optional.empty();
    }

    public DeliveryJson save(DeliveryJson delivery) {
        deliveryDaoList.add(delivery);
        return delivery;
    }

    public void delete(DeliveryJson delivery) {
        deliveryDaoList.remove(delivery);
    }

}
