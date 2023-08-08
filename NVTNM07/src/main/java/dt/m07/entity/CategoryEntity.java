package dt.m07.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cateId;

    private String cateName;

    private String cateDesc;

    @OneToMany
    @JoinColumn(name = "NewsId")
    private List<NewEntity> newEntities;


    public List<NewEntity> getNewEntities() {
        return newEntities;
    }

    public void setNewEntities(List<NewEntity> newEntities) {
        this.newEntities = newEntities;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDesc() {
        return cateDesc;
    }

    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }
}
