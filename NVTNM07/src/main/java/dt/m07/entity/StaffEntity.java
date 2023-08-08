package dt.m07.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Staffs")
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    private String staffName;

    private String staffAddress;

    private String phone;

    private String email;

    @OneToMany
    @JoinColumn(name = "NewsId")
    private List<NewEntity> newEntities;


    public List<NewEntity> getNewEntities() {
        return newEntities;
    }

    public void setNewEntities(List<NewEntity> newEntities) {
        this.newEntities = newEntities;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
