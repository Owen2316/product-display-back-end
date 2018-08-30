package com.ex.product.display.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author owen
 */
@MappedSuperclass
@Data
public class CommonColumn {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="creator")
    @JsonIgnoreProperties({"createdDate","modifiedDate","modifier","creator"})
    private User creator;

    @Column(nullable=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="modifier",nullable=false)
    @JsonIgnoreProperties({"createdDate","modifiedDate","modifier","creator"})
    private User modifier;

    @JoinColumn(nullable=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate = new Date();

    @Column(name = "isDelete", columnDefinition = "int(1) not null default 0")
    @JsonIgnore
    @Setter(AccessLevel.PROTECTED)
    @Getter(AccessLevel.PROTECTED)
    protected int deleteValue = 0;

    @JsonIgnore
    public boolean isDelete() {
        return this.getDeleteValue() == 1;
    }

    public void setDelete(boolean isDelete) {
        this.setDeleteValue(isDelete ? 1 : 0);
    }


}
