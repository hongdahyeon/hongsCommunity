package hongs.community.hongsCommunity.domain.team.team.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HongTeamUserListVo {

    private Long hongTeamUserUid;
    private Long hongTeamUid;
    private String teamNm;
    private Long userUid;
    private String userNm;
    private String userEmail;
    private String userRole;
    private String joinDt;
    private String aprvYn;
    private String aprvYnStr;
}
