package dataBase;

public class GenerateId {
    public static Long medicineId = 0L;
    public static Long pharmacyId= 0L;
    public static Long employeeId= 0L;

    public static long genMedicineId (){
        return ++medicineId;
    }

    public static long genPharmacyId (){
        return ++pharmacyId;
    }

    public static long genEmployeeId (){
        return ++employeeId;
    }
}
