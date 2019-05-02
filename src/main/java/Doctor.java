import java.util.List;
import org.sql2o.*;

import javax.print.Doc;

public class Doctor {
    private String name;
    private String hospital;
    private String contact;
    private int id;

    public String getContact() {
        return contact;
    }

    public Doctor(String name, String hospital, String contact) {
        this.name = name;
        this.hospital = hospital;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getHospital() {
        return hospital;
    }
    public int getId() {
        return id;
    }

    public static List<Doctor> all() {
        String sql = "SELECT id, name, hospital, contact FROM doctor";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Doctor.class);
        }
    }
    @Override
    public boolean equals(Object otherDoctor) {
        if (!(otherDoctor instanceof Doctor)) {
            return false;
        } else {
            Doctor newDoctor = (Doctor) otherDoctor;
            return this.getName().equals(newDoctor.getName())&&
                    this.getHospital().equals(newDoctor.getHospital())&&
                    this.getContact().equals(newDoctor.getContact())&&
                    this.getId()==newDoctor.getId();
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO doctor (name, hospital, contact) VALUES (:name, :hospital, :contact)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("hospital", this.hospital)
                    .addParameter("contact", this.contact)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static Doctor find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM doctor where id=:id";
            Doctor doctor = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Doctor.class);
            return doctor;
        }
    }




}