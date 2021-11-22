package com.grow.medicines.services;

import com.grow.medicines.exceptions.InsufficientAmountException;
import com.grow.medicines.exceptions.MedicineNotFoundException;
import com.grow.medicines.models.Medicine;
import com.grow.medicines.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public Medicine findByIdMedicine(String id) {
        return medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(
                        "No se encontró un medicamento con el id: " + id));
    }

    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public List<Medicine> findAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine updateMedicine(Medicine medicine, String id) {
        Medicine medicine1 = medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(
                        "No se encontró un medicamento con el id: " + id));

        medicine1.setName(medicine.getName());
        medicine1.setAmount(medicine.getAmount());
        medicine1.setRecommendations(medicine.getRecommendations());

        return medicineRepository.save(medicine1);
    }

    public Optional<Medicine> deleteMedicine(String id) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        medicineRepository.deleteById(id);
        return  medicine;
    }

    public Medicine addAmountMedicine(Integer amount, String id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(
                        "No se encontró un medicamento con el id: " + id));

        medicine.setAmount(medicine.getAmount() + amount);

        return medicineRepository.save(medicine);
    }

    public Medicine reduceAmountMedicine(Integer amount, String id) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(
                        "No se encontró un medicamento con el id: " + id));

        if (medicine.getAmount() < amount) {
            throw new InsufficientAmountException("La cantidad de medicina solicitada es mayor que hay en stock");
        }

        medicine.setAmount(medicine.getAmount() - amount);

        return medicineRepository.save(medicine);
    }
}
