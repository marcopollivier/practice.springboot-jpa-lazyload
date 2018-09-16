package com.github.marcopollivier.avenuecode.productmanager.app.controller.dto;

import com.github.marcopollivier.avenuecode.productmanager.app.domain.model.Image;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(value = XmlAccessType.NONE)
public class ImageDTO {

    @XmlAttribute
    @ApiModelProperty(value = "Image id", hidden = true)
    private Long id;

    @XmlAttribute
    @ApiModelProperty(value = "Image type", example = "Main image")
    private String type;

    public ImageDTO() {
    }

    public ImageDTO(Long id, String type) {
        this.type = type;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Image toEntity() {
        return new Image(this.type);
    }

}
