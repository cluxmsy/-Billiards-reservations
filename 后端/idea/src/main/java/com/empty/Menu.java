package com.empty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String menu_name;
    private String path;
    private String perms;
    private Integer visible;
}
