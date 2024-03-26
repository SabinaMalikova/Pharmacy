package service;

import models.Medicine;

import java.util.List;

public interface MedicineService {
    String addMedicineToPharmacy(Long pharmacyId, Medicine medicine);
    List<Medicine>getAllMedicineByPharmacyId(Long pharmacyId);
    Medicine getByIdMedicine(Long pharmacyId, Long medicineId);
    String updateMedicineById(Long pharmacyId, Long medicineId, Medicine newMedicine);
    String deleteMedicineById(Long pharmacyId, Long medicineId);

    List<Medicine>sortByPrice(String ascOrDesc);
    List<Medicine>sortByDeliveryDate(String ascOrDesc);
    List<Medicine>sortByExpiration(String ascOrDesc);


}
