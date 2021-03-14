package ru.dreamteam.mockForAngular.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dreamteam.mockForAngular.domain.DeliveryJson;
import ru.dreamteam.mockForAngular.exception.ResourceNotFoundException;
import ru.dreamteam.mockForAngular.mockDao.DeliveryDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DeliveryController {

	private final DeliveryDao deliveryDao;

	public DeliveryController(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}

	@GetMapping("/deliveries")
	public List<DeliveryJson> getAllDeliveries() {
		return deliveryDao.findAll();
	}

	@GetMapping(value = "/deliveries/{id}")
	public ResponseEntity<DeliveryJson> getDeliveryById(@PathVariable(value = "id") Long deliveryId)
			throws ResourceNotFoundException {
		DeliveryJson delivery = deliveryDao.findById(deliveryId)
				.orElseThrow(() -> new ResourceNotFoundException("Поставка по указанному id не найдена:  id = " + deliveryId));
		return ResponseEntity.ok().body(delivery);
	}

	@PostMapping("/deliveries/new")
	public DeliveryJson createDelivery(@RequestBody DeliveryJson delivery) {
		return deliveryDao.save(delivery);
	}

	@PutMapping("/deliveries/{id}")
	public ResponseEntity<DeliveryJson> updateDelivery(@PathVariable(value = "id") Long deliveryId,
			@RequestBody DeliveryJson deliveryDetails) throws ResourceNotFoundException {
		DeliveryJson delivery = deliveryDao.findById(deliveryId)
				.orElseThrow(() -> new ResourceNotFoundException("Поставка по указанному id не найдена:  id = " + deliveryId));
		delivery.updateAllFieldsWithoutId(deliveryDetails);
		return ResponseEntity.ok(delivery);
	}

	@DeleteMapping("/deliveries/{id}")
	public Map<String, Boolean> deleteDelivery(@PathVariable(value = "id") Long deliveryId)
			throws ResourceNotFoundException {
		DeliveryJson delivery = deliveryDao.findById(deliveryId)
				.orElseThrow(() -> new ResourceNotFoundException("Поставка по указанному id не найдена:  id = " + deliveryId));

		deliveryDao.delete(delivery);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
