package hongs.community.hongsCommunity.domain.team.admin.vo;

import lombok.Getter;
import lombok.Setter;

/**
* @fileName HongTeamUserAdminListVo
* @author dahyeon
* @version 1.0.0
* @date 2024-05-13
* @summary   팀 관리 : 팀 멤버 리스트 조회
 *              -> 삭제여부 N
**/

@Getter @Setter
public class HongTeamUserAdminListVo {

    private Long userUid;
    private String userNm;
    private String userEmail;
    private Long hongTeamUid;
    private String userRole;
    private String userRoleName;
    private String rprsvYnStr;         // 대표자 or 팀원
    private String aprvYnStr;          // 승인여부 str
    private String joinDt;
}
