import com.sda.dao.DoctorDao;
import com.sda.dao.EmailDao;
import com.sda.dao.HospitalDao;
import com.sda.dao.PatientDao;
import com.sda.model.Doctor;
import com.sda.model.Email;
import com.sda.model.Hospital;
import com.sda.model.Patient;
import com.sda.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static EmailDao emailDao;
    private static PatientDao patientDao;
    private static HospitalDao hospitalDao;
    private static DoctorDao doctorDao;

    public Main(){
        emailDao = new EmailDao();
        patientDao = new PatientDao();
        hospitalDao = new HospitalDao();
        doctorDao = new DoctorDao();
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            //main.createEmail();
            //main.createPatient();
            //main.updatePatientDetails();
            //main.deletePatient();
            //main.deleteEmail();
            //main.createDoctor();
            //main.createHospital();
            //main.updateDoctor();
            //main.getHospital();
            main.createDoctorList();
        } finally {
            HibernateUtil.close();
        }
    }

    public void createEmail(){
        Email email = new Email();
        email.setEmailAddress("Email@email.org");
        emailDao.createEntity(email);
    }

    public void createPatient(){
        Patient patient = new Patient();
        patient.setPatientName("OnoToOne2 Patient2");
        patient.setPatientAge(98L);
        Email email = new Email();
        email.setEmailAddress("testEmail2@hibernate2.ro");
        patient.setEmail(email);
        patientDao.createEntity(patient);
    }

    public void updatePatientDetails(){
        Patient patient = patientDao.getEntityById(3L, Patient.class);
        patient.setPatientName("Updated again Name");
        patient.setPatientAge(99L);
        patientDao.updateEntity(patient);
    }

    public void deletePatient(){
        Patient patient = patientDao.getEntityById(6L, Patient.class);
        patientDao.deleteEntity(patient);
    }

    public void deleteEmail(){
        Email email = emailDao.getEntityById(13L, Email.class);
        emailDao.deleteEntity(email);
    }

    public void createHospital(){
        Hospital hospital = new Hospital();
        hospital.setHospitalName("HospNo2");
        hospitalDao.createEntity(hospital);
    }

    public void createDoctor(){
        Doctor doctor = new Doctor();
        doctor.setDoctorName("DoctorNo2");
        Hospital hospital = hospitalDao.getEntityById(1L, Hospital.class);
        doctor.setHospital(hospital);
        doctorDao.createEntity(doctor);
    }

    public void updateDoctor(){
        Doctor doctor = doctorDao.getEntityById(4L, Doctor.class);
        doctor.setHospital(hospitalDao.getEntityById(2L, Hospital.class));
        doctorDao.updateEntity(doctor);
    }

//    public void getHospital(){
//        Hospital hospital = hospitalDao.getEntityById(1L,Hospital.class);
//        int i = 1;
//    }

    public void createDoctorList(){
        Hospital hospital = new Hospital();
        hospital.setHospitalName("Neuro");
        List<Doctor> doctors = new ArrayList<Doctor>();
        Doctor doctor1 = new Doctor();
        doctor1.setDoctorName("NeuroDoc1");
        doctor1.setHospital(hospital);
        Doctor doctor2 = new Doctor();
        doctor2.setDoctorName("NeuroDoc2");
        doctor2.setHospital(hospital);
        Doctor doctor3 = new Doctor();
        doctor3.setDoctorName("NeuroDoc3");
        doctor3.setHospital(hospital);
        Doctor doctor4 = new Doctor();
        doctor4.setDoctorName("NeuroDoc4");
        doctor4.setHospital(hospital);
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
        hospital.setDoctors(doctors);
        hospitalDao.createEntity(hospital);
    }
}
