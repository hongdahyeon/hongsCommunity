package hongs.community.hongsCommunity.domain.user.front.vo;

import hongs.community.hongsCommunity.domain.menu.vo.HongMenuVo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
* @fileName HongLoginUserVo
* @author dahyeon
* @version 1.0.0
* @date 2024-05-03
* @summary 로그인 사용자 vo
**/

@Getter @Setter
public class HongLoginUserVo {

    private Long userUid;
    private Long socialUserUid;
    private String userId;
    private String password;
    private String userName;
    private String userEmail;
    private String role;
    private Boolean isEnable;
    private String pwdLastUpdate;
    private String lastLoginDate;
    private Boolean isNonLocked;

    private List<HongMenuVo> menu = new ArrayList<>();
}