package com.jyw.system.dto;

import com.jyw.model.AnthortyInfo;

import java.util.List;
/**
 * Created by rayya on 2016/11/9.
 */
public class AnthortyDTO {
    private AnthortyInfo anth;
    private List<AnthortyInfo> list;

    public AnthortyInfo getAnth() {
        return anth;
    }

    public void setAnth(AnthortyInfo anth) {
        this.anth = anth;
    }

    public List<AnthortyInfo> getList() {
        return list;
    }

    public void setList(List<AnthortyInfo> list) {
        this.list = list;
    }
}
