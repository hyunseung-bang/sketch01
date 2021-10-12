package com.sketch01.api.opm.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuDto {
    private String menuId;
    private String menuName;
    private String vueFileId;
    private String vueFilePath;
    private List<MenuDto> items = new ArrayList<>();

    public MenuDto(String menuId, String menuName, String vueFileId, String vueFilePath, List<MenuDto> items) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.vueFileId = vueFileId;
        this.vueFilePath = vueFilePath;
        this.items = items;
    }

    public void addItems(MenuDto item) {
        items.add(item);
    }

}
