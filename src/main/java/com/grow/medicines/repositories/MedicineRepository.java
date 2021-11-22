package com.grow.medicines.repositories;

import com.grow.medicines.models.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicineRepository extends MongoRepository<Medicine, String> {
}
