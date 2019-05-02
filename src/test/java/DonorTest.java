import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class DonorTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void classDonorInstatiatesCorrectly() {
        Donor testDonor = new Donor("Yasmin", "O+", "Kidney", 1);
        assertEquals(true, testDonor instanceof Donor);
    }

    @Test
    public void getNameInstantiatesWithName_String() {
        Donor testDonor = new Donor("Yasmin", "O+", "Kidney", 1);
        assertEquals("Yasmin", testDonor.getName());
    }

    @Test
    public void getBloodgroupInstantiatesWithBloodGroup_String() {
        Donor testDonor = new Donor("Yasmin", "O+", "Kidney", 1);
        assertEquals("O+", testDonor.getBloodGroup());
    }

    @Test
    public void getOrganInstantaitesWithOrgan_String() {
        Donor testDonor = new Donor("Yasmin", "A+", "Kidney", 1);
        assertEquals("Kidney", testDonor.getOrgan());
    }

    @Test
    public void equals_returnsTrueIfDetailsAretheSame() {
        Donor firstDonor = new Donor("Yasmin", "A+", "Kidney", 1);
        Donor secondDonor = new Donor("Yasmin", "A+", "Kidney", 1);
        assertTrue(firstDonor.equals(secondDonor));
    }

    @Test
    public void save_returnsTrueIfDetailsAretheSame() {
        Donor myDonor = new Donor("Yasmin", "A+", "Kidney", 1);
        myDonor.save();
        assertTrue(Donor.all().get(0).equals(myDonor));
    }

    @Test
    public void all_returnsAllInstancesOfDonor_true() {
        Donor firstDonor = new Donor("Yasmin", "A+", "Kidney", 1);
        firstDonor.save();
        Donor secondDonor = new Donor("Peter", "O+", "Liver", 1);
        secondDonor.save();
        assertEquals(true, Donor.all().get(0).equals(firstDonor));
        assertEquals(true, Donor.all().get(1).equals(secondDonor));
    }

    @Test
    public void save_assignsIdToObject() {
        Donor myDonor = new Donor("Yasmin", "A+", "Kidney", 1);
        myDonor.save();
        Donor savedDonor = Donor.all().get(0);
        assertEquals(myDonor.getId(), savedDonor.getId());
    }

    @Test
    public void getId_tasksInstantiateWithAnID() {
        Donor myDonor = new Donor("Yasmin", "A+", "Kidney", 1);
        myDonor.save();
        assertTrue(myDonor.getId() > 0);
    }

    @Test
    public void find_returnsDonorWithSameId_secondDonor() {
        Donor firstDonor = new Donor("Yasmin", "A+", "Kidney", 1);
        firstDonor.save();
        Donor secondDonor = new Donor("Peter", "A+", "Liver", 2);
        secondDonor.save();
        assertEquals(Donor.find(secondDonor.getId()), secondDonor);
    }
    @Test
    public void delete_deletesDonor() {
        Donor testDonor = new Donor("Tosh", "A+","Kidney",1);
        testDonor.save();
        testDonor.delete();
        assertEquals(0, Donor.all().size());
    }
    @Test
    public void update_updatesStylist_true() {
        Donor myDonor = new Donor("Yasmin", "A+","Kidney",1);
        myDonor.save();
        myDonor.update("Tosh", "A+", "Kidney", 1);
        assertEquals("Tosh", Donor.find(myDonor.getId()).getName());
    }







}
