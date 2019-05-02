import org.junit.Rule;
import org.junit.Test;

import javax.print.Doc;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class DoctorTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void classDoctors_instantatesCorrectlyTrue(){
        Doctor testDoctor = new Doctor("Peter","AgaKhan","1234");
        assertEquals(true, testDoctor instanceof Doctor);
    }

    @Test
    public void getNameInstantiateswithName_String(){
        Doctor testDoctor = new Doctor("Peter", "Nairobi","1234");
        assertEquals("Peter", testDoctor.getName());
    }

    @Test
    public void getHospitalInstantiatesWithHospital_String(){
        Doctor testDoctor = new Doctor("Peter","AgaKhan", "1234");
        assertEquals("AgaKhan", testDoctor.getHospital());
    }
    @Test
    public void getContactInstantiatesWithContact_String(){
        Doctor testDoctor = new Doctor("Peter","AgaKhan", "1234");
        assertEquals("1234", testDoctor.getContact());
    }
    @Test
    public void equals_returnsTrueIfDescriptionsAretheSame() {
        Doctor firstDoctor = new Doctor("Tosh","Mater","1234");
        Doctor secondDoctor = new Doctor("Tosh","Mater","1234");
        assertTrue(firstDoctor.equals(secondDoctor));
    }
    @Test
    public void save_returnsTrueIfNameandHospitalAretheSame() {
        Doctor myDoctor = new Doctor("John","Nairobi","1234");
        myDoctor.save();
        assertTrue(Doctor.all().get(0).equals(myDoctor));
    }
    @Test
    public void all_returnsAllInstancesOfDoctor_true() {
        Doctor firstDoctor = new Doctor("John","Nairobi","1234");
        firstDoctor.save();
        Doctor secondDoctor = new Doctor("Peter","AgaKhan","4567");
        secondDoctor.save();
        assertEquals(true, Doctor.all().get(0).equals(firstDoctor));
        assertEquals(true, Doctor.all().get(1).equals(secondDoctor));
    }
    @Test
    public void save_assignsIdToObject() {
        Doctor myDoctor = new Doctor ("John","Nairobi","12345");
        myDoctor.save();
        Doctor savedDoctor = Doctor.all().get(0);
        assertEquals(myDoctor.getId(), savedDoctor.getId());
    }
    @Test
    public void getId_doctorInstantiateWithAnID() {
        Doctor myDoctor = new Doctor("John","Nairobi","1234");
        myDoctor.save();
        assertTrue(myDoctor.getId() > 0);
    }
    @Test
    public void find_returnsDoctorWithSameId_secondDoctor() {
        Doctor firstDoctor = new Doctor("John","Nairobi","11223");
        firstDoctor.save();
        Doctor secondDoctor = new Doctor("Peter","AgaKhan","6789");
        secondDoctor.save();
        assertEquals(Doctor.find(secondDoctor.getId()), secondDoctor);
    }
    @Test
    public void delete_deletesDonor() {
        Doctor testDoctor = new Doctor("Tosh", "A+","1234");
        testDoctor.save();
        testDoctor.delete();
        assertEquals(0, Doctor.all().size());
    }
    @Test
    public void update_updatesStylist_true() {
        Doctor myDoctor = new Doctor("Yasmin", "A+","1234");
        myDoctor.save();
        myDoctor.update("Tosh", "A+", "1234");
        assertEquals("Tosh", Doctor.find(myDoctor.getId()).getName());
    }

}
