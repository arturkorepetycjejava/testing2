package pl.arturzaczek.testing2.jpa.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessToken {
    private int userId;
    private String userName;
    private ProfileType profileType;
}
