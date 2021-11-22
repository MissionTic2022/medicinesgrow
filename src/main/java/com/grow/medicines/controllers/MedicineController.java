package com.grow.medicines.controllers;

import com.grow.medicines.models.Medicine;
import com.grow.medicines.services.MedicineService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/medicines/{id}")
    Medicine getMedicine(@PathVariable String id) {
        return medicineService.findByIdMedicine(id);
    }

    @GetMapping("/medicines")
    List<Medicine> getMedicines(){
        return medicineService.findAllMedicines();
    }

    @PostMapping("/medicines")
    Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineService.addMedicine(medicine);
    }

    @PutMapping("/medicines/{id}")
    Medicine updateMedicine(@RequestBody Medicine medicine, @PathVariable String id) {
        return medicineService.updateMedicine(medicine, id);
    }

    @PutMapping("/medicines/addamount/{id}")
    Medicine addAmountMedicine(@RequestBody Integer amount, @PathVariable String id) {
        return medicineService.addAmountMedicine(amount, id);
    }

    @PutMapping("/medicines/reduceamount/{id}")
    Medicine reduceAmountMedicine(@RequestBody Integer amount, @PathVariable String id) {
        return medicineService.reduceAmountMedicine(amount, id);
    }

    @DeleteMapping("/medicines/{id}")
    Optional<Medicine> deleteMedicine(@PathVariable String id) {
        return medicineService.deleteMedicine(id);
    }
}
