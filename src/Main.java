import dataBase.GenerateId;
import enums.Gender;
import enums.Position;
import models.Employee;
import models.Medicine;
import models.Pharmacy;
import service.EmployeeService;
import service.MedicineService;
import service.PharmacyService;
import serviceImpl.EmployeeServiceImpl;
import serviceImpl.MedicineServiceImpl;
import serviceImpl.PharmacyServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        MedicineService medicineService = new MedicineServiceImpl();
        PharmacyService pharmacyService = new PharmacyServiceImpl();

        boolean exit = false;
        while (!exit){
        System.out.println(""" 
                                                               
                                                        6.  Добавить лекарство в аптеку                        14. Добавить сотрудника
                1. Добавить аптеку                      7.  Посмотреть лекарства в аптеке                      15. Назначить сотрудника
                2. Посмотреть все аптеки                8.  Посмотреть 1 лекарство                             16. Посмотреть всех сотрудников из аптеки
                3. Посмотреть аптеку                    9.  Обновить лекарство                                 17. Посмотреть 1 сотрудника
                4. Обновить аптеку                      10. Удалить лекарство                                  18. Обновить сотрудника
                5. Удалить аптеку                       11. Сортировка лекарства по цене                       19. Удалить сотрудника
                                                        12. Сортировка лекарства по дате выпуска               20. Фильтрация сотрудника по позициям
                0. выйти                                13. Сортировка по сроку действия
                
                                                                    * выберите команду *  
                """);
            switch (new Scanner(System.in).nextLine()){
                case "1":{
                    Pharmacy pharmacy = new Pharmacy();
                    System.out.println("Введите название аптеки: ");
                    pharmacy.setName(new Scanner(System.in).nextLine());
                    System.out.println("Введите адрес аптеки: ");
                    pharmacy.setAddress(new Scanner(System.in).nextLine());
                    pharmacy.setId(GenerateId.genPharmacyId());
                    System.out.println("ID аптеки '"+pharmacy.getName()+"' : "+pharmacy.getId());
                    System.out.println(pharmacyService.savePharmacy(pharmacy));
                    break;
                }
                case "2":{
                    System.out.println(pharmacyService.getAllPharmacy());
                    break;
                }
                case "3":{
                    System.out.println("введите ID аптеки которую хотите посмотреть: ");
                    System.out.println(pharmacyService.getById(new Scanner(System.in).nextLong()));
                    break;
                }
                case "4":{
                    Pharmacy pharmacy = new Pharmacy();
                    System.out.println("Введите ID аптеки которую хотоите обновить: ");
                    pharmacy.setId(new Scanner(System.in).nextLong());
                    System.out.println("Введите название новой аптеки: ");
                    pharmacy.setName(new Scanner(System.in).nextLine());
                    System.out.println("Введите адрес новой аптеки: ");
                    pharmacy.setAddress(new Scanner(System.in).nextLine());
                    System.out.println(pharmacyService.updatePharmacyById(pharmacy.getId(), pharmacy));
                    break;
                }
                case "5":{
                    System.out.println("Введите ID аптеки которую хотите удалить: ");
                    System.out.println(pharmacyService.deletePharmacyById(new Scanner(System.in).nextLong()));
                    break;
                }
                case "6":{
                    Medicine medicine = new Medicine();
                    System.out.println("Введите ID аптеки в которую хотите добавить лекарство: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Введите название лекарства: ");
                    medicine.setName(new Scanner(System.in).nextLine());
                    System.out.println("Введите описание лекарства: ");
                    medicine.setDescription(new Scanner(System.in).nextLine());
                    System.out.println("Введите цену на лекарство: ");
                    medicine.setPrice(new Scanner(System.in).nextInt());
                    System.out.println("Введите количество лекарства: ");
                    medicine.setQuantity(new Scanner(System.in).nextInt());
                    System.out.println("Введите дату изготовления лекарства: -год-месяц-день- ");
                    medicine.setExpirationDate(LocalDate.of(new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt()));
                    System.out.println("Введите дату поставки лекарства: -год-месяц-день-");
                    medicine.setDateOfDelivery(LocalDate.of(new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt()));
                    medicine.setId(GenerateId.genMedicineId());
                    System.out.println(medicineService.addMedicineToPharmacy(id, medicine));
                    break;
                }
                case "7":{
                    System.out.println("Введите ID аптеки в котрой хотите посмотреть лекарства: ");
                    System.out.println(medicineService.getAllMedicineByPharmacyId(new Scanner(System.in).nextLong()));
                    break;
                }
                case "8":{
                    System.out.println("Введите ID апттеки и ID лекарства: ");
                    System.out.println(medicineService.getByIdMedicine(new Scanner(System.in).nextLong(), new Scanner(System.in).nextLong()));
                    break;
                }
                case "9":{
                    Medicine medicine = new Medicine();
                    System.out.println("Введите ID аптеки в которой хотите обновить лекарство: ");
                    Long pharmacyID = new Scanner(System.in).nextLong();
                    System.out.println("Введите ID лекарства которую нужно обновить: ");
                    medicine.setId(new Scanner(System.in).nextLong());
                    System.out.println("Введите новое название лекарства: ");
                    medicine.setName(new Scanner(System.in).nextLine());
                    System.out.println("Введите новое описание лекарства: ");
                    medicine.setDescription(new Scanner(System.in).nextLine());
                    System.out.println("Введите новую цену на лекарство: ");
                    medicine.setPrice(new Scanner(System.in).nextInt());
                    System.out.println("Введите новое количество лекарства: ");
                    medicine.setQuantity(new Scanner(System.in).nextInt());
                    System.out.println("Введите новую дату изготовления лекарства: -год-месяц-день- ");
                    medicine.setExpirationDate(LocalDate.of(new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt()));
                    System.out.println("Введите новую дату поставки лекарства: -год-месяц-день-");
                    medicine.setDateOfDelivery(LocalDate.of(new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt()));
                    System.out.println(medicineService.updateMedicineById(pharmacyID, medicine.getId(), medicine));
                    break;
                }
                case "10":{
                    System.out.println("Введите ID аптеки в котрой нужно удалить лекарство и ID  самого лекарства: ");
                    System.out.println(medicineService.deleteMedicineById(new Scanner(System.in).nextLong(), new Scanner(System.in).nextLong()));
                    break;
                }
                case "11":{
                    System.out.println("Выберите сортировку:\n" +
                            "1) до 200 \n" +
                            "2) до 500 \n"+
                            "3) до 1000 \n");
                    System.out.println(medicineService.sortByPrice(new Scanner(System.in).nextLine()));
                    break;
                }
                case "12":{
                    System.out.println(""" 
                            Введите по какому направлению хотите сортировку:  1. по возрастанию
                                                                              2. по убыванию
                            """);
                    System.out.println(medicineService.sortByExpiration(new Scanner(System.in).nextLine()));
                    break;
                }
                case "13":{
                    System.out.println(""" 
                            Введите по какому направлению хотите сортировку:  1. по возрастанию
                                                                              2. по убыванию
                            """);
                    System.out.println(medicineService.sortByDeliveryDate(new Scanner(System.in).nextLine()));
                    break;
                }
                case "14":{
                    Employee employee = new Employee();
                    System.out.println("Введите ФиО: ");
                    employee.setFullName(new Scanner(System.in).nextLine());

                    boolean isEmailTrue = false;
                    while (!isEmailTrue){
                        System.out.println("Введите email: ");
                        String email = new Scanner(System.in).nextLine();
                        if (email.contains("@")){
                            employee.setEmail(email);
                            isEmailTrue = true;
                        }else {
                            System.out.println("email обязательно должен содержать '@' ");
                        }
                    }
                    System.out.println("Введите номер: ");
                    employee.setPhoneNumber(new Scanner(System.in).nextLine());
                    System.out.println("Введите позицию: 1) ADMIN\n"+
                            "                 2) PHARMACIST\n" +
                            "                 3) TELLER\n");
                    boolean isTrue = false;
                    while (!isTrue){
                        try {
                            employee.setPosition(Position.valueOf(new Scanner(System.in).nextLine()));
                            isTrue = true;
                        }catch (IllegalArgumentException e){
                            System.out.println("такого знаечния нет, введите снова");
                        }
                    }
                    System.out.println("Введите опыт работы: ");
                    employee.setExperience(new Scanner(System.in).nextDouble());
                    System.out.println("Введите гендер: F или M");
                    boolean istrue = false;
                    while (!istrue){
                        try {
                            employee.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
                            istrue = true;
                        }catch (IllegalArgumentException e){
                            System.out.println("такого знаечния нет, введите снова");
                        }
                    }
                    employee.setId(GenerateId.genEmployeeId());
                    System.out.println("ID сотрудника: "+employee.getId());
                    System.out.println(employeeService.saveEmployee(employee));
                    break;
                }
                case "15":{
                    System.out.println("Введите ID аптеки в которую нужно назначить сотрудника: ");
                    Long pharmacyID = new Scanner(System.in).nextLong();
                    System.out.println("Введите ID сотрудника которго нужно назначить: ");
                    Long employeeId = new Scanner(System.in).nextLong();
                    System.out.println(employeeService.assignEmployeeToPharmacy(pharmacyID, employeeId));
                    break;
                }
                case "16":{
                    System.out.println("Введите ID аптеки из которой хотите посмотреть всех сотрудников: ");
                    System.out.println(employeeService.getAllEmployee(new Scanner(System.in).nextLong()));
                    break;
                }
                case "17":{
                    System.out.println("Введите ID сотрудника котрого хотите посмотреть: ");
                    Long employeeId = new Scanner(System.in).nextLong();
                    System.out.println(employeeService.getByIdEmployee(employeeId));
                    break;
                }
                case "18":{
                    Employee employee = new Employee();
                    System.out.println("Введите ID  аптеки в котрой нужно обновить сотрудника: ");
                    Long pharmacyID = new Scanner(System.in).nextLong();
                    System.out.println("Введите ID сотрудника котрого нужно обновить: ");
                    Long employeeId = new Scanner(System.in).nextLong();
                    System.out.println("Введите новое ФиО: ");
                    employee.setFullName(new Scanner(System.in).nextLine());
                    boolean isEmailTrue = false;
                    while (!isEmailTrue){
                        System.out.println("Введите новый email: ");
                        String email = new Scanner(System.in).nextLine();
                        if (email.contains("@")){
                            employee.setEmail(email);
                            isEmailTrue = true;
                        }else {
                            System.out.println("email обязательно должен содержать '@'");
                        }
                    }
                    System.out.println("Введите новый номер: ");
                    employee.setPhoneNumber(new Scanner(System.in).nextLine());
                    System.out.println("Введите новую позицию:  ADMIN\n"+
                            "                        PHARMACIST\n" +
                            "                        TELLER\n");
                    boolean isTrue = false;
                    while (!isTrue){
                        try {
                            employee.setPosition(Position.valueOf(new Scanner(System.in).nextLine()));
                            isTrue = true;
                        }catch (IllegalArgumentException e){
                            System.out.println("такого знаечния нет, введите снова");
                        }
                    }
                    System.out.println("Введите опыт работы: ");
                    employee.setExperience(new Scanner(System.in).nextDouble());
                    System.out.println("Введите гендер: F или M");
                    boolean istrue = false;
                    while (!istrue){
                        try {
                            employee.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
                            istrue = true;
                        }catch (IllegalArgumentException e){
                            System.out.println("такого знаечния нет, введите снова");
                        }
                    }
                    System.out.println(employeeService.updateEmployeeById(pharmacyID, employeeId, employee));
                    break;
                }
                case "19":{
                    System.out.println("Введите ID аптеки в которой нужно удалить сотрудника : ");
                    Long pharmacyID = new Scanner(System.in).nextLong();
                    System.out.println("Введите ID самого сотрудника: ");
                    Long employeeID = new Scanner(System.in).nextLong();
                    System.out.println(employeeService.deleteEmployeeById(pharmacyID, employeeID));
                    break;
                }
                case "20":{
                    System.out.println("""
                            выберите по какой позиции фильтровать сотрудников: 
                                                                                1. admins (админы)
                                                                                2. pharmacists (фармацевты)
                                                                                3. tellers (кассиры)
                            """);
                    System.out.println(employeeService.filterEmployeeByPosition(new Scanner(System.in).nextLine()));
                    break;
                }
                case "0":{
                    exit = true;
                    break;
                }
                default:
                    System.out.println("такой опции нет");

            }
        }
    }
}