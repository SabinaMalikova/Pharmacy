package serviceImpl;

import dataBase.DataBase;
import models.Medicine;
import models.MyException;
import models.Pharmacy;
import service.MedicineService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MedicineServiceImpl implements MedicineService {
    @Override
    public String addMedicineToPharmacy(Long pharmacyId, Medicine medicine) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    pharmacy.getMedicines().add(medicine);
                    return "успешно добавлено";
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Medicine> getAllMedicineByPharmacyId(Long pharmacyId) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    return pharmacy.getMedicines();
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Medicine getByIdMedicine(Long pharmacyId, Long medicineId) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    try {
                        for (Medicine medicine : pharmacy.getMedicines()) {
                            if (medicine.getId() == medicineId) {
                                return medicine;
                            }
                        }
                        throw new MyException("лекарство с таким ID не найдена");
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateMedicineById(Long pharmacyId, Long medicineId, Medicine newMedicine) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    try {
                        for (int i = 0; i < pharmacy.getMedicines().size(); i++) {
                            Medicine medicine = pharmacy.getMedicines().get(i);
                            if (medicine.getId() == medicineId) {
                                pharmacy.getMedicines().set(i, newMedicine);
                                return "успешно обновлено";
                            }
                        }
                        throw new MyException("лекарство с таким ID не найдена");
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteMedicineById(Long pharmacyId, Long medicineId) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    try {
                        for (Medicine medicine : pharmacy.getMedicines()) {
                            if (medicine.getId() == medicineId) {
                                pharmacy.getMedicines().remove(medicine);
                                return "успешно удалено";
                            }
                        }
                        throw new MyException("лекарство с таким ID не найдена");
                    } catch (MyException e) {
                        return e.getMessage();
                    }
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            return e.getMessage();
        }

    }

    @Override
    public List<Medicine> sortByPrice(String ascOrDesc) {
        List<Medicine> cheaperThan200 = new ArrayList<>();
        List<Medicine> cheaperThan500 = new ArrayList<>();
        List<Medicine> cheaperThan1000 = new ArrayList<>();

        if (ascOrDesc.equals("1")) {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                for (Medicine medicine : pharmacy.getMedicines()) {
                    if (medicine.getPrice() <= 200) {
                        cheaperThan200.add(medicine);
                    }
                }
                return cheaperThan200;
            }
        } else if (ascOrDesc.equals("2")) {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                for (Medicine medicine : pharmacy.getMedicines()) {
                    if (medicine.getPrice() <= 500) {
                        cheaperThan500.add(medicine);
                    }
                }
                return cheaperThan500;
            }
        } else if (ascOrDesc.equals("3")) {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                for (Medicine medicine : pharmacy.getMedicines()) {
                    if (medicine.getPrice() <= 1000) {
                        cheaperThan1000.add(medicine);
                    }
                }
                return cheaperThan1000;
            }
        }
        return null;
    }

    @Override
    public List<Medicine> sortByDeliveryDate(String ascOrDesc) {
        try {
            if (ascOrDesc.equals("1")) {
                for (Pharmacy pharmacy : DataBase.pharmacies) {
                    Collections.sort(pharmacy.getMedicines(), Comparator.comparing(Medicine::getDateOfDelivery));
                    return pharmacy.getMedicines();
                }
            }
            if (ascOrDesc.equals("2")) {
                for (Pharmacy pharmacy : DataBase.pharmacies) {
                    Collections.sort(pharmacy.getMedicines(), Comparator.comparing(Medicine::getDateOfDelivery).reversed());
                    return pharmacy.getMedicines();
                }
            }
            throw new MyException("такого выбора нет");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Medicine> sortByExpiration(String ascOrDesc) {
        try {
            if (ascOrDesc.equals("1")) {
                for (Pharmacy pharmacy : DataBase.pharmacies) {
                    Collections.sort(pharmacy.getMedicines(), Comparator.comparing(Medicine::getExpirationDate));
                    return pharmacy.getMedicines();
                }
            }
            if (ascOrDesc.equals("2")) {
                for (Pharmacy pharmacy : DataBase.pharmacies) {
                    Collections.sort(pharmacy.getMedicines(), Comparator.comparing(Medicine::getExpirationDate).reversed());
                    return pharmacy.getMedicines();
                }
            }
            throw new MyException("такого выбора нет");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
