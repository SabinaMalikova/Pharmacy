package serviceImpl;

import dataBase.DataBase;
import models.MyException;
import models.Pharmacy;
import service.PharmacyService;

import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {
    @Override
    public String savePharmacy(Pharmacy pharmacy) {
        DataBase.pharmacies.add(pharmacy);
        return "успешно добавлено";
    }

    @Override
    public List<Pharmacy> getAllPharmacy() {
        return DataBase.pharmacies;
    }

    @Override
    public Pharmacy getById(Long pharmacyId) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    return pharmacy;
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updatePharmacyById(Long pharmacyId, Pharmacy newPharmacyId) {
        try {
            for (int i = 0; i < DataBase.pharmacies.size(); i++) {
                Pharmacy pharmacy = DataBase.pharmacies.get(i);
                if (pharmacy.getId() == pharmacyId) {
                    DataBase.pharmacies.set(i, newPharmacyId);
                    return "успешно обновлено";
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletePharmacyById(Long pharmacyId) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    DataBase.pharmacies.remove(pharmacy);
                    return "успешно удалено";
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            return e.getMessage();
        }
    }
}
