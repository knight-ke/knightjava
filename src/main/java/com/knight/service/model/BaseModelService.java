package com.knight.service.model;

import com.knight.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseModelService {

    Mapper mapper;

    public boolean isParentDiagram(String diagramId){
        mapper.add(diagramId);
        return true;
    }

    public void delResource(String diagramId){
        if(isParentDiagram(diagramId)){
            delEntity();
        }else {
            delResourceInSubDiagram();
        }
    }

    public void delResourceInParentDiagram(){
        delEntity();
        delWholeSubDiagram();
        delBrotherElement();
        delRela();
    }

    private void delBrotherElement() {
    }

    public void delWholeSubDiagram(){

    }

    public void delResourceInSubDiagram(){
        delRela();
        delBrother();
    }

    public void delBrother(){

    }

    public abstract void delEntity();
    public abstract void delRela();
}
