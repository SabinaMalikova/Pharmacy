package service;

import models.Pharmacy;

import java.util.List;

public interface PharmacyService {
    String savePharmacy(Pharmacy pharmacy);
    List<Pharmacy> getAllPharmacy();
    Pharmacy getById(Long pharmacyId);
    String updatePharmacyById(Long pharmacyId, Pharmacy newPharmacyId);
    String deletePharmacyById(Long pharmacyId);

}
