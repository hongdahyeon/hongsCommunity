package hongs.community.hongsCommunity.domain.verify.dto;

import lombok.Getter;
import lombok.Setter;

/**
* @fileName HongVerifyCheckDto
* @author dahyeon
* @version 1.0.0
* @date 2024-04-26
* @summary  사용자의 비밀번호가 만료되어 비밀번호를 연장 혹은 변경한다.
**/

@Getter @Setter
public class HongVerifyCheckDto {

    private String userId;
    private String userEmail;
    private String verifyCode;
}
