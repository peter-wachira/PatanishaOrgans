import org.sql2o.Connection;

import java.util.List;

public class Donor {
    private String name;
    private String bloodGroup;
    private String organ;
    private int id;
    private int doctorId;

    public Donor(String name, String bloodGroup, String organ, int doctorId) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.organ = organ;
        this.doctorId= doctorId;

    }

    public String getName() {
        return name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getOrgan() {
        return organ;
    }

    public int getId() {
        return id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public static List<Donor> all() {
        String sql = "SELECT id, name, bloodgroup, organ, doctorId FROM donor";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Donor.class);
        }
    }

    @Override
    public boolean equals(Object otherDonor) {
        if (!(otherDonor instanceof Donor)) {
            return false;
        } else {
            Donor newDonor = (Donor) otherDonor;
            return this.getName().equals(newDonor.getName())&&
                    this.getBloodGroup().equals(newDonor.getBloodGroup())&&
                    this.getDoctorId() == newDonor.getDoctorId()&&
                    this.getOrgan().equals(newDonor.getOrgan())&&
                    this.getId()== newDonor.getId();
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO donor (name, bloodgroup, organ, doctorid) VALUES (:name, :bloodgroup, :organ, :doctorid)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("bloodgroup", this.bloodGroup)
                    .addParameter("organ", this.organ)
                    .addParameter("doctorid", this.doctorId)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static Donor find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM donor where id=:id";
            Donor donor = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Donor.class);
            return donor;
        }

    }
}





